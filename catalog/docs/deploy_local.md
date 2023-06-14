# Newsletter Application - Local deployment

## Deploy the Database Backend newsletter-db
The Guestbook User Service (newsletter-subscription) requires a persistent database as a backend. The subscription-subscription and the 
subscription-db are together but are deployed different depending on the envronment.

### Prerequisites
In order to further develop this application the following tools needs to be setup:
- Java Development Kit (https://bell-sw.com/)
- Visual Studio Code or IntelliJ IDEA as Integrated Development Environment (IDE)
- Tanzu Developer Tools plugin for above mentioned IDE
- Docker Desktop to execute integration tests or run the application locally

## Deploying a local PosgreSQL Database for testing
The database backend is required for local testing of the user-profile-backend applicaiton wich requires it to run the automated tests. The local database will started as a docker container generated from the docker compose file within this directory. 

### Files
- docker-compose.yml   # Docker Configuration (database, user and password)


# Build and run the PosgresSQL Database Container
The configuration of the PostgresSQL database along with port, user and password are stored in the 'docker-compose' file.
```
version: "3.9"

volumes:
  postgres:
    driver: local

services:
  postgres:
    image: postgres:14
    restart: always
    environment:
      - POSTGRES_DB=subscription
      - POSTGRES_USER=user
      - POSTGRES_PASSWORD=pgappuser
    ports:
      - '5432:5432'
```
To run the Database Container just execute the following commands:

```
$ docker-compose up -d
$ Recreating user-profile-database_postgres_1 ... done

$ docker ps
CONTAINER ID   IMAGE                        COMMAND                  CREATED         STATUS         PORTS                    NAMES
7ee2317eba81   postgres:14                  "docker-entrypoint.s…"   3 seconds ago   Up 2 seconds   0.0.0.0:5432->5432/tcp   user-profile-database_postgres_1
```

To verify the database you can connect ot it with psql like this: 

```
$ psql -h localhost -p 5432 -U user -d development    ## pssword: password
psql (12.12 (Ubuntu 12.12-0ubuntu0.20.04.1), server 14.7 (Debian 14.7-1.pgdg110+1))
WARNING: psql major version 12, server major version 14.
         Some psql features might not work.
Type "help" for help.

development=# \l
                              List of databases
    Name     | Owner | Encoding |  Collate   |   Ctype    | Access privileges 
-------------+-------+----------+------------+------------+-------------------
 development | user  | UTF8     | en_US.utf8 | en_US.utf8 | 
 postgres    | user  | UTF8     | en_US.utf8 | en_US.utf8 | 
 template0   | user  | UTF8     | en_US.utf8 | en_US.utf8 | =c/user          +
             |       |          |            |            | user=CTc/user
 template1   | user  | UTF8     | en_US.utf8 | en_US.utf8 | =c/user          +
             |       |          |            |            | user=CTc/user
(4 rows)
development=# \q
```



## Debugging the Database
The login credentials can be found in the docker-compose.yml configuration files. The docker container needs to be started first 
by the command: "docker-compose up -d".
```
$ docker ps
CONTAINER ID   IMAGE                        COMMAND                  CREATED          STATUS          PORTS                    NAMES
9d4015fda615   postgres:14                  "docker-entrypoint.s…"   17 minutes ago   Up 17 minutes   0.0.0.0:5432->5432/tcp   blockchain-api_postgres_1
```
The container can be acessed with the following command:  

```
$ docker exec -it $(docker ps -q  --filter ancestor=postgres:14) psql -d development -U user
psql (14.7 (Debian 14.7-1.pgdg110+1))
Type "help" for help.

development=# \l
                              List of databases
    Name     | Owner | Encoding |  Collate   |   Ctype    | Access privileges 
-------------+-------+----------+------------+------------+-------------------
 development | user  | UTF8     | en_US.utf8 | en_US.utf8 | 
 postgres    | user  | UTF8     | en_US.utf8 | en_US.utf8 | 
 template0   | user  | UTF8     | en_US.utf8 | en_US.utf8 | =c/user          +
             |       |          |            |            | user=CTc/user
 template1   | user  | UTF8     | en_US.utf8 | en_US.utf8 | =c/user          +
             |       |          |            |            | user=CTc/user
(4 rows)

user-profile-database=# \dt
Did not find any relations.

```
The comment 'Did not find any relations.' means that there are no tables defined yet. Therefor change to the user-profile-backend directory and
run the following commands to compile and run the applicaiton. 
```
./mvnw clean compile
./mvnw spring-boot:run -Dspring-boot.run.profiles=local
```
If all works well, the user-profile-backend application should have been compiled and runnings and has connected to the database running in the
docker container. The configuration to access the database is stored in the application-local.properties of the user-profile-backend.
```
cat user-profile-backend/src/main/resources/application-local.properties
# application-local.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/development
spring.datasource.username=user
```

### Verify Database Entries
```
$ psql -h localhost -p 5432 -U user -d development
psql (12.12 (Ubuntu 12.12-0ubuntu0.20.04.1), server 14.7 (Debian 14.7-1.pgdg110+1))
WARNING: psql major version 12, server major version 14.
         Some psql features might not work.
Type "help" for help.

development=# \l
                              List of databases
    Name     | Owner | Encoding |  Collate   |   Ctype    | Access privileges 
-------------+-------+----------+------------+------------+-------------------
 development | user  | UTF8     | en_US.utf8 | en_US.utf8 | 
 postgres    | user  | UTF8     | en_US.utf8 | en_US.utf8 | 
 template0   | user  | UTF8     | en_US.utf8 | en_US.utf8 | =c/user          +
             |       |          |            |            | user=CTc/user
 template1   | user  | UTF8     | en_US.utf8 | en_US.utf8 | =c/user          +
             |       |          |            |            | user=CTc/user
(4 rows)

development=# \c development
psql (12.12 (Ubuntu 12.12-0ubuntu0.20.04.1), server 14.7 (Debian 14.7-1.pgdg110+1))
WARNING: psql major version 12, server major version 14.
         Some psql features might not work.
You are now connected to database "development" as user "user".
development=# \dt
Did not find any relations.
development=# \dl
      Large objects
 ID | Owner | Description 
----+-------+-------------
(0 rows)

development=# \dt
               List of relations
 Schema |         Name          | Type  | Owner 
--------+-----------------------+-------+-------
 public | flyway_schema_history | table | user
 public | users                 | table | user
(2 rows)

development=# select * from users;
 id |      email       | first_name | last_name 
----+------------------+------------+-----------
  1 | ramesh@gmail.com | Ramesh     | Fadatare
  2 | tom@gmail.com    | Tom        | Cruise
  3 | tony@gmail.com   | Tony       | Stark
(3 rows)
```











docker ps -q  --filter ancestor=


kubectl apply -f postgres-service-binding.yaml
kubectl -n guestbook create -f postgres.yaml


## Deploying a PosgreSQL Database on a kubernetes cluster


It is leveraging Spring Boot as a technology stack, which provides:
- a way to implement REST(ful) API using Spring Web annotations
- generation of the OpenAPI definition based on your code
- data persistence using Spring Data JPA (now PostgreSQL is supported, but other databases can be easily added)
- an Inversion of Control Container to wire together your classes at running without the need to write tightly-coupled code

The application contains example code implementing REST API for customer profile information read and write from and to the 
database. This example is intended to showcase best practices around using Spring Boot and it's libraries as well as
different types of tests which can be utilized to verify different parts of an application.

## Prerequisites
In order to further develop this application the following tools needs to be setup:
- Java Development Kit (https://bell-sw.com/)
- Visual Studio Code or IntelliJ IDEA as Integrated Development Environment (IDE)
- Tanzu Developer Tools plugin for above mentioned IDE
- Docker Desktop to execute integration tests or to run the application locally

# Local
## Build
In order to compile the production code:
```bash
./mvnw clean compile
```


After that it is a good habit to compile the test classes and execute those tests to see if your application is still behaving as you would expect:
```bash
./mvnw verify
```


## Start and interact
Spring Boot has its own integrated Web Server (Apache Tomcat (https://tomcat.apache.org/)). In order 
to start the application a PostgreSQL instance should be running.

Running a PostgreSQL instance can easily be done by using `docker-compose`:
```bash
docker-compose up -d
```

Launch application using profile `local`:
```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=local
```


### OpenApi Definition
You can access the API docs using `curl`:

```bash
curl http://localhost:8080/api-docs  
```

### Create customer profile

You can access the `customer-profiles` API endpoint using `curl`:

```bash
curl -X POST -H 'Content-Type: application/json' http://localhost:8080/api/customer-profiles/ -d '{"firstName": "Joe", "lastName": "Doe", "email": "joe.doe@test.org"}'
```

### Get customer profile
Use the `id` received by previous POST call.
```bash
curl -X GET http://localhost:8080/api/customer-profiles/{id}
```

# Deployment
## Tanzu Application Platform (TAP)
Using the `config/workload.yaml` it is possible to build, test and deploy this application onto a
Kubernetes cluster that is provisioned with Tanzu Application Platform (https://tanzu.vmware.com/application-platform).

As with the local deployment a PostgreSQL instance needs to be available at the cluster.
When using VMware Tanzu SQL with Postgres for Kubernetes (https://tanzu.vmware.com/sql and https://docs.vmware.com/en/VMware-Tanzu-SQL-with-Postgres-for-Kubernetes/index.html),
one could apply for an instance, and it will be automatically provisioned.

> Note: please define the storage class to be used for the PostgreSQL storage.

```bash
kubectl apply -f config/postgres.yaml
```

The `workload.yaml` contains a reference to the PostgreSQL instance.

> Note: if your postgres instance is in another namespace than your developer namespace, add the following to the workload.yaml:
```metadata:
       annotations:
         serviceclaims.supplychain.apps.x-tanzu.vmware.com/extensions: '{"kind":"ServiceClaimsExtension","apiVersion":"supplychain.apps.x-tanzu.vmware.com/v1alpha1", "spec":   {"serviceClaims":{"db":{"namespace":"<database namespace>"}}}}'
```

Before deploying your application a Tekton Pipeline responsible for the testing step shall be created in your application
namespace. Please execute following command.

```bash
kubectl apply -f config/test-pipeline.yaml
```


### Tanzu CLI
Using the Tanzu CLI one could apply the workload using the local sources:
```bash
tanzu apps workload apply \
  --file config/workload.yaml \
  --namespace <namespace> --source-image <image-registry> \
  --local-path . \
  --yes \
  --tail
````

Note: change the namespace to where you would like to deploy this workload. Also define the (private) image registry you
are allowed to push the source-image, like: `docker.io/username/repository`.

### Visual Studio Code Tanzu Plugin
When developing local but would like to deploy the local code to the cluster the Tanzu Plugin could help.
By using `Tanzu: Apply` on the `workload.yaml` it will create the Workload resource with the local source (pushed to an image registry) as
starting point.

# How to proceed from here?
Having the application locally running and deployed to a cluster you could add your domain logic, related persistence and new RESTful controller.
