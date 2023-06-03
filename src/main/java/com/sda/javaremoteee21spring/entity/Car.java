package com.sda.javaremoteee21spring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.YearMonth;

@Entity
@Table(name = "CARS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder // builder don't need no-args constructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String brand;

    String model;

    String vin;

    @Enumerated(EnumType.STRING)
    Colour colour;

    YearMonth productionYearMonth;

    int mileage;

    @Enumerated(EnumType.STRING)
    Fuel fuelType;

    boolean insurance;
}
