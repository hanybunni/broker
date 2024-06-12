import React from 'react';
import { BrowserRouter as Router, Route, Routes, useLocation } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Container } from 'react-bootstrap';
import FillDatabaseButton from './components/FillDatabaseButton';
import SelectInvestorAndAccount from './components/SelectInvestorAndAccount'; 
import './App.css'; 

const AppContent = () => {
  const location = useLocation();

  const handleDatabaseFilled = () => {
    console.log('Database has been filled');
  };

  return (
    <div className="App">
      <header className="StockBroker-header">
        <h1>Stock Broker</h1>
      </header>
      <Container className="mt-4">
        {location.pathname === '/' && (
          <FillDatabaseButton onClick={handleDatabaseFilled} />
        )}
        <Routes>
          <Route path="/" element={<div />} />
          <Route path="/select-investor-and-account" element={<SelectInvestorAndAccount />} />
        </Routes>
      </Container>
    </div>
  );
};

const App = () => (
  <Router>
    <AppContent />
  </Router>
);

export default App;
