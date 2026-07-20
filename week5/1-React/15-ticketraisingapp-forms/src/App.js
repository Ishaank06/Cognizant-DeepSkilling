import React, { useState } from 'react';
function App() {
  const [ticket, setTicket] = useState('');
  const handleSubmit = (e) => { e.preventDefault(); alert(`Ticket raised: ${ticket}`); };
  return (
    <form onSubmit={handleSubmit}>
      <h1>Raise a Ticket</h1>
      <input type="text" value={ticket} onChange={(e) => setTicket(e.target.value)} required />
      <button type="submit">Submit</button>
    </form>
  );
}
export default App;
