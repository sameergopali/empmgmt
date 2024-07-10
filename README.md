# Employee Management System

This is a Spring Boot application for managing employee details, departments, and roles within an organization.
It provides CRUD REST endpoints for managing employee details, department and role details

## Features

- Add, update, delete, and view employee details
- Manage departments and roles within the organization
- Integration with MySQL database
- Uses SpringBoot 3.3
- IDE used Intellj


## Prerequisites
- Java 17
- Postman
- Docker
- Docker Compose

## Getting Started

### Build the Docker images

```sh
docker compose up --build
```
This will build the Docker images and start the containers for the Spring Boot application and MySQL database.

### Access the application
The Spring Boot application will be accessible at http://localhost:8080

### Using postman
You can use Postman to test the API endpoints. Follow the steps below to import the Postman collection and environment:

- Open Postman.
- Click on your Workspace -> Import.
- Select the Import File tab.
- Click on Choose Files and select the EmployeeManagementSystem.postman_collection.json file.
- Click on Import.
- Run collection

## API Endpoints
### Employee Endpoints
- Create Employee
``` sh
POST /api/employees
{
"firstName": "John",
"lastName": "Doe",
"email": "john.doe@example.com",
"phoneNumber": "123-456-7890",
"hireDate": "2023-01-15",
"jobTitle": "Software Engineer",
"salary": 60000,
"department": {
"id": 1
},
"role": {
"id": 1
}
}
```

- Get All Employees
```sh
GET /api/employees
```

-Get Employee by ID
```sh
GET /api/employees/{id}
```

- Update Employee

```sh
PUT /api/employees/{id}
{
"firstName": "John",
"lastName": "Doe",
"email": "john.doe@example.com",
"phoneNumber": "123-456-7890",
"hireDate": "2023-01-15",
"jobTitle": "Software Engineer",
"salary": 70000,
"department": {
"id": 1
},
"role": {
"id": 1
}
}
```

-Delete Employee
```sh
DELETE /api/employees/{id}
```

### Department Endpoints
- Create Department
```sh
POST /api/departments
{
"name": "Engineering",
"description": "Handles software development and IT operations"
}
```

- Get All Departments
```sh
GET /api/departments
```

- Get Department by ID
```sh 
GET /api/departments/{id}
```

Update Department
```sh
PUT /api/departments/{id}
{
"name": "Engineering",
"description": "Handles software development and IT operations"
}
```


### Role Endpoints
- Create Role

```sh
POST /api/roles
{
"name": "Manager",
"description": "Manages team and projects"
}
```

- Get All Roles
```sh
GET /api/roles
```

- Get Role by ID
```sh
GET /api/roles/{id}
```

- Update Role
```sh
PUT /api/roles/{id}
{
"name": "Manager",
"description": "Manages team and projects"
}
```




