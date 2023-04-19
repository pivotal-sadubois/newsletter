# Newsletter Application - Local deployment

See [deploy newletter-db](../newsletter-db/deploy_local.md)

```
./mvnw clean compile
./mvnw spring-boot:run -Dspring-boot.run.profiles=local
```

## Testing CRUD REST APIs

### Create Subsription REST API
```
export DOMAIN=apps-contour.vsptap.pcfsdu.com
curl -X POST -H 'Content-Type: application/json' https://newsletter-subscription.$DOMAIN/api/v1/subscription \
-d '{"firstName": "Tom", "lastName": "Bread", "emailId": "tom.bread@test.org"}' | jq -r
{
  "id": 1,
  "firstName": "Tom",
  "lastName": "Bread",
  "emailId": "tom.bread@test.org"
}
$

export DOMAIN=apps-contour.vsptap.pcfsdu.com
curl -X POST -H 'Content-Type: application/json' https://newsletter-subscription.$DOMAIN/api/v1/subscription \
  -d '{"firstName": "Tom", "lastName": "Bread", "emailId": "tom.bread@test.org"}' | jq -r
{
  "id": 2,
  "firstName": "Tom",
  "lastName": "Bread",
  "emailId": "tom.bread@test.org"
}
```

### Get Subsription by ID REST API
```
$ export DOMAIN=apps-contour.vsptap.pcfsdu.com
$ curl -X GET -H 'Content-Type: application/json' https://newsletter-subscription.$DOMAIN/api/v1/subscription/1 | jq -r
{
  "id": 1,
  "firstName": "Joe",
  "lastName": "Doe",
  "emailId": "joe.doe1@test.org"
}

```
### Get all Subsription REST API
$ export DOMAIN=apps-contour.vsptap.pcfsdu.com
$ curl -X GET -H 'Content-Type: application/json' https://newsletter-subscription.$DOMAIN/api/v1/subscription | jq -r
[
  {
    "id": 1,
    "firstName": "Joe",
    "lastName": "Doe",
    "emailId": "joe.doe1@test.org"
  },
  {
    "id": 2,
    "firstName": "Tom",
    "lastName": "Bread",
    "emailId": "tom.bread@test.org"
  }
]
```

$ export DOMAIN=apps-contour.vsptap.pcfsdu.com
$ curl -X GET -H 'Content-Type: application/json' https://newsletter-subscription.$DOMAIN/api-docs | jq -r


```
### Get API Documentation
# https://howtodoinjava.com/spring-boot/springdoc-openapi-rest-documentation/
$ xport DOMAIN=apps-contour.vsptap.pcfsdu.com
$ curl -X GET -H 'Content-Type: application/json' https://newsletter-subscription.$DOMAIN/v3/api-docs 2>/dev/null | jq -r
$ curl -X GET -H 'Content-Type: application/json' https://newsletter-subscription.$DOMAIN/v3/api-docs.yaml
```

```
### Get Actuators
$ curl -X GET -H 'Content-Type: application/json' https://newsletter-subscription.$DOMAIN/actuator 2>/dev/null | jq -r
```

curl -X POST -H 'Content-Type: application/json' https://newsletter-subscription.$DOMAIN/api/v1/subscriptions -d @/tmp/subscription.json



