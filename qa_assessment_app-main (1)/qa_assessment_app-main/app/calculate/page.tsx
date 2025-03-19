// app/calculate/page.tsx
'use client';
import { useEffect, useState } from 'react';
import { getCookie, deleteCookie } from 'cookies-next';
import { useRouter } from 'next/navigation';
import '../styles/forms.css';

const CalculatePage = () => {
  const [fuelOnReturn, setFuelOnReturn] = useState('');
  const [telematicsFuel, setTelematicsFuel] = useState(0);
  const [tankSize, setTankSize] = useState(0);
  const [fuelPrice, setFuelPrice] = useState('');
  const [calculatedCost, setCalculatedCost] = useState<number | null>(null);
  const [loggedInUser, setLoggedInUser] = useState<string | null>(null);
  const [vin, setVin] = useState('');
  const [isCalculated, setIsCalculated] = useState(false);
  const router = useRouter();

  useEffect(() => {
    const user = getCookie('user');  // Check if user is logged in by reading cookie
    if (!user) {
      router.push('/login');  // Redirect to login if no user session exists
    } else {
      setLoggedInUser(user as string);  // Set logged-in user
    }

    generateNewCarData();
  }, [router]);

  const generateNewCarData = () => {
    const tankSizes = [45, 50, 55, 60, 65, 70];
    const randomTankSize = tankSizes[Math.floor(Math.random() * tankSizes.length)];
    const randomTelematicsFuel = Math.floor(Math.random() * 101);
    const randomVin = `VIN${Math.floor(Math.random() * 1000000)}`;

    setTankSize(randomTankSize);
    setTelematicsFuel(randomTelematicsFuel);
    setVin(randomVin);

    // Clear form and previous calculation
    setFuelOnReturn('');
    setFuelPrice('');
    setCalculatedCost(null);
    setIsCalculated(false);

    console.log('New Car Data:', { randomVin, randomTankSize, randomTelematicsFuel });
  };

  const handleCalculation = () => {
    const fuelOnReturnEighths = parseFloat(fuelOnReturn);
    const fuelOnReturnPercentage = (fuelOnReturnEighths / 8) * 100;
    const fuelPricePerLitre = parseFloat(fuelPrice);

    if (Math.abs(fuelOnReturnPercentage - telematicsFuel) <= 3) {
      setCalculatedCost(0);  // No charge/credit if within 3%
    } else {
      const fuelDifference = (telematicsFuel - fuelOnReturnPercentage) / 100 * tankSize;
      const cost = fuelDifference * fuelPricePerLitre;
      setCalculatedCost(cost);
    }

    setIsCalculated(true);
    console.log('Calculation Data:', { telematicsFuel, calculatedCost });
  };

  const handleLogout = () => {
    deleteCookie('user');
    router.push('/login');
  };

  return (
      <div className="container">
        <h1>Fuel Return Checker</h1>
        {loggedInUser && (
            <div className="form-group">
              <p>Logged in as: {loggedInUser}</p>
              <button className="button" onClick={handleLogout}>Log out</button>
            </div>
        )}
        <div className="form-group">
          <label>Return for vehicle (VIN): {vin}</label>
        </div>
        <div className="form-group">
          <label htmlFor="fuelOnReturn">Fuel on Return (in eighths)</label>
          <input
              type="number"
              id="fuelOnReturn"
              value={fuelOnReturn}
              onChange={(e) => setFuelOnReturn(e.target.value)}
          />
        </div>
        <div className="form-group">
          <label htmlFor="fuelPrice">Fuel Price per Litre</label>
          <input
              type="number"
              id="fuelPrice"
              value={fuelPrice}
              onChange={(e) => setFuelPrice(e.target.value)}
          />
        </div>
        <div className="form-group button-group">
          <button className="button half-button" onClick={generateNewCarData} disabled={!isCalculated}>OK</button>
          <button className="button half-button" onClick={handleCalculation}>Calculate</button>
        </div>

        {calculatedCost !== null && (
            <p className="form-group">
              {calculatedCost === 0
                  ? 'Fuel level is within acceptable range.'
                  : `Estimated Fuel Cost: ${calculatedCost.toFixed(2)} units`}
            </p>
        )}
      </div>
  );
};

export default CalculatePage;