import React from 'react';
import './App.css';
function App() {
  const inlineStyle = { color: '#333', border: '1px solid black', padding: '10px' };
  return (
    <div style={inlineStyle}>
      <h1 className="header">Cohort Dashboard</h1>
      <p>Demonstrating inline styles and CSS Modules.</p>
    </div>
  );
}
export default App;
