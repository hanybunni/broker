import React, { useState, useEffect } from 'react';
import axios from 'axios';

const AccountDropdown = ({ investorId, onSelectAccount }) => {
  const [accounts, setAccounts] = useState([]);

  useEffect(() => {
    const fetchAccounts = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/api/accounts/byInvestor/${investorId}`);
        setAccounts(response.data);
      } catch (error) {
        console.error('Error fetching accounts:', error);
      }
    };

    if (investorId) {
      fetchAccounts();
    }
  }, [investorId]);

  return (
    <select onChange={(e) => onSelectAccount(e.target.value)}>
      <option value="">Select Account</option>
      {accounts.map((account) => (
        <option key={account.accountID} value={account.accountID}>
          {account.type}
        </option>
      ))}
    </select>
  );
};

export default AccountDropdown;
