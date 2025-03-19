// app/api/login/route.ts
import { NextResponse } from 'next/server';
import db from '../../lib/db';  // Note: path might need adjustment based on your db file location
import fs from 'fs';

type LogData = string | number | boolean | object | null | undefined;

type User = {
  username: string;
  password: string;
};

// Synchronous logging function
function serverLog(message: string, data?: LogData) {
  const timestamp = new Date().toISOString();
  const logMessage = `\n${timestamp} - ${message} ${data ? JSON.stringify(data, null, 2) : ''}`;
  
  // Write to file synchronously
  fs.appendFileSync('server.log', logMessage);
  
  // Also print to stdout and stderr
  process.stdout.write('\nSERVER LOG: ' + logMessage);
  process.stderr.write('\nSERVER ERROR: ' + logMessage);
}

export async function POST(request: Request) {
  
  try {
    const { username, password } = await request.json();
    serverLog('Login attempt for:', { username });

    // Debug: Check DB state
    db.all("SELECT * FROM users", [], (err, allUsers) => {
      serverLog('Current DB contents:', allUsers);
      if (err) serverLog('DB Error:', err);
    });

    const allUsers = await new Promise<User[]>((resolve) => {
      db.all("SELECT username, password FROM users", [], (err, rows) => {
        if (err) {
          serverLog('Database error on select:', err);
          resolve([]);
        } else {
          serverLog('Users found in DB:', rows);
          resolve(rows as User[] || []);
        }
      });
    });

    const response = {
      message: 'Login attempt processed',
      allUsers: allUsers,
      receivedData: { username, password }
    };

    serverLog('Sending response:', response);
    const user = allUsers.find(u => u.username === username);

    if (user && user.password === password) {
      return NextResponse.json({
        message: 'Login successful',
        allUsers
      });
    }else{

    }
    return NextResponse.json({
      error: 'Invalid username or password',
      allUsers
    }, { status: 404 });

  } catch (error) {
    const errorMessage = error instanceof Error ? error.message : String(error);
    serverLog('Error in route:', { error: errorMessage });
    return NextResponse.json({ 
      error: 'Failed to process request',
      debug: errorMessage
    }, { status: 400 });
  }
}
