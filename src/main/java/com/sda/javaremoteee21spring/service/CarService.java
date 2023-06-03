package com.sda.javaremoteee21spring.service;

import com.sda.javaremoteee21spring.entity.Car;
import com.sda.javaremoteee21spring.entity.Colour;
import com.sda.javaremoteee21spring.entity.Fuel;
import com.sda.javaremoteee21spring.exception.CarNotFoundException;
import com.sda.javaremoteee21spring.repository.CarRepository;
import com.sda.javaremoteee21spring.repository.SpringCarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class CarService {

    private final CarRepository carRepository;

    private final SpringCarRepository springCarRepository;

    public CarService(CarRepository carRepository, SpringCarRepository springCarRepository) {
        this.carRepository = carRepository;
        this.springCarRepository = springCarRepository;
    }

    public List<Car> findAllCars() {
//        List<Car> carsFromRepository = carRepository.findAll();
        var carsFromRepository = (List<Car>) springCarRepository.findAll();
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

    public Car replaceCarById(Car carToReplace, Long carId) {
        log.info("Replacing car by id: [{}] with content: [{}]", carId, carToReplace);
        return Optional.ofNullable(carRepository.replaceById(carId, carToReplace))
                .orElseThrow(() -> new CarNotFoundException("No car with id: " + carId));
    }

    public Car updateCar(Long id, Car carToUpdate) {
        log.info("Updating car with id: [{}] with content provided by user [{}]", id, carToUpdate);
        // get car by id from repository
        Car carFromRepository = Optional.ofNullable(carRepository.findById(id))
                .orElseThrow(() -> new CarNotFoundException("No car with id: " + id));

        // apply necessary changes
        String brandToUpdate = carToUpdate.getBrand();
        if (!Objects.equals(brandToUpdate, carFromRepository.getBrand())) {
            carFromRepository.setBrand(brandToUpdate);
        }

        String model = carToUpdate.getModel();
        if (!Objects.equals(model, carFromRepository.getModel())) {
            carFromRepository.setModel(model);
        }

        String vin = carToUpdate.getVin();
        if (!Objects.equals(vin, carFromRepository.getVin())) {
            carFromRepository.setVin(vin);
        }

        Colour color = carToUpdate.getColour();
        if (!Objects.equals(color, carFromRepository.getColour())) {
            carFromRepository.setColour(color);
        }

        YearMonth yearMonth = carToUpdate.getProductionYearMonth();
        if (!Objects.equals(yearMonth, carFromRepository.getProductionYearMonth())) {
            carFromRepository.setProductionYearMonth(yearMonth);
        }

        int mileage = carToUpdate.getMileage();
        if (mileage != carFromRepository.getMileage()) {
            carFromRepository.setMileage(mileage);
        }

        Fuel fuel = carToUpdate.getFuelType();
        if (!Objects.equals(fuel, carFromRepository.getFuelType())) {
            carFromRepository.setFuelType(fuel);
        }

        boolean insurance = carToUpdate.isInsurance();
        if (insurance != carFromRepository.isInsurance()) {
            carFromRepository.setInsurance(insurance);
        }

        // store updated car
        return carRepository.replaceById(id, carFromRepository);
    }
}
