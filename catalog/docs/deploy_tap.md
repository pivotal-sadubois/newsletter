# Deploy on Kubernetes with Tanzu Application Platform (TAP)

## Create a Developer Namespace
Bevore you can install the Newletter Demo Applicaiotn you need to create a Developer Namespace. The procedure configures the following: 

Developer Namespace Configuration:
- Create a Namespace on the TAP Development Cluster
- Add secrets for the container registry used by the Tanzu Build Service (TBS)
- Label the namespace for the Namespace Provisioner Service in TAP

### Create TAP Developer Namespace in the Tanzu Demo Hub (TDH) Environment
Within the Tanzu Demo Hub environment (THD) a harbor registry has already been configured for the Tanzu Build Service (TBS) which 
can be used. Additionally a dockerPullsecret will be configured as h2o environents on vSphere usually run into a docker rate linit.
```
$ export TAP_DEVELOPER_NAMESPACE=newsletter
$ cd tanzu-demo-hub/scripts
$ ./tap-create-developer-namespace.sh $TAP_DEVELOPER_NAMESPACE
namespace created
namespace labeled
NAME                                 TYPE                                  DATA   AGE
secret/default-token-zc82w           kubernetes.io/service-account-token   3      74s
secret/grype-scanner-token-7wg2r     kubernetes.io/service-account-token   3      54s
secret/harbor-registry-credentials   kubernetes.io/dockerconfigjson        1      66s
secret/registries-credentials        kubernetes.io/dockerconfigjson        1      61s
secret/scanner-secret-ref            kubernetes.io/dockerconfigjson        1      54s
secret/vmware-registry-credentials   kubernetes.io/dockerconfigjson        1      64s

NAME                           SECRETS   AGE
serviceaccount/default         2         75s
serviceaccount/grype-scanner   4         55s

NAME                                                               ROLE                      AGE
rolebinding.rbac.authorization.k8s.io/default-permit-deliverable   ClusterRole/deliverable   62s
rolebinding.rbac.authorization.k8s.io/default-permit-workload      ClusterRole/workload      62s

NAME                         DATA   AGE
configmap/kube-root-ca.crt   1      76s
```

### Create TAP Developer according to the Documentation
To create a TAP Developer Namespace, please refer to the guide in the documentation and follow the procedure 
[Provision developer namespaces](https://docs.vmware.com/en/VMware-Tanzu-Application-Platform/1.5/tap/namespace-provisioner-provision-developer-ns.html). The following 
steps are summarized gere: 

```
$ export TAP_DEVELOPER_NAMESPACE=newsletter
$ kubectl create ns $TAP_DEVELOPER_NAMESPACE
$ kubectl label namespaces $TAP_DEVELOPER_NAMESPACE apps.tanzu.vmware.com/tap-ns=""
```
Create Secrets for the TAP registry used for the Tanzu Build Service (TBS).
```
$ tanzu secret registry add tap-registry-credentials \
  --server <REGISTRY_SERVER> \
  --username "<REGISTRY_USERNAME>" \
  --password "<$REGISTRY_PASSWORD>" \
  --namespace "<TAP_DEVELOPER_NAMESPACE>" \
  --verbose 0 >/dev/null 2>&1
```

## Newsletter Databaase (newsletter-db) - Deploy with Tanzu Application Platform (TAP) 
This section describes how to deploy a PostgreSQL Database directly from the 'Bitnami Services' integrated in Tanzu Application Platform (TAP). After the 
deployment application teams will be able to discover, claim, and bind services to their application workloads
[Working with Bitnami Services](https://docs.vmware.com/en/VMware-Tanzu-Application-Platform/1.5/tap/bitnami-services-tutorials-working-with-bitnami-services.html)

Installation Steps and Prerequisists:
- Access to a Tanzu Application Platform cluster v1.5.0 and later
- The Tanzu services CLI plug-in v0.6.0 and later

The following steps explain how to work with Bitnami Services.
```
$ tanzu service class list
```
The expected output is similar to the following:
```
  NAME                  DESCRIPTION
  mysql-unmanaged       MySQL by Bitnami
  postgresql-unmanaged  PostgreSQL by Bitnami
  rabbitmq-unmanaged    RabbitMQ by Bitnami
  redis-unmanaged       Redis by Bitnami
```
Here the output shows 4 classes. These are the four pre-installed Bitnami Services. You can see from the names and descriptions that they are all unmanaged services. This implies that the resulting service instances run on cluster, that is, they are not a managed service running in the cloud. Other classes might be listed here as well.

You can learn and discover more about a class by running:
```
$ tanzu service class get postgresql-unmanaged
```
The expected output is similar to the following:
```
NAME:           postgresql-unmanaged
DESCRIPTION:    PostgreSQL by Bitnami
READY:          true

PARAMETERS:
  KEY        DESCRIPTION                                                  TYPE     DEFAULT  REQUIRED
  storageGB  The desired storage capacity of the database, in Gigabytes.  integer  1        false
```
To create the claim in a namespace, you must first create the namespace by running:
```
$ tanzu service class-claim create newsletter-db --class postgresql-unmanaged --parameter storageGB=3 -n $TAP_DEVELOPER_NAMESPACE
Creating claim 'newsletter-db' in namespace 'newsletter'.
```
Please run `tanzu services class-claims get newsletter-db --namespace $TAP_DEVELOPER_NAMESPACE` to see the progress of create.

```
$ tanzu service class-claim get newsletter-db  --namespace $TAP_DEVELOPER_NAMESPACE
Name: newsletter-db
Namespace: newsletter
Claim Reference: services.apps.tanzu.vmware.com/v1alpha1:ClassClaim:newsletter-db
Class Reference: 
  Name: postgresql-unmanaged
Parameters: 
  storageGB: 3
Status: 
  Ready: True
  Claimed Resource: 
    Name: 101fb718-d596-479c-8e3d-8e966a06e4ec
    Namespace: <namespace>
    Group: 
    Version: v1
    Kind: Secret
```

### Verify the database Deployment
The class-claim for the newsletter database (newsletter-db) has been created and the PostgreSQL Database is now provisioned in a seperate kubernetes namespace (newsletter-db-wgk2h).
```
tanzu@tdh-tools:~/newsletter$ kubectl get ns | grep newsletter-db
newsletter-db-wgk2h            Active   35m
```
```
tanzu@tdh-tools:~/newsletter$ kubectl get all,secrets -n newsletter-db-wgk2h 
NAME                        READY   STATUS    RESTARTS   AGE
pod/newsletter-db-wgk2h-0   1/1     Running   0          10m

NAME                             TYPE        CLUSTER-IP     EXTERNAL-IP   PORT(S)    AGE
service/newsletter-db-wgk2h      ClusterIP   10.96.104.52   <none>        5432/TCP   10m
service/newsletter-db-wgk2h-hl   ClusterIP   None           <none>        5432/TCP   10m

NAME                                   READY   AGE
statefulset.apps/newsletter-db-wgk2h   1/1     10m

NAME                                                     TYPE                                DATA   AGE
secret/newsletter-db-wgk2h                               connection.crossplane.io/v1alpha1   8      11m
secret/sh.helm.release.v1.newsletter-db-wgk2h-kqgg6.v1   helm.sh/release.v1                  1      11m
```
A secret hast been created holding the database user and password. 
```
tanzu@tdh-tools:~/newsletter$ kubectl -n newsletter-db-wgk2h  get secrets newsletter-db-wgk2h -o json | jq -r '.data'
{
  "database": "bmV3c2xldHRlci1kYi13Z2syaA==",
  "host": "bmV3c2xldHRlci1kYi13Z2syaA==",
  "password": "Nzl6cTBxdjA4b2xucHZoMTRwbWZsaWw0dHMxcmxkb2Y=",
  "port": "NTQzMg==",
  "postgres-password": "Nzl6cTBxdjA4b2xucHZoMTRwbWZsaWw0dHMxcmxkb2Y=",
  "provider": "Yml0bmFtaQ==",
  "type": "cG9zdGdyZXNxbA==",
  "username": "cG9zdGdyZXM="
}
```
The application deployment does not require to have the details about the newletter-db. This is all managed by the TAP Service Broker that manages the access to the database resource. The developer only requires to have a 'serviceClaim' contiguration for the newsletter-db in his workload.yaml. 
```
apiVersion: carto.run/v1alpha1
kind: Workload
metadata:
  name: newsletter-subscription
  labels:
    apps.tanzu.vmware.com/workload-type: web
    app.kubernetes.io/part-of: newsletter
    apps.tanzu.vmware.com/has-tests: "true"
    apis.apps.tanzu.vmware.com/register-api: "true"
    apps.tanzu.vmware.com/debug: "true"
  annotations:
    autoscaling.knative.dev/minScale: "1"
spec:
  serviceClaims:
    - name: db
      ref:
        apiVersion: services.apps.tanzu.vmware.com/v1alpha1
        kind: ClassClaim
        name: newsletter-db
....
```
As the newsletter database on creation time has been configured to be accessed from any application running within the developer namespace 'newsletter'.


### Set the backstage 'part-of' label
In order for backstage techdocs and the TAP application live view to finde the database pods, a kubernetes label 'part-of' needs
to be added to the pods.
```
$ kubectl -n newsletter-db-wgk2h label pod/newsletter-db-wgk2h-0 app.kubernetes.io/part-of=newsletter                                         
pod/newsletter-db-0 labeled
```
### Deboug the database deployments
In case of a problem, the commands shown below should help identifing the issue. 
```
# --- SHOW NAMESPACE RELEATED EVENTS ---
$ kubectl -n <TAP_DEVELOPER_NAMESPACE> get events
```

```
# --- SHOW THE CONTAINER LOGS ---
$ kubectl -n newsletter-db-wgk2h logs newsletter-db-wgk2h-0 
postgresql 20:14:23.26 
postgresql 20:14:23.26 Welcome to the Bitnami postgresql container
postgresql 20:14:23.27 Subscribe to project updates by watching https://github.com/bitnami/containers
postgresql 20:14:23.27 Submit issues and feature requests at https://github.com/bitnami/containers/issues
postgresql 20:14:23.28 
postgresql 20:14:23.32 INFO  ==> ** Starting PostgreSQL setup **
postgresql 20:14:23.35 INFO  ==> Validating settings in POSTGRESQL_* env vars..
postgresql 20:14:23.37 INFO  ==> Loading custom pre-init scripts...
postgresql 20:14:23.38 INFO  ==> Initializing PostgreSQL database...
postgresql 20:14:23.44 INFO  ==> pg_hba.conf file not detected. Generating it...
postgresql 20:14:23.44 INFO  ==> Generating local authentication configuration
postgresql 20:14:24.40 INFO  ==> Starting PostgreSQL in background...
postgresql 20:14:24.64 INFO  ==> Changing password of postgres
postgresql 20:14:24.69 INFO  ==> Configuring replication parameters
postgresql 20:14:24.77 INFO  ==> Configuring synchronous_replication
postgresql 20:14:24.77 INFO  ==> Configuring fsync
postgresql 20:14:24.87 INFO  ==> Stopping PostgreSQL...
waiting for server to shut down.... done
```

### Accessing to the Database 
The PostgreSQL can be accessed from from withing the docker container. This is only usefil for debuggin reasons and may not be 
available in production environment because of lack of permission. At first get the credentials from the database secret.
```
ä kubectl -n newsletter-db-wgk2h get secrets newsletter-db-wgk2h -o json | jq -r '.data.username' | base64 -d
postgres
ä kubectl -n newsletter-db-wgk2h get secrets newsletter-db-wgk2h -o json | jq -r '.data."postgres-password"' | base64 -d
79zq0qv08olnpvh14pmflil4ts1rldof
```
Now login in to the docker container with the optained credentials
```
$ kubectl -n newsletter-db-wgk2h exec -it newsletter-db-wgk2h-0 -- bash
I have no name!@newsletter-db-wgk2h-0:/$
```
Now you are inside the PosrgreSQL docker container and can connect to the database as root. Additionally as the psql utility is available 
in the container as well, you dont need to install it seperatly. Now the connedt to the database instance:
```
I have no name!@newsletter-db-wgk2h-0:/$ psql -h localhost -p 5432 -U postgres
Passowrd: <enter-pasword>

psql (15.2)
Type "help" for help.

postgres=# \l
                                                                         List of databases
     Name      |           Owner           | Encoding | Collate |  Ctype  | ICU Locale | Locale Provider |                    Access privileges                    
---------------+---------------------------+----------+---------+---------+------------+-----------------+---------------------------------------------------------
 newsletter-db | pgautofailover_replicator | UTF8     | C.UTF-8 | C.UTF-8 |            | libc            | pgautofailover_replicator=CTc/pgautofailover_replicator+
               |                           |          |         |         |            |                 | postgres_exporter=c/pgautofailover_replicator          +
               |                           |          |         |         |            |                 | pgappuser=CTc/pgautofailover_replicator                +
               |                           |          |         |         |            |                 | pgrouser=c/pgautofailover_replicator                   +
               |                           |          |         |         |            |                 | pgrwuser=c/pgautofailover_replicator
 postgres      | postgres                  | UTF8     | C.UTF-8 | C.UTF-8 |            | libc            | postgres=CTc/postgres                                  +
               |                           |          |         |         |            |                 | pgautofailover_monitor=c/postgres                      +
               |                           |          |         |         |            |                 | postgres_exporter=c/postgres
 template0     | postgres                  | UTF8     | C.UTF-8 | C.UTF-8 |            | libc            | =c/postgres                                            +
               |                           |          |         |         |            |                 | postgres=CTc/postgres
 template1     | postgres                  | UTF8     | C.UTF-8 | C.UTF-8 |            | libc            | =c/postgres                                            +
               |                           |          |         |         |            |                 | postgres=CTc/postgres
(4 rows)
```
Now change to the Database 'newsletter-db' and show if there a are any tables configured.
```
postgres=# \c newsletter-db
SSL connection (protocol: TLSv1.3, cipher: TLS_AES_256_GCM_SHA384, compression: off)
You are now connected to database "newsletter-db" as user "postgres".
```

## Deploy the Newsletter Subscription (newsletter-subscription) 
To deploy the newsletter subscription service requires to install a tektron pipeline and a scan policy at first. 
### Install Tektron Pipeline
```
---
apiVersion: tekton.dev/v1beta1
kind: Pipeline
metadata:
  name: pipeline-notest
  labels:
    apps.tanzu.vmware.com/pipeline: test     # (!) required
spec:
  params:
    - name: source-url                       # (!) required
    - name: source-revision                  # (!) required
  tasks:
    - name: test
      params:
        - name: source-url
          value: \$(params.source-url)
        - name: source-revision
          value: \$(params.source-revision)
      taskSpec:
        params:
          - name: source-url
          - name: source-revision
        steps:
          - name: test
            image: gradle
            script: |-
              echo "Didnu nuffin. LOL!"
              exit 0 
```
This pipeline is currently nonfigured with no tests to speed-up the deployment for customer demos. But its strongly recommended to add test here according to the 'test driven design' methodology.
```
$ export TAP_DEVELOPER_NAMESPACE=newsletter
$ cd newsleter/newsletter-subscription
$ kubectl -n $TAP_DEVELOPER_NAMESPACE apply -f config/pipeline-notest.yaml
pipeline.tekton.dev/pipeline-notest created
```
### Install Scan Policy
The scan policy controls the scanning behavioir for ie. Maven dependancies and container images. The ignoreCves to ignore specific CVE volnerabilites should only be used to hide CVE that are irrelevant for thos application.
```
apiVersion: scanning.apps.tanzu.vmware.com/v1beta1
kind: ScanPolicy
metadata:
  name: scan-policy
  labels:
    'app.kubernetes.io/part-of': 'enable-in-gui'
spec:
  regoFile: |
    package main

    # Accepted Values: "Critical", "High", "Medium", "Low", "Negligible", "UnknownSeverity"
    notAllowedSeverities := ["Critical"]
    ignoreCves := ["CVE-2015-3166","CVE-2018-1115","CVE-2019-10211","CVE-2021-26291","CVE-2015-0244","CVE-2016-1000027","CVE-2016-0949","CVE-2017-11291","CVE-2018-12804","CVE-2018-12805","CVE-2018-4923","CVE-2021-40719","CVE-2018-25076","GHSA-765h-qjxv-5f44","GHSA-f2jv-r9rf-7988","GHSA-w457-6q6x-cgp9","CVE-2021-3918","GHSA-896r-f27r-55mw","GHSA-xvch-5gv4-984h","CVE-2022-43604","CVE-2022-43605","CVE-2016-0949","CVE-2017-11291","CVE-2018-12804","CVE-2018-12805","CVE-2018-4923","GHSA-rprw-h62v-c2w7","CVE-2018-16395","CVE-2022-37434","CVE-2022-37434","GHSA-8q59-q68h-6hv4","CVE-2017-18342","GHSA-6757-jp84-gxfx","GHSA-8q59-q68h-6hv4","GHSA-rprw-h62v-c2w7","CVE-2018-16395"]

    contains(array, elem) = true {
      array[_] = elem
    } else = false { true }

    isSafe(match) {
      severities := { e | e := match.ratings.rating.severity } | { e | e := match.ratings.rating[_].severity }
      some i
      fails := contains(notAllowedSeverities, severities[i])
      not fails
    }

    isSafe(match) {
      ignore := contains(ignoreCves, match.id)
      ignore
    }

    deny[msg] {
      comps := { e | e := input.bom.components.component } | { e | e := input.bom.components.component[_] }
      some i
      comp := comps[i]
      vulns := { e | e := comp.vulnerabilities.vulnerability } | { e | e := comp.vulnerabilities.vulnerability[_] }
      some j
      vuln := vulns[j]
      ratings := { e | e := vuln.ratings.rating.severity } | { e | e := vuln.ratings.rating[_].severity }
      not isSafe(vuln)
      msg = sprintf("CVE %s %s %s", [comp.name, vuln.id, ratings])
    }

    
---
apiVersion: scanning.apps.tanzu.vmware.com/v1beta1
kind: ImageScan
metadata:
  name: sample-public-image-scan-with-compliance-check
spec:
  registry:
    image: "nginx:1.16"
  scanTemplate: public-image-scan-template
  scanPolicy: scan-policy
```
To install the scan policy for the newsletter application perform the following command:
```
$ kubectl -n $TAP_DEVELOPER_NAMESPACE apply -f config/newsletter-scan-policy.yaml
imagescan.scanning.apps.tanzu.vmware.com/sample-public-image-scan-with-compliance-check created
```









