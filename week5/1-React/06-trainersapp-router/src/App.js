import React from 'react';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
const Home = () => <h2>Home Page</h2>;
const Trainers = () => <h2>Trainers List</h2>;
function App() {
  return (
    <Router>
      <nav style={{ padding: '10px', background: '#ccc' }}>
        <Link to="/">Home</Link> | <Link to="/trainers">Trainers</Link>
      </nav>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/trainers" element={<Trainers />} />
      </Routes>
    </Router>
  );
}
export default App;
