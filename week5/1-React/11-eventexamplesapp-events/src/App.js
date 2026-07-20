import React, { useState } from 'react';
function App() {
  const [text, setText] = useState('');
  return (
    <div>
      <h1>Event Handling</h1>
      <input type="text" onChange={(e) => setText(e.target.value)} placeholder="Type here..." />
      <button onClick={() => alert(`You typed: ${text}`)}>Show Alert</button>
    </div>
  );
}
export default App;
