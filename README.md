# Authentication API

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)

This project is an API built using **Java, Java Spring, Flyway Migrations, Docker, PostgresSQL as the database, and Spring Security and JWT for authentication control.**

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Authentication](#authentication)
- [Database](#database)
- [Examples](#example-requests)

## Installation

1. Clone the repository:

```bash
git clone https://github.com/AndreReginatto93/spring-security.git
```

2. Install dependencies with Maven

3. Install [Docker Desktop](https://www.docker.com/products/docker-desktop/)

## Usage

1. Run "docker compose up -d" on terminal to start the Postgres database
2. Start the application with Maven
3. The API will be accessible at http://localhost:8080


## API Endpoints
The API provides the following endpoints:

```markdown
GET /product - Retrieve a list of all products. (all authenticated users)

POST /product - Register a new product (ADMIN access required).

POST /auth/login - Login into the App

POST /auth/register - Register a new user into the App
```

## Authentication
The API uses Spring Security for authentication control. The following roles are available:

```
USER -> Standard user role for logged-in users.
ADMIN -> Admin role for managing partners (registering new partners).
```
To access protected endpoints as an ADMIN user, provide the appropriate authentication credentials in the request header.

## Database
The project utilizes [PostgresSQL](https://www.postgresql.org/) as the database. The necessary database migrations are managed using Flyway.


## Example Requests

### Register a new user

```http
POST /auth/register

{
    "login": "andrereginatto93@gmail.com",
    "password": "123456789",
    "role": "ADMIN" | "USER"
}
```

### Login

```http
POST /auth/register

{
    "login": "andrereginatto93@gmail.com",
    "password": "123456789"
}
```
#### Response:

```json
{
  "token": "*****.*****.*****"
}
```

### Get all products (all authenticated users)
```http
GET /products
```
#### Response:

```json
[
  {
    "id": "f295305d-90a6-40e6-9d4f-9f8ead834cdb",
    "name": "Product 1",
    "price": 100.00
  },
  {
    "id": "05a107c2-d7dc-4295-b3a0-1c4c66bab257",
    "name": "Product 2",
    "price": 150.99
  }
]
```

### Register a new product (ADMIN only)
```http
POST /products
{
    "name": "Product 3",
    "price": 199.99
}
```
#### Response:

```json
{
  "id": "14f013f8-174a-4ae6-af01-c17ca6d7248f",
  "name": "Product 3",
  "price": 199.99
}
```
