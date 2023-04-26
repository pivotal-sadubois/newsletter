#!/bin/bash

kubectl -n newsletter create -f config/newsletter-db.yaml
kubectl -n newsletter create -f config/postgres-class.yaml
kubectl -n newsletter label pod newsletter-db-0 app.kubernetes.io/part-of=newsletter
kubectl -n newsletter label pod newsletter-db-monitor-0 app.kubernetes.io/part-of=newsletter

