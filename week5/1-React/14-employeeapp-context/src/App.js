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
