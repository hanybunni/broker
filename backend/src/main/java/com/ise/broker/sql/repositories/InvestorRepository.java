package com.ise.broker.sql.repositories;

import com.ise.broker.sql.entities.Investor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestorRepository extends JpaRepository<Investor, Long> {
}
