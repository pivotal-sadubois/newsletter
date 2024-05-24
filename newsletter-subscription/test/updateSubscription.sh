#!/bin/bash

if [ "$APP_HOSTNAME" == "" ]; then
  echo "$0: "
  echo "please set the DNS Name for the application"
  echo " ie.   export APP_HOSTNAME=\"http://localhost:8080\""
  echo "       export APP_HOSTNAME=\"https://newsletter-subscription.dev.tapmc.tanzudemohub.com"
  exit
fi

if [ "$1" == "" ]; then
  echo "ERROR: $0 <id>"; exit
fi


curl -X 'PUT' $APP_HOSTNAME/api/v1/subscription/$1 \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '
  {
    "emailId": "john.foggerty@example.com",
    "firstName": "John Gerald",
    "lastName": "Foggerty"
  }' 2>/dev/null | jq -r

