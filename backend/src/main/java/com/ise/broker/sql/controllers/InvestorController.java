package com.ise.broker.sql.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ise.broker.sql.entities.Investor;
import com.ise.broker.sql.repositories.InvestorRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/investors")
public class InvestorController {

    @Autowired
    private InvestorRepository investorRepository;

    @GetMapping
    public List<Investor> getAllInvestors() {
        return investorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Investor> getInvestorById(@PathVariable Long id) {
        return investorRepository.findById(id);
    }
}
