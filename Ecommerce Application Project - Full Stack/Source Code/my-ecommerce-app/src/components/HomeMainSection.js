/*
=========================================================
Name : HomeMainSection.js
=========================================================
*/


import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import reviewsData from '../data/reviews';

function HomeMainSection() {
  const [reviews, setReviews] = useState([]);

  useEffect(() => {
    // Fetch 2 random reviews
    const randomReviews = getRandomReviews();
    setReviews(randomReviews);
  }, []);

  const getRandomReviews = () => {
    const shuffledReviews = reviewsData.sort(() => 0.5 - Math.random());
    return shuffledReviews.slice(0, 2);
  };

  return (
    <section>
      <div className="about-us">
        <h2>About Us</h2>
        <p>Company's mission and vision here.</p>
        <Link to="/products">
          <button>Shop Now</button>
        </Link>
      </div>
      <div className="customer-reviews">
        <h2>Customer Reviews</h2>
        <ul>
          {reviews.map((review, index) => (
            <li key={index}>
              <p>{review.customerName}</p>
              <p>{review.reviewContent}</p>
              <p>Rating: {Array(review.stars).fill().map((_, i) => <span key={i}>★</span>)}</p>
            </li>
          ))}
        </ul>
      </div>
    </section>
  );
}

export default HomeMainSection;
