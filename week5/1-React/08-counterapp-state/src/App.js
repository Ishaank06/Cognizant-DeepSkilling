import React, { useState } from 'react';
function App() {
  const [count, setCount] = useState(0);
  return (
    <div style={{textAlign: 'center', marginTop: '50px'}}>
      <h1>Counter: {count}</h1>
      <button onClick={() => setCount(c => c + 1)}>Increment</button>
      <button onClick={() => setCount(c => c - 1)}>Decrement</button>
    </div>
  );
}
export default App;
