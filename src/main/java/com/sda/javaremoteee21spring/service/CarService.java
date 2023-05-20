package com.sda.javaremoteee21spring.service;

import com.sda.javaremoteee21spring.entity.Car;
import com.sda.javaremoteee21spring.exception.CarNotFoundException;
import com.sda.javaremoteee21spring.repository.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> findAllCars() {
//        List<Car> carsFromRepository = carRepository.findAll();
        var carsFromRepository = carRepository.findAll();
        log.info("we've got [{}] cars", carsFromRepository.size());
        log.debug("cars: " + carsFromRepository);
        return carsFromRepository;
    }

//    public Car findCarById(Long id) {
//        log.info("trying to find car with id: [{}]", id);
//        Car carFromRepository = carRepository.findById(id);
//        log.info("car from repository: [{}]", carFromRepository);
//        return carFromRepository;
//    }

    // better approach with exceptions
    public Car findCarById(Long id) {
        log.info("trying to find car with id: [{}]", id);
        Car carFromRepository = carRepository.findById(id);
        log.info("car from repository: [{}]", carFromRepository);
        Optional<Car> maybeCar = Optional.ofNullable(carFromRepository);
        return maybeCar.orElseThrow(() -> new CarNotFoundException("No car with id: " + id));
    }

    public Car saveCar(Car carToSave) {
        log.info("Saving object: [{}]", carToSave);
        Car savedCar = carRepository.save(carToSave);
        log.info("Car with assigned id: [{}]", savedCar);
        return savedCar;
    }

    public void deleteCarById(Long id) {
        log.info("Deleting item with id: [{}]", id);
        if (carRepository.existById(id)) {
            carRepository.deleteById(id);
        } else {
            throw new CarNotFoundException("No car with id: " + id);
        }
    }
}
