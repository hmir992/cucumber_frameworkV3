import { test, expect } from '@playwright/test';

test('Testing Fuel on return 8/8 and Fuel Price per Litre cost to be 1 euro', async ({ page }) => {
  await page.goto('http://localhost:3000');

  // Assert we on the login page
  const loginHeading = page.locator('h1', { hasText: 'Login' });
  await expect(loginHeading).toBeVisible()

  await page.fill('#username', 'guest');
  await page.fill('#password', 'guestpassword');

  await page.click('.button[type="submit"]');

  // Assert we are on the file Fuel Return page
  const fuelCheckerHeader = page.locator('h1', { hasText: 'Fuel Return Checker' });
  await expect(fuelCheckerHeader).toBeVisible()


  await page.fill('#fuelOnReturn', '8');
  await page.fill('#fuelPrice', '1');


  // wait for elements
  const calculateButton = page.locator('button.button.half-button', { hasText: 'Calculate' });

  await calculateButton.click();

  // Wait for the elements
  const fuelCostElement = page.locator('.form-group', { hasText: /Estimated Fuel Cost:/ });
  
  await fuelCostElement.click();

  const resultText = await fuelCostElement.innerText();

  // Assert that the fuel cost is 0 as we expect
  // the test to fail see bug 2 in my documentation, System returns Negative Fuel Cost Calculations for Discrepancy
  expect(resultText).toContain('Estimated Fuel Cost: 0 units');
});
