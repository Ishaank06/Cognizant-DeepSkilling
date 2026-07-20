import React from 'react';
function App() {
  const players = ['Virat', 'Dhoni', 'Rohit'];
  const team = [...players, 'Bumrah']; // ES6 Spread
  return (
    <div>
      <h1>Cricket App (ES6 Features)</h1>
      <ul>{team.map((p, i) => <li key={i}>{p}</li>)}</ul>
    </div>
  );
}
export default App;
