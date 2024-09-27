package com.carbooking.service;

import java.util.*;

import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;

import com.carbooking.model.carmodel;

@Service
public class carservice {

    public List<carmodel> carsList = new ArrayList<>();

    public carservice() {
        carsList.add(new carmodel("Toyota", "TN 01 2345", Arrays.asList(Pair.of(10, 12), Pair.of(14, 16))));
        carsList.add(new carmodel("Honda", "TN 01 2346", Arrays.asList(Pair.of(2 , 4), Pair.of(6, 8))));
        carsList.add(new carmodel("Hyundai", "TN 01 2347", Arrays.asList(Pair.of(14, 16), Pair.of(18, 20))));
    }

    public String getAllCars() {
        String allCars = "";
        for (carmodel car : carsList) {
            allCars += car.getCarName() + " " + car.getCarNumber() + "\n";
        }
        return allCars;
    }


    public carmodel addCar(carmodel carModel) {
        carsList.add(carModel);
        return carModel;
    }

    public carmodel updateCar(String carNumber, carmodel updatedCar) {
        for (int i = 0; i < carsList.size(); i++) {
            if (carsList.get(i).getCarNumber().equals(carNumber)) {
                carsList.set(i, updatedCar);
                return updatedCar;
            }
        }
        return null;
    }

    public String getAvailableCars(Integer s , Integer e)
    {
        List<carmodel> availableCars = new ArrayList<>();
        for (carmodel car : carsList) {
            List<Pair<Integer, Integer>> carAvailability = car.getCarAvailability();
            for (Pair<Integer, Integer> slot : carAvailability) {
                if (slot.getLeft() <= s && slot.getRight() >= e) {
                    availableCars.add(car);
                    break;
                }
            }
        }
        String availableCarsString = "";
        for (carmodel car : availableCars) {
            availableCarsString += car.getCarName() + " " + car.getCarNumber() + "\n";
            System.out.println(car.getCarName() + " " + car.getCarNumber());
        }
        return availableCarsString;
    }

    public carmodel bookCar(Integer s , Integer e)
    {
        carmodel bookedCar = null;
        int maxWaitingTime = Integer.MAX_VALUE;
        for (carmodel car : carsList) {
            List<Pair<Integer, Integer>> carAvailability = car.getCarAvailability();
            for (Pair<Integer, Integer> slot : carAvailability) {
                if (slot.getLeft() <= s && slot.getRight() >= e) {
                    Integer waitingTime = (s-slot.getLeft()) + (slot.getRight()-e);
                    if(waitingTime < maxWaitingTime)
                    {
                        maxWaitingTime = waitingTime;
                        bookedCar = car;
                    }
                }
            }
        }
        return bookedCar;
    }
}