package com.ise.broker;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import com.ise.broker.sql.repositories.InvestorRepository;
import com.ise.broker.sql.services.DatabaseFillerService;

public class DatabaseFillerTest {

    @Test
    public void testFillDatabase() {
        InvestorRepository investorRepository = mock(InvestorRepository.class);
        DatabaseFillerService databaseFiller = new DatabaseFillerService(investorRepository);
        databaseFiller.fillDatabase();
        verify(investorRepository).saveAll(anyList());
    }
}
