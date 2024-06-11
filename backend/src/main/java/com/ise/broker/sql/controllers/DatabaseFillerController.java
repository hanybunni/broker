package com.ise.broker.sql.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ise.broker.sql.services.DatabaseFillerService;

@RestController
@RequestMapping("/api/database")
public class DatabaseFillerController {

    @Autowired
    private final DatabaseFillerService databaseFillerService;

    public DatabaseFillerController(DatabaseFillerService databaseFillerService) {
        this.databaseFillerService = databaseFillerService;
    }

    @PostMapping("/fill")
    public ResponseEntity<String> fillDatabase() {
        databaseFillerService.fillDatabase();
        return ResponseEntity.ok("Database filled successfully.");
    }
}