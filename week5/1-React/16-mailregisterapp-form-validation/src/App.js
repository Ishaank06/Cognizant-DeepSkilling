import React, { useState } from 'react';
function App() {
  const [email, setEmail] = useState('');
  const [error, setError] = useState('');
  const validate = (e) => {
    setEmail(e.target.value);
    if (!e.target.value.includes('@')) setError('Invalid Email');
    else setError('');
  };
  return (
    <div>
      <h1>Registration</h1>
      <input type="email" value={email} onChange={validate} />
      {error && <span style={{color: 'red'}}>{error}</span>}
    </div>
  );
}
export default App;
