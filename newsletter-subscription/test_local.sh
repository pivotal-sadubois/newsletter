

curl -X 'POST' \
  'http://localhost:8080/api/v1/subscription' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '
  {
    "emailId": "joshn@example.com",
    "firstName": "John",
    "lastName": "Foggerty"
  }
' 2>/dev/null | jq -r




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


