package com.sda.javaremoteee21spring.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.YearMonth;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder // builder don't need no-args constructor
public class Car {
    Long id;
    String brand;
    String model;
    String vin;
    Colour colour;
    YearMonth productionYearMonth;
    int mileage;
    Fuel fuelType;
    boolean insurance;
}
