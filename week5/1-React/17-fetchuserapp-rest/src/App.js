import React, { useEffect, useState } from 'react';
import axios from 'axios';
function App() {
  const [users, setUsers] = useState([]);
  useEffect(() => {
    axios.get('https://jsonplaceholder.typicode.com/users').then(res => setUsers(res.data));
  }, []);
  return (
    <div>
      <h1>Fetch Users</h1>
      <ul>{users.map(u => <li key={u.id}>{u.name}</li>)}</ul>
    </div>
  );
}
export default App;
