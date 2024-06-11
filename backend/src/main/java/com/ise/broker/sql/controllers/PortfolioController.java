package com.ise.broker.sql.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ise.broker.sql.entities.Portfolio;
import com.ise.broker.sql.repositories.PortfolioRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/portfolio")

public class PortfolioController {

    @Autowired
    private PortfolioRepository portfolioRepository;

    @GetMapping
    public List<Portfolio> getAllPortfolio() {
        return portfolioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Portfolio> getPortfolioById(@PathVariable Long id) {
        return portfolioRepository.findById(id);
    }
    
}
