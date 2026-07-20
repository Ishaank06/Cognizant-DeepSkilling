#!/bin/bash
cd week5/1-React/

# App 5: Styling
echo "Generating App 5..."
npx -y create-react-app@latest 05-cohortdashboard-styling
cat << 'EOF' > 05-cohortdashboard-styling/src/App.js
import React from 'react';
import './App.css';
function App() {
  const inlineStyle = { color: '#333', border: '1px solid black', padding: '10px' };
  return (
    <div style={inlineStyle}>
      <h1 className="header">Cohort Dashboard</h1>
      <p>Demonstrating inline styles and CSS Modules.</p>
    </div>
  );
}
export default App;
EOF
cat << 'EOF' > 05-cohortdashboard-styling/src/App.css
.header { text-align: center; background-color: #eee; padding: 20px; }
EOF
echo "# Hands-On 5.1.5: CSS Styling" > 05-cohortdashboard-styling/NOTES.md

# App 6: Router
echo "Generating App 6..."
npx -y create-react-app@latest 06-trainersapp-router
cd 06-trainersapp-router && npm install react-router-dom && cd ..
cat << 'EOF' > 06-trainersapp-router/src/App.js
import React from 'react';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
const Home = () => <h2>Home Page</h2>;
const Trainers = () => <h2>Trainers List</h2>;
function App() {
  return (
    <Router>
      <nav style={{ padding: '10px', background: '#ccc' }}>
        <Link to="/">Home</Link> | <Link to="/trainers">Trainers</Link>
      </nav>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/trainers" element={<Trainers />} />
      </Routes>
    </Router>
  );
}
export default App;
EOF
echo "# Hands-On 5.1.6: React Router" > 06-trainersapp-router/NOTES.md

# App 7: Props
echo "Generating App 7..."
npx -y create-react-app@latest 07-shoppingapp-props
cat << 'EOF' > 07-shoppingapp-props/src/App.js
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
EOF
echo "# Hands-On 5.1.7: Props" > 07-shoppingapp-props/NOTES.md

# App 8: State
echo "Generating App 8..."
npx -y create-react-app@latest 08-counterapp-state
cat << 'EOF' > 08-counterapp-state/src/App.js
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
EOF
echo "# Hands-On 5.1.8: State" > 08-counterapp-state/NOTES.md

# App 9: ES6
echo "Generating App 9..."
npx -y create-react-app@latest 09-cricketapp-es6
cat << 'EOF' > 09-cricketapp-es6/src/App.js
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
EOF
echo "# Hands-On 5.1.9: ES6 Features" > 09-cricketapp-es6/NOTES.md

# App 10: JSX
echo "Generating App 10..."
npx -y create-react-app@latest 10-officespacerentalapp-jsx
cat << 'EOF' > 10-officespacerentalapp-jsx/src/App.js
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
EOF
echo "# Hands-On 5.1.10: JSX" > 10-officespacerentalapp-jsx/NOTES.md

# App 11: Events
echo "Generating App 11..."
npx -y create-react-app@latest 11-eventexamplesapp-events
cat << 'EOF' > 11-eventexamplesapp-events/src/App.js
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
EOF
echo "# Hands-On 5.1.11: Events" > 11-eventexamplesapp-events/NOTES.md

# App 12: Conditional Rendering
echo "Generating App 12..."
npx -y create-react-app@latest 12-ticketbookingapp-conditional
cat << 'EOF' > 12-ticketbookingapp-conditional/src/App.js
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
EOF
echo "# Hands-On 5.1.12: Conditional Rendering" > 12-ticketbookingapp-conditional/NOTES.md

# App 13: Lists & Keys
echo "Generating App 13..."
npx -y create-react-app@latest 13-bloggerapp-lists-keys
cat << 'EOF' > 13-bloggerapp-lists-keys/src/App.js
import React from 'react';
function App() {
  const blogs = [{ id: 1, title: 'React Basics' }, { id: 2, title: 'Advanced Hooks' }];
  return (
    <div>
      <h1>Blogger App</h1>
      <ul>
        {blogs.map(blog => <li key={blog.id}>{blog.title}</li>)}
      </ul>
    </div>
  );
}
export default App;
EOF
echo "# Hands-On 5.1.13: Lists and Keys" > 13-bloggerapp-lists-keys/NOTES.md

# App 14: Context API
echo "Generating App 14..."
npx -y create-react-app@latest 14-employeeapp-context
cat << 'EOF' > 14-employeeapp-context/src/App.js
import React, { createContext, useContext, useState } from 'react';
const ThemeContext = createContext();
const Employee = () => {
  const theme = useContext(ThemeContext);
  return <div style={{ background: theme === 'dark' ? '#333' : '#FFF', color: theme === 'dark' ? '#FFF' : '#000', padding: '20px' }}>Employee Component</div>;
};
function App() {
  const [theme, setTheme] = useState('light');
  return (
    <ThemeContext.Provider value={theme}>
      <h1>Context API Demo</h1>
      <button onClick={() => setTheme(theme === 'light' ? 'dark' : 'light')}>Toggle Theme</button>
      <Employee />
    </ThemeContext.Provider>
  );
}
export default App;
EOF
echo "# Hands-On 5.1.14: Context API" > 14-employeeapp-context/NOTES.md

# App 15: Forms
echo "Generating App 15..."
npx -y create-react-app@latest 15-ticketraisingapp-forms
cat << 'EOF' > 15-ticketraisingapp-forms/src/App.js
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
EOF
echo "# Hands-On 5.1.15: Forms" > 15-ticketraisingapp-forms/NOTES.md

# App 16: Form Validation
echo "Generating App 16..."
npx -y create-react-app@latest 16-mailregisterapp-form-validation
cat << 'EOF' > 16-mailregisterapp-form-validation/src/App.js
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
EOF
echo "# Hands-On 5.1.16: Form Validation" > 16-mailregisterapp-form-validation/NOTES.md

# App 17: REST APIs
echo "Generating App 17..."
npx -y create-react-app@latest 17-fetchuserapp-rest
cd 17-fetchuserapp-rest && npm install axios && cd ..
cat << 'EOF' > 17-fetchuserapp-rest/src/App.js
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
EOF
echo "# Hands-On 5.1.17: Consuming REST APIs" > 17-fetchuserapp-rest/NOTES.md

# App 18: Testing (Jest/Enzyme)
echo "Generating App 18..."
cp -R 05-cohortdashboard-styling 18-cohortdashboard-testing
cat << 'EOF' > 18-cohortdashboard-testing/src/App.test.js
import { render, screen } from '@testing-library/react';
import App from './App';
test('renders Dashboard text', () => {
  render(<App />);
  const linkElement = screen.getByText(/Cohort Dashboard/i);
  expect(linkElement).toBeInTheDocument();
});
EOF
echo "# Hands-On 5.1.18: Testing" > 18-cohortdashboard-testing/NOTES.md

# App 19: Jest Mocking
echo "Generating App 19..."
npx -y create-react-app@latest 19-gitclientapp-mocking
cat << 'EOF' > 19-gitclientapp-mocking/src/App.js
import React from 'react';
function App() { return <h1>Git Client Mocking App</h1>; }
export default App;
EOF
cat << 'EOF' > 19-gitclientapp-mocking/src/App.test.js
import { render, screen } from '@testing-library/react';
import App from './App';
test('mocking example', () => {
  const mockFn = jest.fn(() => 'mocked');
  expect(mockFn()).toBe('mocked');
});
EOF
echo "# Hands-On 5.1.19: Jest Mocking" > 19-gitclientapp-mocking/NOTES.md

echo "ALL REACT APPS GENERATED!"
