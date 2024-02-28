# Gondai School Management System

## Overview
School Management System is a multi-module project aimed at providing a comprehensive solution for managing various aspects of a school, including student information, staff details, parent-teacher communication, and more.

## Module Relationships

```mermaid
graph TD;
    harriston-app --> harriston-core;
    harriston-app --> harriston-detail;
    harriston-app --> harriston-repository;
    harriston-detail --> harriston-core;
    harriston-detail --> harriston-repository;
    harriston-repository --> harriston-core;
```

## Modules

### 1. harriston-app
This module contains the main application logic and is responsible for handling HTTP requests, managing controllers, and serving as the entry point for the application.

### 2. harriston-detail
The harriston-detail module focuses on providing detailed information about students, staff, parents, and other entities within the school system. It includes services and components for retrieving and displaying detailed data.

### 3. harriston-repository
The harriston-repository module acts as a data access layer, providing interfaces and implementations for interacting with various data sources such as databases, external APIs, or file systems. It encapsulates the logic for storing and retrieving data.

### 4. harriston-core
The harriston-core module serves as the core of the application, containing shared functionality, utility classes, and domain entities that are used across different parts of the system. It defines the fundamental building blocks of the application architecture.

## Technologies Used
- Java 21
- Spring Boot Web
- Spring Data JPA
- Lombok
- H2 in-memory database (for getting started quickly)
- Maven

## Setup Instructions
1. Clone the repository: `git clone https://github.com/yourusername/harriston-school.git`
2. Navigate to the project directory: `cd harriston-school`
3. Build the project: `mvn clean install`
4. Run the application: `java -jar harriston-app/target/harriston-app.jar`


## Usage
- Access the application through the provided endpoints.
- Use the provided APIs to perform CRUD operations on student, staff, parent, and other entities.
- Customize and extend the application as needed for specific school management requirements.

## Contributing
Contributions are welcome! If you have suggestions, enhancements, or bug fixes, please submit a pull request or open an issue on GitHub.

## License
This project is licensed under the [MIT License](LICENSE).