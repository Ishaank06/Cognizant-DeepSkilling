import React from 'react';
import Student from './Student';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <h1>Class Components Demo</h1>
        <Student name="John Doe" age={20} course="Computer Science" />
        <Student name="Jane Smith" age={22} course="Information Technology" />
      </header>
    </div>
  );
}

export default App;
