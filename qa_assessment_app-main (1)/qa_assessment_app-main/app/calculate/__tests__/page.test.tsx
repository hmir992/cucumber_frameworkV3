import { render, screen, fireEvent, waitFor } from '@testing-library/react';
import { useRouter } from 'next/navigation';
import CalculatePage from '../page';
import '@testing-library/jest-dom/'

jest.mock('next/navigation', () => ({
    useRouter: jest.fn(),
}));

describe('CalculatePage', () => {
    const mockRouter = {
        push: jest.fn(),
    };

    beforeEach(() => {
        jest.clearAllMocks();
        (useRouter as jest.Mock).mockReturnValue(mockRouter);
    });

    it('renders calculate form', () => {
        render(<CalculatePage />);

        expect(screen.getByLabelText(/Fuel on Return \(in eighths\)/i)).toBeInTheDocument();
        expect(screen.getByLabelText(/Fuel Price per Litre/i)).toBeInTheDocument();
        expect(screen.getByRole('button', { name: /Calculate/i })).toBeInTheDocument();
        expect(screen.getByRole('button', { name: /OK/i })).toBeInTheDocument();
    });

    it('calculates the fuel cost', async () => {
        render(<CalculatePage />);

        fireEvent.change(screen.getByLabelText(/Fuel on Return \(in eighths\)/i), { target: { value: '3' } });
        fireEvent.change(screen.getByLabelText(/Fuel Price per Litre/i), { target: { value: '1.5' } });
        fireEvent.click(screen.getByRole('button', { name: /Calculate/i }));

        await waitFor(() => {
            expect(screen.getByText(/Estimated Fuel Cost:/i)).toBeInTheDocument();
        });
    });

    it('disables OK button until Calculate is clicked', () => {
        render(<CalculatePage />);

        const okButton = screen.getByRole('button', { name: /OK/i });
        expect(okButton).toBeDisabled();

        fireEvent.change(screen.getByLabelText(/Fuel on Return \(in eighths\)/i), { target: { value: '3' } });
        fireEvent.change(screen.getByLabelText(/Fuel Price per Litre/i), { target: { value: '1.5' } });
        fireEvent.click(screen.getByRole('button', { name: /Calculate/i }));

        expect(okButton).not.toBeDisabled();
    });

    it('generates new car data when OK is clicked', async () => {
        render(<CalculatePage />);

        fireEvent.change(screen.getByLabelText(/Fuel on Return \(in eighths\)/i), { target: { value: '3' } });
        fireEvent.change(screen.getByLabelText(/Fuel Price per Litre/i), { target: { value: '1.5' } });
        fireEvent.click(screen.getByRole('button', { name: /Calculate/i }));

        const okButton = screen.getByRole('button', { name: /OK/i });
        expect(okButton).not.toBeDisabled();
        fireEvent.click(okButton);

        // this is incorrect, The .toHaveValue(null) assertion is incorrect because text input fields never have a null value in the DOM
        await waitFor(() => {
          //  expect(screen.getByLabelText(/Fuel on Return \(in eighths\)/i)).toHaveValue(null);
         //   expect(screen.getByLabelText(/Fuel Price per Litre/i)).toHaveValue(null);
        });
    });
    it('generates new car data when OK is clicked, v2', async () => {
        render(<CalculatePage />);

        fireEvent.change(screen.getByLabelText(/Fuel on Return \(in eighths\)/i), { target: { value: '3' } });
        fireEvent.change(screen.getByLabelText(/Fuel Price per Litre/i), { target: { value: '1.5' } });

        fireEvent.click(screen.getByRole('button', { name: /Calculate/i }));
        const okButton = screen.getByRole('button', { name: /OK/i });
        expect(okButton).not.toBeDisabled();
        fireEvent.click(okButton);

        // Wait for the form inputs to be cleared
        await waitFor(() => {
            // Explicitly cast to HTMLInputElement to avoid TypeScript error
            // when accessing the value property of an input field.
            const fuelOnReturnInput = screen.getByLabelText(/Fuel on Return \(in eighths\)/i) as HTMLInputElement;
            const fuelPriceInput = screen.getByLabelText(/Fuel Price per Litre/i) as HTMLInputElement;

            // this is a better way of doing the assertion, It asserts that the input fields are empty by checking .value === ''
            // Check that both the "Fuel on Return" and "Fuel Price" fields are empty
            expect(fuelOnReturnInput.value).toBe('');
            expect(fuelPriceInput.value).toBe('');
        });
    });
    it('generates new car data when OK is clicked v3', async () => {
        render(<CalculatePage />);

        fireEvent.change(screen.getByLabelText(/Fuel on Return \(in eighths\)/i), { target: { value: '3' } });
        fireEvent.change(screen.getByLabelText(/Fuel Price per Litre/i), { target: { value: '1.5' } });
        fireEvent.click(screen.getByRole('button', { name: /Calculate/i }));

        const okButton = screen.getByRole('button', { name: /OK/i });

        // Instead of checking input values, check if new car data (VIN) is generated.
        const previousVin = screen.getByText(/Return for vehicle \(VIN\):/i).textContent;
        fireEvent.click(okButton);
        await waitFor(() => {
            const newVin = screen.getByText(/Return for vehicle \(VIN\):/i).textContent;
            expect(newVin).not.toEqual(previousVin);
        });
    });

    it('1.\tTest that system does not return a negative fuel cost for Discrepancy range of 5% ', async () => {
        render(<CalculatePage />);

        fireEvent.change(screen.getByLabelText(/Fuel on Return \(in eighths\)/i), { target: { value: '8' } });
        fireEvent.change(screen.getByLabelText(/Fuel Price per Litre/i), { target: { value: '1' } });

        fireEvent.click(screen.getByRole('button', { name: /Calculate/i }));

        await waitFor(() => {
            const fuelCostText = screen.getByText(/Estimated Fuel Cost:/i);
            expect(fuelCostText).toBeInTheDocument();

            // Check if the calculated cost is not negative
            const fuelCost = parseFloat(fuelCostText.textContent?.replace('Estimated Fuel Cost: ', '').replace(' units', '') || '0');
            expect(fuelCost).toBeGreaterThanOrEqual(0); // Ensure the calculated fuel cost is not negative

            // this test fails, as noted in the bugs section of my document, i would open a bug this
        });
    });

    it('Test that ok button is disabled if before calculate button is pressed with valid inputs ', async () => {
        render(<CalculatePage />);

        // Simulate input for fuel on return and fuel price per litre
        fireEvent.change(screen.getByLabelText(/Fuel on Return \(in eighths\)/i), { target: { value: '8' } });
        fireEvent.change(screen.getByLabelText(/Fuel Price per Litre/i), { target: { value: '1' } });
        const okButton = screen.getByRole('button', { name: /OK/i });
        expect(okButton).toBeDisabled();
    });

});