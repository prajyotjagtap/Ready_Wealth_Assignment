package com.example.ReadyWealth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ReadyWealth.entity.Expense;
import com.example.ReadyWealth.exception.ExpenseNotFoundException;
import com.example.ReadyWealth.service.ExpenseService;

import java.util.List;

/**
 * REST Controller for managing expenses.
 */
@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    /**
     * Retrieves all expenses.
     *
     * @return List of all expenses.
     */
    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<?> getExpenseById(@PathVariable Long id) {
        try {
            // Attempt to retrieve the expense by ID
            Expense expense = expenseService.getExpenseById(id);
            
            // If the expense is found, return a response with the expense
            return ResponseEntity.ok(expense);
        } catch (ExpenseNotFoundException e) {
            // If the expense with the given ID is not found, handle the exception
            // Return a response with a 404 status and a corresponding error message
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Expense not found with ID " + id);
        }
    }
    

    /**
     * Saves a new expense.
     *
     * @param expense The expense to be saved.
     * @return The saved expense.
     */
    @PostMapping
    public Expense saveExpense(@RequestBody Expense expense) {
        return expenseService.saveExpense(expense);
    }

    
    
    
    
    /**
     * Deletes an expense with the specified ID.
     *
     * @param id ID of the expense to be deleted.
     * @return ResponseEntity with a success message if the deletion is successful.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long id) {
        try {
            // Check if the expense with the given ID exists
            if (expenseService.isExpenseExists(id)) {
                // If the expense exists, delete it
                expenseService.deleteExpense(id);
                
                // Return a success response
                return ResponseEntity.ok("Expense deleted successfully");
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

    
    
    
    /**
     * Updates an existing expense with the given ID.
     *
     * @param id             ID of the expense to be updated.
     * @param updatedExpense Updated expense object.
     * @return A response indicating the result of the update operation.
     */
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

}
