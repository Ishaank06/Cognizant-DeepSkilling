import { render, screen } from '@testing-library/react';
import App from './App';
test('mocking example', () => {
  const mockFn = jest.fn(() => 'mocked');
  expect(mockFn()).toBe('mocked');
});
