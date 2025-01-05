# Spring Boot RESTful API for Employee Management

This is a simple Spring Boot project designed to help you learn the basics of creating RESTful APIs. The project includes basic endpoints for managing employee data.

## Features
- **Add New Employee**: Create a new employee using a `POST` request.
- **Get All Employees**: Retrieve a list of all employees using a `GET` request.
- **Get Employee by ID**: Retrieve the details of a specific employee by their ID using a `GET` request.

## Technologies Used
- **Java**: Programming language.
- **Spring Boot**: Framework for building RESTful web services.
- **H2 Database**: In-memory database for quick setup and testing.
- **Maven**: Dependency management.

## Installation and Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/terabhaiSM/SpringBoot--Backend-apis.git
   cd your-repo-name
   ```

2. Build the project using Maven:
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

4. Access the application:
   - The server will start on `http://localhost:8080`.

## API Endpoints

### 1. Get All Employees
**Endpoint**: `GET /api/employees`  
**Description**: Retrieves a list of all employees.  
**Response**:
```json
[
  {
    "id": 1,
    "name": "John Doe",
    "email": "johndoe@example.com",
    "phone": "+1234567890",
    "address": "123 Main Street",
    "department": "Engineering",
    "position": "Software Engineer",
    "salary": "80000",
    "isActive": true
  }
]
```

### 2. Get Employee by ID
**Endpoint**: `GET /api/employees/{id}`  
**Description**: Retrieves the details of a specific employee by ID.  
**Response**:
```json
{
  "id": 1,
  "name": "John Doe",
  "email": "johndoe@example.com",
  "phone": "+1234567890",
  "address": "123 Main Street",
  "department": "Engineering",
  "position": "Software Engineer",
  "salary": "80000",
  "isActive": true
}
```

### 3. Add a New Employee
**Endpoint**: `POST /api/employees`  
**Description**: Creates a new employee.  
**Request Body**:
```json
{
  "name": "Jane Smith",
  "email": "janesmith@example.com",
  "phone": "+0987654321",
  "address": "456 Elm Street",
  "department": "HR",
  "position": "HR Manager",
  "salary": "90000",
  "isActive": true
}
```

**Response**:
```json
{
  "id": 2,
  "name": "Jane Smith",
  "email": "janesmith@example.com",
  "phone": "+0987654321",
  "address": "456 Elm Street",
  "department": "HR",
  "position": "HR Manager",
  "salary": "90000",
  "isActive": true
}
```

## Database Configuration
The application uses the H2 in-memory database by default. You can access the H2 console at `http://localhost:8080/h2-console` using the following details:
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: (leave blank)

## Future Improvements
- Add `PUT` and `DELETE` endpoints for updating and deleting employees.
- Implement input validation for request bodies.
- Add exception handling for better error responses.

## Contributing
Feel free to fork this repository, make improvements, and submit a pull request. Contributions are welcome!

---