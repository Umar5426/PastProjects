/*
=========================================================
Name : ProductItem.js
=========================================================
*/

import React, { useState } from 'react';
import './Products.css';

const ProductItem = ({ product, onAddToCart }) => {
    const [showDescription, setShowDescription] = useState(false);

    return (
        <div className="product-item">
            <img src={product.image} alt={product.name} />
            <div onMouseEnter={() => setShowDescription(true)} onMouseLeave={() => setShowDescription(false)}>
                {product.name}
            </div>
            {showDescription && <div>{product.description}</div>}
            <div>${product.price.toFixed(2)}</div>
            <button onClick={() => onAddToCart(product)}>Add to Cart</button>
        </div>
    );
};

export default ProductItem;