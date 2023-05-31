#!/bin/bash

# --- FIGURE NEWSLETTER HOME DIRECTORY ---

env
exit

pwd -L
pwd -P
exit

echo $(dirname $0) 
echo $(basename $0)

ls .



exit
kubectl -n newsletter create -f newsletter-db/config/newsletter-db.yaml
kubectl -n newsletter create -f newsletter-db/config/postgres-class.yaml
kubectl -n newsletter label pod newslnewsletter-db/etter-db-0 app.kubernetes.io/part-of=newsletter
kubectl -n newsletter label pod newsletter-db-monitor-0 app.kubernetes.io/part-of=newsletter

