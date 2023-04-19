


        kubectl -n newsletter create secret docker-registry regsecret \
            --docker-server=https://registry.tanzu.vmware.com/ \
            --docker-username=$TDH_REGISTRY_VMWARE_USER \
            --docker-password=$TDH_REGISTRY_VMWARE_PASS 



kubectl -n newsletter create -f config/newsletter-db.yaml



# Connecting

kubectl -n newsletter exec -it newsletter-db-0 -- bash

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

postgres=# 
\q
postgres@newsletter-db-0:/$ psql -d newsletter-db -h localhost -p 5432
psql (15.1 (VMware Postgres 15.1.0))
SSL connection (protocol: TLSv1.3, cipher: TLS_AES_256_GCM_SHA384, compression: off)
Type "help" for help.

newsletter-db=# \l
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

newsletter-db=# \dt
                 List of relations
 Schema |         Name          | Type  |   Owner   
--------+-----------------------+-------+-----------
 public | flyway_schema_history | table | pgappuser
 public | subscription          | table | pgappuser
(2 rows)

newsletter-db=# select * fromsubscription; 
ERROR:  syntax error at or near "fromsubscription"
LINE 1: select * fromsubscription;
                 ^
newsletter-db=# select * from subscription; 
 id |      email_id      | first_name | last_name 
----+--------------------+------------+-----------
  1 | tom.bread@test.org | Tom        | Bread
  2 | tom.bread@test.org | Tom        | Bread
(2 rows)

newsletter-db=# 

