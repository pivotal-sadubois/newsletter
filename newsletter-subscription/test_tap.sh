

URL=$(kubectl -n newsletter get route.serving.knative.dev/newsletter-subscription -o json 2>/dev/null | jq -r '.status.url') 

curl -X 'POST' "$URL/api/v1/subscriptions" \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '[
  {
    "emailId": "bob@example.com",
    "firstName": "Bob",
    "lastName": "Seger"
  },
  {
    "emailId": "john@example.com",
    "firstName": "John",
    "lastName": "Foggery"
  },
  {
    "emailId": "frank@example.com",
    "firstName": "Frank",
    "lastName": "Zappa"
  }
]' 2>/dev/null | jq -r


curl -X 'GET' "$URL/api/v1/subscriptions" \
  -H 'accept: application/json' 2>/dev/null | jq -r


