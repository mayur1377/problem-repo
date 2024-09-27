# ClearFood - Restaurant Management System

## Overview

ClearFood is a restaurant management system designed to allow users to interact with restaurants, place orders, rate restaurants, and view order history. The system supports multiple functionalities including restaurant registration, food quantity updates, restaurant ratings, and order placement.

## Functional Requirements

1. **Register Restaurant**
   - **Endpoint:** `register_restaurant(resturant_name, list of serviceable pin-codes, food item name, food item price, initial quantity)`
   - **Description:** Registers a new restaurant with its serviceable areas, food item details, and initial quantity.

2. **Update Quantity**
   - **Endpoint:** `update_quantity(restaurant name, quantity to Add)`
   - **Description:** Allows restaurant owners to increase the quantity of a food item.

3. **Rate Restaurant**
   - **Endpoint:** `rate_restaurant(restaurant name, rating, comment)`
   - **Description:** Users can rate a restaurant from 1 (Lowest) to 5 (Highest) with or without a comment. The rating of a restaurant is the average rating given by all customers.

4. **Show Restaurant**
   - **Endpoint:** `show_restaurant(rating/price)`
   - **Description:** Retrieves a list of all serviceable restaurants with food item names and prices in descending order, based on either rating or price.

5. **Place Order**
   - **Endpoint:** `place_order(restaurant name, quantity)`
   - **Description:** Places an order from a restaurant that delivers to the user's pincode and has a non-zero quantity of the food item.

6. **Order History**
   - **Endpoint:** `order_history(username)`
   - **Description:** Fetches the order history for a given user.

## Notes

- The application uses an in-memory database for data storage.
- No UI is provided; the application is operated through API calls.
- A driver class is provided to simulate all operations.

## Code Structure

- **Models**: Defines the data structure for `Restaurant` and `User`.
- **Repositories**: Interfaces for data access operations.
- **Services**: Contains business logic for handling operations.
- **Controllers**: Defines API endpoints and handles HTTP requests.
- **Driver Class**: Simulates operations and demonstrates functionality.

## Expectations

- **Code Completion:** Working executable code that meets the functional requirements.
- **Feature Coverage:** All specified features are implemented and functional.
- **Design Principles:** The application is designed with clean code principles and good design practices.

Kindly use postman for testing the applications , yet to add swagger , lemme know how i can improve this! :)
