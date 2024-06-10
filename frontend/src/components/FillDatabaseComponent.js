import React from 'react';
import axios from 'axios';

import Button from 'react-bootstrap/Button';

const FillDatabaseComponent = () => {
  const handleClick = async () => {
    try {
      await axios.post('http://localhost:8080/api/fillDatabase');
      alert('Database filled successfully!');
    } catch (error) {
      console.error('Error filling database:', error);
      alert('Error filling database.');
    }
  };
  return (
    <Button variant="primary">Fill Database</Button>
  );
};

export default FillDatabaseComponent;