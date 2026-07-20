import { render, screen } from '@testing-library/react';
import App from './App';
test('renders Dashboard text', () => {
  render(<App />);
  const linkElement = screen.getByText(/Cohort Dashboard/i);
  expect(linkElement).toBeInTheDocument();
});
