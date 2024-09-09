package com.example.ClearFood.repository;

import com.example.ClearFood.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Optional<Restaurant> findByName(String x);

    @Query("SELECT r FROM Restaurant r ORDER BY r.rating DESC")
    List<Restaurant> findAllOrderByRating();

    @Query("SELECT r FROM Restaurant r ORDER BY r.foodPrice DESC")
    List<Restaurant> findAllOrderByPrice();
}