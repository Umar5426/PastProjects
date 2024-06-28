/*
=========================================================
Name : SignupForm.js
=========================================================
*/

import React, { useState } from 'react';

function SignupForm({ switchToLogin }) {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');
  const [email, setEmail] = useState('');
  const [errorMessage, setErrorMessage] = useState('');
  const [successMessage, setSuccessMessage] = useState('');

  const handleSignup = (e) => {
    e.preventDefault();
    setErrorMessage('');
    setSuccessMessage('');
  
    if (password !== confirmPassword) {
      setErrorMessage("Passwords don't match.");
      return;
    }
  
    fetch('http://localhost:5000/register', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ username, password, email }),
    })
    .then(response => {
      if (response.ok) {
        return response.json();
      } else if (response.status === 400) {
        throw new Error('Username taken.');
      } else {
        return response.text().then(text => { throw new Error(text || 'Network response was not ok'); });
      }
    })
    .then(data => {
      setSuccessMessage('Account created.');
    })
    .catch(error => {
      console.error('Error during registration:', error);
      setErrorMessage(error.message || error.toString());
    });
  };

  return (
    <div className="signup-form">
      <h2>Signup</h2>
      {successMessage && <div className="success-message">{successMessage}</div>}
      {errorMessage && <div className="error-message">{errorMessage}</div>}
      <form onSubmit={handleSignup}>
        <div className="form-group">
          <label htmlFor="username">Username:</label>
          <input
            type="text"
            id="username"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            placeholder="Enter your username"
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="password">Password:</label>
          <input
            type="password"
            id="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            placeholder="Enter your password"
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="confirm-password">Confirm Password:</label>
          <input
            type="password"
            id="confirm-password"
            value={confirmPassword}
            onChange={(e) => setConfirmPassword(e.target.value)}
            placeholder="Confirm your password"
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="email">Email:</label>
          <input
            type="email"
            id="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            placeholder="Enter your email"
            required
          />
        </div>
        <button type="submit" className="signup-button">Signup</button>
      </form>
      <p>Already have an account? 
        <button type="button" className="switch-to-login" onClick={switchToLogin}>Login</button>
      </p>
    </div>
  );
}

export default SignupForm;