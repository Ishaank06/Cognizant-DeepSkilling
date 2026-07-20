import React from 'react';
function App() {
  const office = { name: 'Tech Park', rent: 5000, available: true };
  return (
    <div>
      <h1>Office Space Rental (JSX)</h1>
      <p>Name: {office.name}</p>
      <p>Rent: ${office.rent}</p>
      <p>Status: {office.available ? 'Available' : 'Occupied'}</p>
    </div>
  );
}
export default App;
