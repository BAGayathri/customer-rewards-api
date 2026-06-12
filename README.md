# Rewards Program API

A Spring Boot REST API that calculates customer reward points based on transactions from the last 3 months.

## Features

* Calculate reward points per customer
* Monthly reward aggregation
* Total reward points calculation
* RESTful API design
* Global exception handling
* H2 in-memory database
* Unit Testing

## Tech Stack

* Java 21
* Spring Boot 3.5.15
* Spring Data JPA
* H2 Database
* JUnit 5

## Reward Calculation Logic

* 2 points for every dollar spent above $100
* 1 point for every dollar spent between $51 and $100
* 0 points for $50 and below

## How to Run

```
mvn spring-boot:run
```

## API Endpoints

### Get rewards for a specific customer

```
GET /api/rewards/customers/{customerId}
```

```
http://localhost:8080/api/rewards/customers/103
```

```json
{
  "customerId": 103,
  "customerName": "verma",
  "monthlyRewards": {
    "MAY": 7056,
    "MARCH": 2050,
    "APRIL": 226
  },
  "totalRewards": 9332
}
```

### Get rewards for all active customers

```
GET /api/rewards/customers
```

```
http://localhost:8080/api/rewards/customers
```

```json
[
  {
    "customerId": 101,
    "customerName": "John",
    "monthlyRewards": {
      "MAY": 2460,
      "MARCH": 130,
      "APRIL": 370
    },
    "totalRewards": 2960
  },
  {
    "customerId": 102,
    "customerName": "kim",
    "monthlyRewards": {
      "MAY": 14070,
      "MARCH": 30,
      "APRIL": 0
    },
    "totalRewards": 14100
  },
  {
    "customerId": 103,
    "customerName": "verma",
    "monthlyRewards": {
      "MAY": 7056,
      "MARCH": 2050,
      "APRIL": 226
    },
    "totalRewards": 9332
  },
  {
    "customerId": 104,
    "customerName": "David",
    "monthlyRewards": {
      "MAY": 0,
      "APRIL": 1428
    },
    "totalRewards": 1428
  }
]
```

### Error response — customer not found

```
GET http://localhost:8080/api/rewards/123
```

```json
{
  "timestamp": "2026-06-12T08:13:35.717915",
  "status": 404,
  "error": "Not Found",
  "message": "Customer not found: 123"
}
```

## H2 Console

```
http://localhost:8080/h2-console
```

## Running Tests

```
mvn test
```

## Author

Bhandatmakuru Gayathri





