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

