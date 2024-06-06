package com.ise.broker.sql.services;

import java.util.List;
import com.github.javafaker.Faker;
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
            var fullName = Faker.instance().name();
            var address = Faker.instance().address();
            var email = fullName.firstName() + "." + fullName.lastName() + "@gmail.com";
            var phone = Faker.instance().phoneNumber();
            var citizenship = Faker.instance().country();

            investors[i] = new Investor();
        }

        investorRepository.saveAll(List.of(investors));
    }
}
