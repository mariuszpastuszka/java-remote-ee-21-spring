package com.sda.javaremoteee21spring.entity;

import org.junit.jupiter.api.Test;

import java.time.YearMonth;

class CarTest {

    @Test
    public void createCarWithConstructor() {
        Car mazda = new Car(1L, "Mazda", "6", "123445", Colour.SOUL_RED, YearMonth.now(),
                100, Fuel.GASOLINE, true);
    }

    @Test
    public void createCarWithBuilder() {
        Car mazda = Car.builder()
                .id(1L)
                .brand("Mazda")
                .model("6")
                .vin("123456")
                .colour(Colour.SOUL_RED)
                .productionYearMonth(YearMonth.now())
                .mileage(100)
                .fuelType(Fuel.GASOLINE)
                .insurance(true)
                .build();
    }

    @Test
    public void createCarWithNoArgConstructor() {
        Car mazda = new Car();
        mazda.setId(1L);
        mazda.setBrand("Mazda");
    }
}