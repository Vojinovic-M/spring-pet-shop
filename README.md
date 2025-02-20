# Spring Pet Shop Backend

A Spring Boot application that powers the Pet Shop platform, providing RESTful APIs for managing users, pets, orders, and more. This backend seamlessly integrates with the [Angular Pet Shop Frontend](https://github.com/Vojinovic-M/angular-pet-shop) to deliver a full-stack experience.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Technology Stack](#technology-stack)
- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)

## Overview

The **Spring Pet Shop Backend** provides all necessary server-side functionalities for a typical pet shop scenario. Users can register/login, browse pet listings, place orders, and manage their profiles. Orders, users, and pets are all managed through a robust set of APIs secured by Spring Security.

## Features

- **User Management**: Registration, authentication, and profile updates.
- **Pet Management**: Create, read, update, and delete pet records.
- **Order Management**: Place new orders, view order history, update order status.
- **Security**: Spring Security configuration for authentication and authorization.
- **RESTful API**: Well-defined endpoints following REST conventions.

## Technology Stack

- **Java 17+**  
- **Spring Boot** (Core, Web, Data JPA, Security)
- **Hibernate/JPA** for ORM
- **Maven** for dependency management
- **MySQL** for the database

## Installation

1. **Clone the Repository**  
   ```bash
   git clone https://github.com/yourusername/spring-pet-shop.git
   cd spring-pet-shop
   ```
2. **Build the Project**
   ```bash
   mvn clean install
   ```
3. Run the Application
   ```bash
   mvn spring-boot:run
   ```
   The application will start on http://localhost:8080 by default.

## Usage

Once the backend is running, you can interact with the API using:
- HTTP clients (e.g. Postman)
- Your Angular frontend, configured to point to the backend base URL (http://localhost:8080 by default)

Endpoints used:
- /orders/
- /orders/create
- /orders/{orderId}/status
- /orders/{orderId}/rating
- /orders/{orderId}/cancel
- /orders/{petId}/ratings

- /pets/list
- /pets/{id}

- /user/hello # For testing
- /user/register
- /user/login
- /user/google-login
- /user/update

## Contributing

Contributions are always welcome! To get started:

- Fork this repository.
- Create a new branch:
  ```bash
  git checkout -b feature/YourFeature
- Make your changes and commit them.
- Push to your fork and create a pull request.
