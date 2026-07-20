import React, { Component } from 'react';
import Blog from './Blog';
import './App.css';

class App extends Component {
  state = { showBlog: true };

  toggleBlog = () => {
    this.setState(prevState => ({ showBlog: !prevState.showBlog }));
  };

  render() {
    return (
      <div className="App">
        <header className="App-header">
          <h1>Lifecycle Hooks Demo</h1>
          <button onClick={this.toggleBlog} style={{ padding: '10px 20px', fontSize: '16px', cursor: 'pointer' }}>
            {this.state.showBlog ? 'Unmount Blog Component' : 'Mount Blog Component'}
          </button>
          
          {this.state.showBlog && <Blog />}
        </header>
      </div>
    );
  }
}

export default App;
