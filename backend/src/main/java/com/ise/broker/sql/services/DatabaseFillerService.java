package com.ise.broker.sql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;
import com.ise.broker.sql.entities.Investor;
import com.ise.broker.sql.repositories.InvestorRepository;

@Service
public class DatabaseFillerService {

    @Autowired
    private final InvestorRepository investorRepository;

    int INVESTOR_LIMIT = 30;

    public DatabaseFillerService(InvestorRepository investorRepository) {
        this.investorRepository = investorRepository;
    }

    public void fillDatabase() {
        insertInvestors();
    }

    private void insertInvestors() {
        Investor[] investors = new Investor[INVESTOR_LIMIT];

        for (int i = 0; i < INVESTOR_LIMIT; i++) {
            var name = Faker.instance().name();
            var address = Faker.instance().address();
            var email = name.firstName() + "." + name.lastName() + "@gmail.com";
            var phone = Faker.instance().phoneNumber();
            var citizenship = Faker.instance().country();

            Investor investor = new Investor();
            
            investor.setName(name.fullName());
            investor.setAddress(address.fullAddress());
            investor.setEmail(email);
            investor.setPhone(phone.phoneNumber());
            investor.setCitizenship(citizenship.countryCode2());

            investors[i] = investor;
        }

        investorRepository.saveAll(List.of(investors));
    }
}
