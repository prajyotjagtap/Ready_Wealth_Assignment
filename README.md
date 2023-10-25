
### Project Documentation

#### Expense Tracker System

---

### Table of Contents

1. Introduction
2. Prerequisites
3. Project Structure
4. Setup
5. Endpoints
   1. Get All Expenses
   2. Get Expense by ID
   3. Create Expense
   4. Update Expense
   5. Delete Expense
6. Testing
7. Error Handling
8. Contributing

---

### 1. Introduction

The Expense Tracker System is a web application built with Java, Spring Boot, and Hibernate. It provides CRUD operations for managing expenses.

### 2. Prerequisites

- Java (JDK)
- Maven
- MySQL
- Postman (for testing)
- Your preferred IDE (Eclipse, IntelliJ, etc.)

### 3. Project Structure

- `src/main/java/com/example/ReadyWealth/controller`: Contains the controllers.
- `src/main/java/com/example/ReadyWealth/entity`: Contains the entity classes.
- `src/main/java/com/example/ReadyWealth/repository`: Contains the repositories.
- `src/main/java/com/example/ReadyWealth/service`: Contains the services.
- `src/main/resources`: Contains application properties and Hibernate configuration.

### 4. Setup

1. Clone the repository:
   bash
   git clone https://github.com/prajyotjagtap/Ready_Wealth_Assignment.git
   
2. Set up your MySQL database and configure `application.properties`.
3. Open the project in your IDE.
4. Run the application.

### 5. Endpoints

http://localhost:8080/expenses/{id} remove this url with according to your server.

#### 5.1. Get All Expenses

- **Endpoint:** `GET http://localhost:8080/expenses`
- **Description:** Get a list of all expenses.
- **Example Response:**
  json
  [
      {
          "id": 1,
          "description": "Groceries",
          "amount": 50.0
      }
  ]
  

#### 5.2. Get Expense by ID

- **Endpoint:** `GET http://localhost:8080/expenses/{id}`
- **Description:** Get details of a specific expense by ID.
- **Example Response:**
  json
  {
      "id": 1,
      "description": "Groceries",
      "amount": 50.0
  }
  

#### 5.3. Create Expense

- **Endpoint:** `POST http://localhost:8080/expenses`
- **Description:** Create a new expense.
- **Example Request:**
  json
  {
      "description": "Electronics",
      "amount": 300.0
  }
  
- **Example Response:**
  json
  {
      "id": 2,
      "description": "Electronics",
      "amount": 300.0
  }
  

#### 5.4. Update Expense

- **Endpoint:** `PUT http://localhost:8080/expenses/{id}`
- **Description:** Update an existing expense by ID.
- **Example Request:**
  json
  {
      "description": "Monthly Electronics Expenses",
      "amount": 350.0
  }
  
- **Example Response:**
  json
  {
      "id": 2,
      "description": "Monthly Electronics Expenses",
      "amount": 350.0
  }
  

#### 5.5. Delete Expense

- **Endpoint:** `DELETE http://localhost:8080/expenses/{id}`
- **Description:** Delete an expense by ID.

### 6. Testing

- Use Postman to test each endpoint and verify responses. Change the URL as needed for your server.

### 7. Error Handling

- Properly handle errors such as invalid input, not found, etc.
- Example error handling in the `updateExpense` method.

#### Example Error Handling

@PutMapping("/{id}")
    public ResponseEntity<String> updateExpense(@PathVariable Long id, @RequestBody Expense updatedExpense) {
        try {
            // Check if the expense with the given ID exists
            if (expenseService.isExpenseExists(id)) {
                // If the expense exists, update it with the provided data
                expenseService.updateExpense(id, updatedExpense);
                
                // Return a success response
                return ResponseEntity.ok("Expense updated successfully");
            } else {
                // If the expense with the given ID is not found, return a 404 response with an error message
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Expense not found with ID " + id);
            }
        } catch (ExpenseNotFoundException e) {
            // If an ExpenseNotFoundException is caught, it means the expense with the given ID is not found
            // Return a 404 response with an appropriate error message
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Expense not found with ID " + id);
        }
    }

