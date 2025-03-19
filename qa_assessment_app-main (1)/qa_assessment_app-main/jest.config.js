import nextJest from 'next/jest.js';

const createJestConfig = nextJest({
  dir: './',
});

const customJestConfig = {
  setupFilesAfterEnv: ['<rootDir>/jest.setup.js'],
  testEnvironment: 'jest-environment-jsdom',
  testPathIgnorePatterns: [
    '/node_modules/',
    'app/calculate/__tests__/jest.d.ts',
    'app/login/__tests__/jest.d.ts',
  ],
};

export default createJestConfig(customJestConfig); 