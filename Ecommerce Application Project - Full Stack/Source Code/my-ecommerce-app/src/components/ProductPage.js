/*
=========================================================
Name : ProductPage.js
=========================================================
*/

import React, { useState, useEffect } from 'react';
import Header from './Header';
import ProductList from './ProductList';
import Cart from './Cart';
import Footer from './Footer';
import './Products.css';

const Productpage = () => {
    const [cartItems, setCartItems] = useState(JSON.parse(localStorage.getItem('cart')) || []);

    useEffect(() => {
        localStorage.setItem('cart', JSON.stringify(cartItems));
    }, [cartItems]);

    const addToCart = (product) => {
        const exist = cartItems.find((item) => item.id === product.id);
        if (exist) {
            setCartItems(
                cartItems.map((item) =>
                    item.id === product.id ? { ...exist, quantity: exist.quantity + 1 } : item
                )
            );
        } else {
            setCartItems([...cartItems, { ...product, quantity: 1 }]);
        }
    };

    const removeFromCart = (product, removeAll = false) => {
        const exist = cartItems.find((item) => item.id === product.id);
        if (exist.quantity === 1 || removeAll) {
            setCartItems(cartItems.filter((item) => item.id !== product.id));
        } else {
            setCartItems(
                cartItems.map((item) =>
                    item.id === product.id ? { ...exist, quantity: exist.quantity - 1 } : item
                )
            );
        }
    };

    return (
        <div className="main-container">
            <Header />
            <div className="content-container">
                <ProductList onAddToCart={addToCart} />
                <Cart cartItems={cartItems} onAddToCart={addToCart} onRemoveFromCart={removeFromCart} />
            </div>
            <Footer />
        </div>
    );
};

export default Productpage;
