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

echo "=> GET  $APP_HOSTNAME/api/v1/subscription/$1"
curl -X 'GET' $APP_HOSTNAME/api/v1/subscription/$1 \
  -H 'accept: application/json' 2>/dev/null | jq -r

exit

echo "=> GET  $APP_HOSTNAME/api/v1/subscription/9999"

curl -X 'GET' $APP_HOSTNAME/api/v1/subscription/9999 \
  -H 'accept: application/json' 2>/dev/null | jq -r


exit



curl -X 'POST' \
  'http://localhost:8080/api/v1/subscriptions' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '[
  {
    "emailId": "joshn@example.com",
    "firstName": "John",
    "lastName": "Foggerty"
  },
  {
    "emailId": "frank@example.com",
    "firstName": "Frank",
    "lastName": "Zappa"
  },
  {
    "emailId": "bob@example.com",
    "firstName": "Bob",
    "lastName": "Seger"
  }
]
'  2>/dev/null | jq -r

curl -X 'GET' \
  'http://localhost:8080/api/v1/subscriptions' \
  -H 'accept: application/json' 2>/dev/null | jq -r

curl -X 'GET' \
  'http://localhost:8080/api/v1/subscription/1' \
  -H 'accept: application/json' 2>/dev/null | jq -r


