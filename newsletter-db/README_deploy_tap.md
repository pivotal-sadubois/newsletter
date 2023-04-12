# Newsletter Databaase (newsletter-db) - Deploy on Tanuu Application Platform (TAP) 
This document describes the procedure how to deploy the Newsleter Database in your Developer Namespace within the Tanzu Application Platform. Typically 
the installation of the Database is done prior all other applicaiton components but its not an requirement. 

Installation Steps and Prerequisists: 
- Accesss to the VMware Software Repository (https://network.pivotal.io/)
- Downlaod VMware SQL with Postgres for Kubernetes
- Installal the Tanzu Postgres Operator

## Installing a Tanzu Postgres Operator
The Newsletter Databaase is basing on the Tanhu PostreSQL for Kubernetes deployment and requores the PostgreSQL which can be download for the VMware software Repsitory
[Installing a Tanzu Postgres Operator](https://docs.vmware.com/en/VMware-SQL-with-Postgres-for-Kubernetes/1.9/tanzu-postgres-k8s/GUID-install-operator.html)

## Create a Developer Namespace
Bevore you can install the Newletter Demo Applicaiotn you need to create a Developer Namespace. If not already done, please refer to the guide in the documentation 
[Tanzu Aoolication Plarform - Create Developer Namespace](https://docs.vmware.com/en/VMware-Tanzu-Application-Platform/1.5/tap/scst-store-developer-namespace-setup.html).

## Add credentials to the Tanzu Registry
The Tanzu SQL with Postgres for Kubernetes will be directly downloaded during the installation from the VMware Registry (registry.tanzu.vmware.com). An account can be created 
here (Create your VMware Account](https://account.run.pivotal.io/z/uaa/sign-up). To allow Kubernetes to pull from the VMware Registry a secret needs to be created withing your
developer Namespace.

```
$ kubectl -n newsletter create secret docker-registry regsecret \
          --docker-server=https://registry.tanzu.vmware.com/ \
          --docker-username=<VMWARE_REGISTRY_USER> \
          --docker-password=<VMWARE_REGISTRY_PASS> 
```

## Deploying the PostgreSQL Database
Withing the config directory 

```
$ cat config/newsletter-db.yaml 
apiVersion: sql.tanzu.vmware.com/v1
kind: Postgres
metadata:
  name: newsletter-db
  labels:
    app.kubernetes.io/part-of: newsletter
spec:
  memory: 800Mi
  cpu: "0.8"
  # storageClassName: standard
  storageSize: 2G
  pgConfig:
    dbname: newsletter-db
    username: pgadmin
    appUser: pgappuser

```
The database can be deployed with the command shown below. If your developer namespace has a different name, then reployce '-n newsletter' 
with the name of your namespace.
```
$ kubectl -n newsletter create -f config/newsletter-db.yaml
```

## Enable Service Binding for the PostgresSQL Database
Binding application workloads to service instances is the most common use of services. The Newsletter Application will your a 'resource claims' defined in 
the workload.yaml file that allows sn automatic connection of the PostgreSQL service instances with a service bindings that exchanges connection credentials as well. Read more about under 
[Consume services on Tanzu Application Platform](https://docs.vmware.com/en/VMware-Tanzu-Application-Platform/1.5/tap/getting-started-about-consuming-services.html)
```
$ cat config/postgres-class.yaml
---
apiVersion: services.apps.tanzu.vmware.com/v1alpha1
kind: ClusterInstanceClass
metadata:
  name: user-profile-database
spec:
  description:
    short: It's a PostgreSQL Database
  pool:
    group: sql.tanzu.vmware.com
    kind: Postgres
```
Install the Service Instance Class with the following command: 
---
$ kubectl -n newsletter create -f config/postgres-class.yaml
---

## Install the Postgres Service Rolebinding
The postgres-service-binding Rolebinding is only required if the database is deployed in another Kubernetes Namespace than the newletter 
applicaiton. 
```
$ cat config/postgres-service-binding.yaml
# postgres-service-binding.yaml
---
apiVersion: rbac.authorization.k8s.io/v1
kind: ClusterRole
metadata:
  name: postgres-service-binding
  labels:
    servicebinding.io/controller: "true"
rules:
- apiGroups: ["sql.tanzu.vmware.com"]
  resources: ["Postgres"]
  verbs: ["get", "list", "watch"]
```

## Verify the database Deployment
If the deployment is successful, the database instance newsetter-db-0 and newsletter-db-monitor-0 should be available and running. 
```
$ kubectl -n newsletter get pods
NAME                                                        READY   STATUS      RESTARTS   AGE
newsletter-db-0                                             5/5     Running     0          24h
newsletter-db-monitor-0                                     4/4     Running     0          24h
```

## Deboug the database deployments
In case of a problem, the commands shown below should help identifing the issue. 
```
# --- SHOW NAMESPACE RELEATED EVENTS ---
$ kubectl -n newletter get events

# --- SHOW THE CONTAINER LOGS ---
$ kubectl -n newsletter logs newsletter-db-0 -c instance-logging
$ kubectl -n newsletter logs newsletter-db-0 -c [pg-container
$ kubectl -n newsletter logs newsletter-db-0 -c reconfigure-instance
$ kubectl -n newsletter logs newsletter-db-0 -c postgres-metrics-exporter
$ kubectl -n newsletter logs newsletter-db-0 -c  postgres-sidecar
```

## Accessing to the Database 
The PostgreSQL can be accessed from from withing the docker container. This is only usefil for debuggin reasons and may not be 
available in production environment because of lack of permussions.
```
$ kubectl -n newsletter exec -it newsletter-db-0 -- bash
Defaulted container "pg-container" out of: pg-container, instance-logging, reconfigure-instance, postgres-metrics-exporter, postgres-sidecar
postgres@newsletter-db-0:/$ 
```
Now you are inside the PosrgreSQL docker container and can connect to the database as root. Additionally as the psql utility is available 
in the container as well, you dont need to install it seperatly. Now the connedt to the database instance:
```
postgres@newsletter-db-0:/$ psql -h localhost -p 5432
psql (15.1 (VMware Postgres 15.1.0))
SSL connection (protocol: TLSv1.3, cipher: TLS_AES_256_GCM_SHA384, compression: off)
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
postgres=# \dt
Did not find any relations.
```
This makes sense a we dont have installed the rest of the newsletter applicaiton components yet. Repeat that procedure again as newsletter-subscription service has been
installed and initialised.
