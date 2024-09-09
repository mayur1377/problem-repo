package com.example.ClearFood.controller;

import com.example.ClearFood.model.Restaurant;
import com.example.ClearFood.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    public enum FilterType {
        RATING, PRICE
    }

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

    @PostMapping("/addRating")
    public String addRating(@RequestParam String name, 
                                @RequestParam int rating, 
                                @RequestParam(required = false) String comments) {
        return restaurantService.addRating(name, rating, comments);
    }

    @GetMapping("/getAverageRating")
    public Double getAverageRating(String name) {
        return restaurantService.getAverageRating(name);
    }

    @GetMapping("/showRestaurant")
    public List<Restaurant> showRestaurant(String filterType){
        return restaurantService.showRestaurantByFilter(filterType);
    }

    @PostMapping("/placeOrder") 
    public String placeOrder(String name, int quantity) {
        return restaurantService.placeOrder(name, quantity);
    }
}