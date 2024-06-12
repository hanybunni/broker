import React, { useState, useEffect } from 'react';
import axios from 'axios';

const InvestorDropdown = ({ onSelectInvestor }) => {
  const [investors, setInvestors] = useState([]);

  useEffect(() => {
    const fetchInvestors = async () => {
      try {
        const response = await axios.get('http://localhost:8080/api/investors');
        setInvestors(response.data);
      } catch (error) {
        console.error('Error fetching investors:', error);
      }
    };

    fetchInvestors();
  }, []);

  return (
    <select onChange={(e) => onSelectInvestor(e.target.value)}>
      <option value="">Select Investor</option>
      {investors.map((investor) => (
        <option key={investor.investorID} value={investor.investorID}>
          {investor.name}
        </option>
      ))}
    </select>
  );
};

export default InvestorDropdown;
