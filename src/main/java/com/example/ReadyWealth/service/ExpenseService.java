package com.example.ReadyWealth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ReadyWealth.entity.Expense;
import com.example.ReadyWealth.exception.ExpenseNotFoundException;
import com.example.ReadyWealth.repository.ExpenseRepository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Service class for managing expenses.
 */
@Service
public class ExpenseService {

	/**
	 * The logger for the ExpenseService class.
	 * It is used to log messages and errors for better visibility and debugging.
	 */
	private static final Logger logger = LoggerFactory.getLogger(ExpenseService.class);

	
    @Autowired
    private ExpenseRepository expenseRepository;

    /**
     * Retrieves all expenses from the repository.
     *
     * @return List of all expenses.
     */
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    /**
     * Retrieves an expense by its unique identifier (ID).
     *
     * @param id The ID of the expense to retrieve.
     * @return The expense with the specified ID, if found.
     * @throws ExpenseNotFoundException If no expense is found with the given ID.
     */
    public Expense getExpenseById(Long id) {
        // Retrieve the expense from the repository using the provided ID.
        // If the expense with the given ID is present, return it; otherwise, throw an ExpenseNotFoundException.
        return expenseRepository.findById(id)
                .orElseThrow(() -> new ExpenseNotFoundException("Expense with ID " + id + " not found"));
    }



    /**
     * Saves a new expense to the repository.
     *
     * @param expense The expense to be saved.
     * @return The saved expense.
     */
    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    
    /**
     * Deletes an expense by its ID.
     *
     * @param id ID of the expense to be deleted.
     */
    public void deleteExpense(Long id) {
        // Check if the expense with the given ID exists before attempting to delete
        if (isExpenseExists(id)) {
            expenseRepository.deleteById(id);
            logger.info("Expense with ID {} deleted successfully", id);
        } else {
            logger.warn("Attempted to delete non-existing expense with ID {}", id);
         }
    }

    
    
    
 
    

    public void updateExpense(Long id, Expense expense) {
       
        Expense existingExpense = expenseRepository.findById(id)
                .orElseThrow(() -> new ExpenseNotFoundException("Expense not found with ID " + id));

        // Update existingExpense with new values from the expense parameter

        // Save the updated expense
        expenseRepository.save(existingExpense);
    }

    public boolean isExpenseExists(Long id) {
        // Check if the expense with the given ID exists
        return expenseRepository.existsById(id);
    }

}
