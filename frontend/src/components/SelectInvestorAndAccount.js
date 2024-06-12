import React, { useState } from 'react';
import InvestorDropdown from './InvestorDropdown';
import AccountDropdown from './AccountDropdown';
import { Button } from 'react-bootstrap';


const SelectInvestorAndAccount = () => {
  const [selectedInvestor, setSelectedInvestor] = useState('');
  const [selectedAccount, setSelectedAccount] = useState('');

  const handleSelectInvestor = (investorId) => {
    setSelectedInvestor(investorId);
    setSelectedAccount('');
  };

  const handleSelectAccount = (accountId) => {
    setSelectedAccount(accountId);
  };

  const handleSubmit = () => {
    console.log('Selected Investor:', selectedInvestor);
    console.log('Selected Account:', selectedAccount);
  };

  return (
    <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
      <div>Please select investor:</div>
      <InvestorDropdown onSelectInvestor={handleSelectInvestor} />
      {selectedInvestor && (
        <div style={{ marginTop: 10 }}>Please select account:</div>
      )}
      
        <AccountDropdown investorId={selectedInvestor} onSelectAccount={handleSelectAccount} />
      
       <Button 
        variant="dark"
        onClick={handleSubmit}
        style={{ marginTop: 10 }}
      >
        Login
      </Button>
    </div>
  );
};

export default SelectInvestorAndAccount;
