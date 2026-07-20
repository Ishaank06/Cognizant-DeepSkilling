import React from 'react';

const ScoreCalculator = ({ math, science, english }) => {
  const total = math + science + english;
  const average = total / 3;

  return (
    <div style={{ border: '1px solid #000', margin: '20px', padding: '15px', borderRadius: '8px', maxWidth: '400px' }}>
      <h2>Student Score Card</h2>
      <p>Math: {math}</p>
      <p>Science: {science}</p>
      <p>English: {english}</p>
      <hr />
      <h3>Total Score: {total}</h3>
      <h3>Average: {average.toFixed(2)}</h3>
    </div>
  );
};

export default ScoreCalculator;
