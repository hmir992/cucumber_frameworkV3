// app/lib/db.ts
import sqlite3 from 'sqlite3';

const db = new sqlite3.Database(':memory:'); // In-memory SQLite DB for simplicity

// Initialize the database with users (example: username and password)
db.serialize(() => {
  db.run("CREATE TABLE users (id INT, username TEXT, password TEXT)");

  const stmt = db.prepare("INSERT INTO users VALUES (?, ?, ?)");
  stmt.run(1, 'admin', 'password123');  // User with username 'admin' and password 'password123'
  stmt.run(2, 'guest', 'guestpassword'); // Another user
  stmt.finalize();
});

export default db;
