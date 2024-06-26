package com.ise.broker.sql.repositories;

import com.ise.broker.sql.entities.Investor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestorRepository extends JpaRepository<Investor, Long> {
}
