import React, { Component } from 'react';

class Student extends Component {
  render() {
    const { name, age, course } = this.props;
    return (
      <div style={{ border: '1px solid #ccc', margin: '10px', padding: '10px', borderRadius: '5px' }}>
        <h2>Student Profile</h2>
        <p><strong>Name:</strong> {name}</p>
        <p><strong>Age:</strong> {age}</p>
        <p><strong>Course:</strong> {course}</p>
      </div>
    );
  }
}

export default Student;
