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
}
