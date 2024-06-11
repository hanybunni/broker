import React from 'react';
import axios from 'axios';
import Button from 'react-bootstrap/Button';

const FillDatabaseButton = () => {
  const fillDatabase = async () => {
    try {
      const response = await axios.post('/api/database/fill');
      alert(response.data);
    } catch (error) {
      console.error('Error filling database:', error);
      alert('Error filling database.');
    }
  };
  return (
    <Button variant="primary" onClick={fillDatabase}>Fill Database</Button>
  );
};

export default FillDatabaseButton;