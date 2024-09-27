package com.carbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carbooking.service.carservice;

@RestController
@RequestMapping("/car")
public class carcontroller {

    @Autowired
    public  carservice carService;

    @RequestMapping("/all")
    public String getAllCars() {
        return carService.getAllCars();
    }

    @RequestMapping("/available")
    public String getAvailableCars(Integer s, Integer e) {
        return carService.getAvailableCars(s, e).toString();
    }

    @RequestMapping("/book")
    public String bookCar(Integer s, Integer e) {
        return carService.bookCar(s, e).toString();
    }
}
