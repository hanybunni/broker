package com.ise.broker.sql.repositories;

import com.ise.broker.sql.entities.Account;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByInvestorInvestorID(Long investorID);
}