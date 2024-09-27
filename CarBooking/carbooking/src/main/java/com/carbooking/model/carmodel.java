package com.carbooking.model;

import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

public class carmodel {
    public String carName;
    public String carNumber;
    public List<Pair<Integer, Integer>> carAvailability;

    public carmodel(String carName, String carNumber, List<Pair<Integer, Integer>> carAvailability) {
        this.carName = carName;
        this.carNumber = carNumber;
        this.carAvailability = carAvailability;
    }

    public String getCarName() {
        return carName;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public List<Pair<Integer, Integer>> getCarAvailability() {
        return carAvailability;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public void setCarAvailability(List<Pair<Integer, Integer>> carAvailability) {
        this.carAvailability = carAvailability;
    }


}
