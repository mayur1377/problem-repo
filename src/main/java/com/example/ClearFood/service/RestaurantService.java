package com.example.ClearFood.service;

import com.example.ClearFood.model.Restaurant;
import com.example.ClearFood.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    public Restaurant registerRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public Iterable<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant updateQuantity(String name, int quantity) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findByName(name);
        if (restaurantOptional.isPresent()) {
            Restaurant restaurantToUpdate = restaurantOptional.get();
            restaurantToUpdate.setFoodQuantity(quantity);
            return restaurantRepository.save(restaurantToUpdate);
        }
        return null;
    }

    public String addRating(String name, int rating, String comments) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findByName(name);
        if (restaurantOptional.isPresent()) {
            Restaurant restaurantToUpdate = restaurantOptional.get();
            List<Integer> ratings = restaurantToUpdate.getRating();
            ratings.add(rating); 
            restaurantToUpdate.setRating(ratings);
            
            if (comments != null && !comments.isEmpty()) {
                List<String> reviews = restaurantToUpdate.getReviews();
                reviews.add(comments);
                restaurantToUpdate.setReviews(reviews);
            }
    
            restaurantRepository.save(restaurantToUpdate);
            return "Rating and review added successfully";
        }
        
        return "Restaurant not found";
    }

    public Double getAverageRating(String name) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findByName(name);
        if (restaurantOptional.isPresent()) {
            Restaurant restaurant = restaurantOptional.get();
            if(restaurant.getRating().isEmpty()){
                return 0.0;
            }
            int sum = 0;
            for (int rating : restaurant.getRating()) {
                sum += rating;
            }
            return (double) sum / restaurant.getRating().size();
        }
        return null;
    }

    public List<Restaurant> showRestaurantByFilter(String filterType) {
        if ("rating".equalsIgnoreCase(filterType)) {
            return restaurantRepository.findAllOrderByRating();
        } else if ("price".equalsIgnoreCase(filterType)) {
            return restaurantRepository.findAllOrderByPrice();
        } 
        return null;
    }

    public String placeOrder(String name, int quantity) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findByName(name);
        if (restaurantOptional.isPresent()) {
            Restaurant restaurant = restaurantOptional.get();
            if (restaurant.getFoodQuantity() >= quantity) {
                restaurant.setFoodQuantity(restaurant.getFoodQuantity() - quantity);
                restaurantRepository.save(restaurant);
                return "Order placed successfully";
            }
            return "Insufficient quantity";
        }
        return "Restaurant not found";
    }
}
