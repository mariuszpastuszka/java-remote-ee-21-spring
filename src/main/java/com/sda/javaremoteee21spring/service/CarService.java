package com.sda.javaremoteee21spring.service;

import com.sda.javaremoteee21spring.entity.Car;
import com.sda.javaremoteee21spring.repository.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> findAllCars() {
        List<Car> carsFromRepository = carRepository.findAll();
        log.info("we've got [{}] cars", carsFromRepository.size());
        log.debug("cars: " + carsFromRepository);
        return carsFromRepository;
    }
}
