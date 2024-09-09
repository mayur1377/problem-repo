package com.example.ClearFood.controller;

import com.example.ClearFood.model.Restaurant;
import com.example.ClearFood.repository.RestaurantRepository;
import com.example.ClearFood.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("/register")
    public Restaurant registerRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.registerRestaurant(restaurant);
    }

    //get all restaurants
    @GetMapping("/all")
    public Iterable<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @PostMapping("/updateQuantity")
    public Restaurant updateQuantity(String name, int quantity) {
        return restaurantService.updateQuantity(name, quantity);
    }
}