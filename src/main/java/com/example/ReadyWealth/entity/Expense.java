package com.example.ReadyWealth.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Entity class representing an expense.
 */
@Entity
public class Expense {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private double amount;

    /**
     * Gets the ID of the expense.
     *
     * @return The ID of the expense.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the expense.
     *
     * @param id The ID to set for the expense.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the description of the expense.
     *
     * @return The description of the expense.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the expense.
     *
     * @param description The description to set for the expense.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the amount of the expense.
     *
     * @return The amount of the expense.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the amount of the expense.
     *
     * @param amount The amount to set for the expense.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
