/*
=========================================================
Name : AuthContext.js
=========================================================
*/

import React, { createContext, useContext, useState } from 'react';

const AuthContext = createContext(null);

export const AuthProvider = ({ children }) => {
  const [isAuthenticated, setIsAuthenticated] = useState(false);

  // Check if user can access product page
  const loginUser = () => {
    localStorage.setItem('isAuthenticated', 'true');
    setIsAuthenticated(true);
  };

  const logoutUser = () => {
    localStorage.removeItem('isAuthenticated');
    setIsAuthenticated(false);
  };

  React.useEffect(() => {
    const isAuth = localStorage.getItem('isAuthenticated');
    setIsAuthenticated(isAuth === 'true');
  }, []);

  return (
    <AuthContext.Provider value={{ isAuthenticated, loginUser, logoutUser }}>
      {children}
    </AuthContext.Provider>
  );
};

export const useAuth = () => useContext(AuthContext);
