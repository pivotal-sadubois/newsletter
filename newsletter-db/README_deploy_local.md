# Newsletter Databaase (newsletter-db) - Local Deployment
The Guestbook User Service (newsletter-subscription) requires a persistent database backend. The subscription-subscription and the 
subscription-db belong together but are deployed different depending on the envronment.

## Prerequisites
In order to further develop this application the following tools needs to be setup:
- Java Development Kit (https://bell-sw.com/)
- Visual Studio Code or IntelliJ IDEA as Integrated Development Environment (IDE)
- Tanzu Developer Tools plugin for mentioned IDE
- Docker Desktop to execute integration tests or run the application locally

## Deploying a local PosgreSQL Database for testing
This database backend is required for local testing of the user-profile-backend applicaiton wich requires a database 
backend to run the automated tests.  The local database will started as a docker container generated from the docker 
compose file within this directory. 

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

# Accessing the database
The database tools such as https://www.pgadmin.org/ 

## PostgreSQL Web Administration (pgadmin)
PGAdmin is a web-based Graphical User Interface (GUI) management application used to communicate with Postgres and derivative relational databases on both local and remote.
[link text itself]: http://www.reddit.com
[PGAdmin Web Site]: https://www.pgadmin.org


## Login to the database with psql local or remotly
Therefor the psql utility requires to be installe don your local computer. To verify the database you can connect ot it with psql like this: 
```
$ psql -h localhost -p 5432 -U user -d development    ## pssword: password
psql (12.12 (Ubuntu 12.12-0ubuntu0.20.04.1), server 14.7 (Debian 14.7-1.pgdg110+1))
WARNING: psql major version 12, server major version 14.
         Some psql features might not work.
Type "help" for help.
```

## Login into the database docker container
As the database runns as a docker container, its possible to login into the docker container and start
psql from there. 

```
$ docker ps
CONTAINER ID   IMAGE                        COMMAND                  CREATED          STATUS          PORTS                    NAMES
9d4015fda615   postgres:14                  "docker-entrypoint.s…"   17 minutes ago   Up 17 minutes   0.0.0.0:5432->5432/tcp   newsletter-api_postgres_1
```
The container can be acessed with the following command:

```
$ docker exec -it $(docker ps -q  --filter ancestor=postgres:14) psql -d subscription -U user
psql (14.7 (Debian 14.7-1.pgdg110+1))
Type "help" for help.
```





subscription=# \l
                               List of databases
     Name     | Owner | Encoding |  Collate   |   Ctype    | Access privileges 
--------------+-------+----------+------------+------------+-------------------
 postgres     | user  | UTF8     | en_US.utf8 | en_US.utf8 | 
 subscription | user  | UTF8     | en_US.utf8 | en_US.utf8 | 
 template0    | user  | UTF8     | en_US.utf8 | en_US.utf8 | =c/user          +
              |       |          |            |            | user=CTc/user
 template1    | user  | UTF8     | en_US.utf8 | en_US.utf8 | =c/user          +
              |       |          |            |            | user=CTc/user
(4 rows)
```
Try to insert values into the table.
```
subscription=# INSERT INTO subscription(id,first_name,last_name,email_id) VALUES (1, 'Tom', 'Bread', 'tom.bread@test.org');
INSERT 0 1
```
Verify the insert.
```
subscription=# select * from subscription;
 id | first_name | last_name |      email_id      
----+------------+-----------+--------------------
  1 | Tom        | Bread     | tom.bread@test.org
(1 row)

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




