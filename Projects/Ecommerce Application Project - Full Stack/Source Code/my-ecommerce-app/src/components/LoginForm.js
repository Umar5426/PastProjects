/*
=========================================================
Name : LoginForm.js
=========================================================
*/

import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { useAuth } from './AuthContext';

function LoginForm({ switchToSignup }) {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [errorMessage, setErrorMessage] = useState('');
  const navigate = useNavigate();
  const { loginUser } = useAuth();

  const handleLogin = (e) => {
    e.preventDefault();
    setErrorMessage('');

    fetch('http://localhost:5000/login', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ username, password }),
    })
    .then(response => {
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      return response.json();
    })
    .then(data => {
      if (data.message === "Login successful.") {
        loginUser(); // Updates authentication state to true
        navigate('/products'); // Redirect to products page
      } else {
        setErrorMessage(data.error || 'Login failed');
      }
    })
    .catch(error => {
      console.error('Error during login:', error);
      setErrorMessage(error.toString());
    });
  };

  return (
    <div className="login-form">
      <h2>Login</h2>
      {errorMessage && <p className="error-message">{errorMessage}</p>}
      <form onSubmit={handleLogin}>
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
        <button type="submit">Login</button>
      </form>
      <p>
        Don't have an account?
        <button type="button" onClick={switchToSignup}>
          Signup
        </button>
      </p>
    </div>
  );
}

export default LoginForm;


