Game Application Demo

Overview

This project is a comprehensive demo that showcases the integration of frontend and backend technologies to build a game application.
It is designed for educational purposes to demonstrate how the frontend and backend interact seamlessly. 
The application includes user authentication, service registration, and a centralized API gateway.

Project Structure
The project is divided into several key components:

Frontend: Built with Angular, the frontend handles the user interface and interactions.

Backend: Consists of multiple services including User Auth Service, Eureka Server Service, and API Gateway Service.

Databases:
MySQL: Stores user credentials and authentication tokens.
MongoDB: Stores user favorite game names.

Key Components:
User Auth Service
Manages user authentication and authorization.
Handles user login and registration.
Stores authentication tokens in MySQL.

Eureka Server Service
Service registry for discovering and managing microservices.
Ensures all services are registered and available for communication.

API Gateway Service
Centralized entry point for the frontend to communicate with backend services.
Routes requests to appropriate services and handles load balancing.

Frontend (Angular)
Provides a user-friendly interface for interacting with the application.
Connects to the backend services via the API Gateway.
Allows users to login and add their favorite games.


Features
User Authentication: Secure login and registration with JWT tokens stored in MySQL.

Favorite Games: Authenticated users can add their favorite game names which are then stored in MongoDB.

Microservices Architecture: Demonstrates the use of microservices with Eureka and API Gateway.

Frontend-Backend Integration: Shows how Angular frontend connects with Java backend services.
