import React, { useState } from 'react';
function App() {
  const [isLogged, setIsLogged] = useState(false);
  return (
    <div>
      <h1>Ticket Booking</h1>
      {isLogged ? <h2>Welcome User! You can book tickets.</h2> : <h2>Please log in to book tickets.</h2>}
      <button onClick={() => setIsLogged(!isLogged)}>{isLogged ? 'Logout' : 'Login'}</button>
    </div>
  );
}
export default App;
