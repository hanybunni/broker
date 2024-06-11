package com.ise.broker.sql.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ise.broker.sql.entities.Transaction;
import com.ise.broker.sql.repositories.TransactionRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transactions")

public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping
    public List<Transaction> getAllTransaction() {
        return transactionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Transaction> getTransactionById(@PathVariable Long id) {
        return transactionRepository.findById(id);
    }
    
}
