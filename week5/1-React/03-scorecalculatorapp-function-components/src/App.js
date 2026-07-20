import React from 'react';
import ScoreCalculator from './ScoreCalculator';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <h1>Function Components Demo</h1>
        <ScoreCalculator math={85} science={90} english={78} />
        <ScoreCalculator math={95} science={88} english={92} />
      </header>
    </div>
  );
}

export default App;
