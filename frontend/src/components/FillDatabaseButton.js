import React from 'react';
import axios from 'axios';
import Button from 'react-bootstrap/Button';
import { useNavigate } from 'react-router-dom';

const FillDatabaseButton = ({ onClick }) => {
  const navigate = useNavigate();

  const fillDatabase = async () => {
    try {
      const response = await axios.post('http://localhost:8080/api/database/fill');
      if (response.status === 200) {
        console.log('Database filled successfully');
        onClick();
        navigate('/select-investor-and-account'); 
      } else {
        console.error('Error filling database:', response.statusText);
        alert('Error filling database: ' + response.statusText);
      }
    } catch (error) {
      console.error('Error filling database:', error);
      alert('Error filling database: ' + error.message);
    }
  };

  return (
    <Button variant="dark" onClick={fillDatabase}>Fill Database</Button>
  );
};

export default FillDatabaseButton;
