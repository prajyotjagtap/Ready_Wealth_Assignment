package com.example.ReadyWealth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ReadyWealth.entity.Expense;

/**
 * Repository interface for managing expenses using Spring Data JPA.
 * Extends JpaRepository, providing CRUD operations for the Expense entity.
 */
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
