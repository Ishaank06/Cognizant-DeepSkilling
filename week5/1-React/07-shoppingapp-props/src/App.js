import React from 'react';
const Product = ({ name, price }) => <div style={{border: '1px solid gray', margin: '5px'}}><h3>{name}</h3><p>Price: ${price}</p></div>;
function App() {
  return (
    <div>
      <h1>Shopping App (Props)</h1>
      <Product name="Laptop" price={999} />
      <Product name="Phone" price={499} />
    </div>
  );
}
export default App;
