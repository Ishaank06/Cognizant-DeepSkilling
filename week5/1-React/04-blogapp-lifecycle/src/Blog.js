import React, { Component } from 'react';

class Blog extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      timer: 0
    };
    console.log('[Blog] constructor called');
  }

  componentDidMount() {
    console.log('[Blog] componentDidMount called. Simulating data fetch...');
    // Simulate fetching blog posts
    setTimeout(() => {
      this.setState({
        posts: [
          { id: 1, title: 'React Lifecycle Methods', content: 'componentDidMount, componentDidUpdate, componentWillUnmount' },
          { id: 2, title: 'Understanding State', content: 'State is local and encapsulated.' }
        ]
      });
    }, 1000);

    // Start a timer to trigger componentDidUpdate
    this.intervalId = setInterval(() => {
      this.setState(prevState => ({ timer: prevState.timer + 1 }));
    }, 2000);
  }

  componentDidUpdate(prevProps, prevState) {
    if (prevState.timer !== this.state.timer) {
      console.log(`[Blog] componentDidUpdate called. Timer updated to: ${this.state.timer}`);
    }
  }

  componentWillUnmount() {
    console.log('[Blog] componentWillUnmount called. Cleaning up interval...');
    clearInterval(this.intervalId);
  }

  render() {
    console.log('[Blog] render called');
    return (
      <div style={{ border: '2px solid #333', padding: '15px', margin: '20px', borderRadius: '5px' }}>
        <h2>My Blog</h2>
        <p>Timer (updates every 2s): {this.state.timer}</p>
        
        {this.state.posts.length === 0 ? (
          <p>Loading posts...</p>
        ) : (
          this.state.posts.map(post => (
            <div key={post.id} style={{ borderBottom: '1px solid #ccc', marginBottom: '10px' }}>
              <h4>{post.title}</h4>
              <p>{post.content}</p>
            </div>
          ))
        )}
      </div>
    );
  }
}

export default Blog;
