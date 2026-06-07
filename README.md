# Calendar App

A simple fullstack calendar application built with React and Spring Boot.

The purpose of this project was to practice building a complete CRUD application from frontend to backend. Users can create, view, update and delete events through a React interface connected to a Spring Boot REST API.

## Technologies

### Frontend

* React
* Vite
* JavaScript
* CSS

### Backend

* Java 21
* Spring Boot 3
* Spring Data JPA
* H2 Database
* Maven

## Features

* Create events
* View all events
* Update existing events
* Delete events
* REST API integration between React and Spring Boot

## Project Structure

### Backend

* Entity
* Repository
* Service
* Controller
* Validation
* Exception handling

### Frontend

* Components
* State management with React Hooks
* Service layer for API calls
* Responsive UI

## Running the Application

### Backend

Start the Spring Boot application:

```bash
mvn spring-boot:run
```

The API will run on:

```text
http://localhost:8080
```

### Frontend

Install dependencies and start the development server:

```bash
npm install
npm run dev
```

The frontend will run on:

```text
http://localhost:5173
```

## What I Learned

This project helped me get hands-on experience with:

* Building REST APIs with Spring Boot
* Working with JPA and databases
* React components and props
* State management using useState and useEffect
* Connecting a frontend to a backend application
* Implementing full CRUD functionality

## Future Improvements

* PostgreSQL instead of H2
* Authentication and authorization
* Event categories
* Calendar view
* Search and filtering

## Author

Brandon Liu
