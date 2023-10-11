package com.example.ReadyWealth.exception;

/**
 * Custom exception class to represent an exception when an expense is not found.
 * Extends the RuntimeException class for unchecked exception behavior.
 */
public class ExpenseNotFoundException extends RuntimeException {

    /**
     * Constructor for ExpenseNotFoundException.
     *
     * @param message The detail message (which is saved for later retrieval by the getMessage() method).
     */
    public ExpenseNotFoundException(String message) {
        // Call the constructor of the RuntimeException class with the provided message.
        super(message);
    }
}
