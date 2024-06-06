package com.ise.broker;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import com.ise.broker.sql.repositories.InvestorRepository;
import com.ise.broker.sql.services.DatabaseFiller;

public class DatabaseFillerTest {

    @Test
    public void testFillDatabase() {
        InvestorRepository investorRepository = mock(InvestorRepository.class);
        DatabaseFiller databaseFiller = new DatabaseFiller(investorRepository);
        databaseFiller.fillDatabase();
        verify(investorRepository).saveAll(anyList());
    }
}
