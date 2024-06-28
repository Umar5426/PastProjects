/*
=========================================================
Name : App.js
=========================================================
*/

import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import HomePage from './components/Homepage'; // Adjust the import path if necessary
import ProductPage from './components/ProductPage'; // Adjust the import path if necessary
import LoginPage from './components/LoginPage'; // Adjust the import path if necessary
import PrivateRoute from './components/PrivateRoute'; // Adjust the import path if necessary
import { AuthProvider } from './components/AuthContext'; // Adjust the import path if necessary

const App = () => {
  return (
    <AuthProvider>
      <Router>
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route 
            path="/products" 
            element={
              <PrivateRoute>
                <ProductPage />
              </PrivateRoute>
            } 
          />
          <Route path="/login" element={<LoginPage />} />
          {/* You can add more routes as needed */}
        </Routes>
      </Router>
    </AuthProvider>
  );
};

export default App;

