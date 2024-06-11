import React from 'react';
import FillDatabaseButton from './components/FillDatabaseComponent';
import { Container, Row, Col } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';


function App() {
  return (
  <Container className="d-flex flex-column justify-content-center align-items-center" style={{ minHeight: '100vh', padding: '20px' }}>
    <Row className="mb-3">
      <Col>
        <h1 className="text-center">Stock Broker</h1>
      </Col>
    </Row>
    <Row>
      <Col>
        <FillDatabaseButton />
      </Col>
    </Row>
  </Container>
  );
}

export default App;
