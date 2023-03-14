# customer account
API to be used for opening a new “current account” of already existing
customers.

## Getting Started


### Main technologies used
- JDK 11
- Maven
- Spring Boot
- H2 DB
- JUnit
- Lombok

### CI/CD Tools
- GitHub Actions
- Maven
- Docker
- Docker Hub


### Installing
* Clone the repository
```
git clone git@github.com:Hbuz/customer-account.git
```

* Go to root project
```
cd customer-account
```

* Change folder mode
```
chmod +x mvnw
```

* Creating an executable JAR
  Execute this command from the root project:
```
./mvnw package
```

### Run the test
Execute this command from the root project:
```
./mvnw test
```

### Run the application
Execute this command from the root project:
```
java -jar target/*.jar
```

### Endpoints implemented
* Open customer account
```
POST - http://localhost:8080/api/v1/accounts

* request body *
{
    "customer_id": 1,
    "initial_credit": 200
}
```

* Fetch customer information
```
GET - http://localhost:8080/api/v1/customers/{customerId}

- customerId = Id of the customer
```


### Postman
A postman collection has been added to the root project. It can be imported and used in Postman to test the application:

```customer_account_API.postman_collection.json```


### Swagger Docs
```
http://localhost:8080/swagger-ui.html#/
```