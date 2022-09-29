# Spring training

This repository is a representation for the week training about spring.
The different exercises can be found [here](http://springboot.ilionx.carpago.nl).

Credentials for the course website:

- Username: cursist
- Password: ilionx2022!

For the exercise, I made an API for food dishes. The API has all the CRUD functionalities.
There are also some beans added for testing purposes, the beans are identified as different cooks.

## Requirements

The different requirements to run te code:

- Mysql server (docker);
- Postman agent.

## Example queries for testing
Change the Port number for different uses:

- ``Port 8080`` is for development;
- ``Port 8081`` is used for testing;
- ``Port 808*`` Other ports are still free and not in use;

### 1. Get all dishes

````http request
GET http://localhost:8080/dish
````

### 2. Get dish by id

````http request
GET http://localhost:8080/dish/2
````

### 3. Get dish by name

```http request
GET http://localhost:8080/dish/name:Carbonara
```

### 4. Get dishes by groupName

````http request
GET http://localhost:8080/dish/group:pizza
````

### 5. Get dishes between specific price range

````http request
GET http://localhost:8080/dish/price/from/5/to/10
````

### 6. Create dish

````http request
POST http://localhost:8080/dish
````

Add JSON like this in the body to the request:

````json
{
  "groupName": "pasta",
  "name": "Pesto",
  "description": "Pesto is one of the most popular pasta toppings in Italy. It originated in Liguria, specifically in Genoa. .",
  "price": 2.12
}
````

### 7. Update a dish by id

````http request
PUT http://localhost:8080/dish/5
````

Add JSON to the request body:

````json
{
  "groupName": "pizza",
  "name": "Prosciutto",
  "description": "Prosciutto pizza with dough, tomato sauce, Mozzarella cheese, prosciutto di Parma, arugula, Parmesan cheese, sun-dried tomatoes and oregano.",
  "price": 11.45
}
````

### 8. Delete dish by id

````http request
DELETE http://localhost:8080/dish/6
````

## Contact

For questions you can connect [Giuseppe Collura](mailto:)