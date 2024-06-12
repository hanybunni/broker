package com.ise.broker.sql.services;

import com.ise.broker.sql.entities.Investor;
import com.ise.broker.sql.repositories.InvestorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class InvestorService {

    @Autowired
    private InvestorRepository investorRepository;

    public Optional<Investor> getInvestorById(Long investorID) {
        return investorRepository.findById(investorID);
    }

    public List<Investor> getAllInvestors() {
        return investorRepository.findAll();
    }
}
