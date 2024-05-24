#!/bin/bash

if [ "$APP_HOSTNAME" == "" ]; then 
  echo "$0: "
  echo "please set the DNS Name for the application"
  echo " ie.   export APP_HOSTNAME=\"http://localhost:8080\""
  echo "       export APP_HOSTNAME=\"https://newsletter-subscription.dev.tapmc.tanzudemohub.com"
  exit
fi

curl -X 'GET' $APP_HOSTNAME/api/v1/subscriptions \
  -H 'accept: application/json' 2>/dev/null | jq -r

