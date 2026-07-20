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
