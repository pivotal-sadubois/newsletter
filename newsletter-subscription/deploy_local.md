# Newsletter Application - Local deployment

See [deploy newletter-db](../newsletter-db/deploy_local.md)

```
./mvnw clean compile
./mvnw spring-boot:run -Dspring-boot.run.profiles=local
```

## Testing CRUD REST APIs

### Create Subsription REST API
```
curl -X POST -H 'Content-Type: application/json' http://localhost:8080/api/v1/subscription \
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
$ curl -X GET -H 'Content-Type: application/json' http://localhost:8080/api/v1/subscription/1 | jq -r
{
  "id": 1,
  "firstName": "Joe",
  "lastName": "Doe",
  "emailId": "joe.doe1@test.org"
}

```
### Get all Subsription REST API
$ curl -X GET -H 'Content-Type: application/json' http://localhost:8080/api/v1/subscription | jq -r
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


```
### Get API Documentation
$ curl -X GET -H 'Content-Type: application/json' http://localhost:8080/v3/api-docs | jq -r
```

```
### Get Actuators
$ curl -X GET -H 'Content-Type: application/json' http://localhost:8080/actuator | jq -r
```

## Running JUnit tests
mvn test -Dspring.profiles.active=local 
If you want to run a specific test class, you can use the -Dtest parameter followed by the name of the test class:
```
mvn test -Dspring.profiles.active=local -Dtest=SubscriptionControllerTest
```

Or if you want to run a specific test method within a test class, you can use:
```
mvn test -Dspring.profiles.active=local -Dtest=SubscriptionControllerTest#testGetSubscriptionByIdOk
```
