package com.ise.broker.sql.services;

import java.util.UUID;

import com.ise.broker.sql.entities.Investor;
import com.ise.broker.sql.repositories.InvestorRepository;

public class DatabaseFiller {
    private final InvestorRepository investorRepository;
    int INVESTOR_LIMIT = 30;

    public DatabaseFiller(
            InvestorRepository investorRepository) {
        this.investorRepository = investorRepository;
    }

    public void fillDatabase() {
        insertInvestors();
    }

    private void insertInvestors() {
        Investor[] investors = new Investor[INVESTOR_LIMIT];

        for (int i = 0; i < INVESTOR_LIMIT; i++) {
        }
}
}
