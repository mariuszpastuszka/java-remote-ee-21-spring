package com.sda.javaremoteee21spring.repository;

import com.sda.javaremoteee21spring.entity.Car;
import com.sda.javaremoteee21spring.entity.Colour;
import com.sda.javaremoteee21spring.entity.Fuel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class CarRepository {

    private final List<Car> cars = new ArrayList<>();

    public CarRepository() {
        cars.addAll(createSomeCars());
    }
    private List<Car> createSomeCars() {
        return List.of(
                Car.builder()
                        .id(1L)
                        .brand("Mazda")
                        .model("6")
                        .vin("123456")
                        .colour(Colour.SOUL_RED)
                        .productionYearMonth(YearMonth.now())
                        .mileage(100)
                        .fuelType(Fuel.GASOLINE)
                        .insurance(true)
                        .build(),
                Car.builder()
                        .id(2L)
                        .brand("Mazda")
                        .model("5")
                        .vin("aBCD123")
                        .colour(Colour.BlUE)
                        .productionYearMonth(YearMonth.now())
                        .mileage(100)
                        .fuelType(Fuel.GASOLINE)
                        .insurance(false)
                        .build()
        );
    }

    public List<Car> findAll() {
        log.info("find all cars");
        return cars;
    }
}
