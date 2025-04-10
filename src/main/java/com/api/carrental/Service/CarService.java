package com.api.carrental.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.carrental.Exception.InvalidIDException;
import com.api.carrental.Repository.CarRenterRepository;
import com.api.carrental.Repository.CarRepository;
import com.api.carrental.model.Car;
import com.api.carrental.model.Car.CarStatus;
import com.api.carrental.model.CarRenter;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarRenterRepository carRenterRepository;
    
    public Car assignOwnerToCar(int carId, Long ownerId) {
        Car car = carRepository.findById(carId).get();
        CarRenter owner = carRenterRepository.findById(ownerId).get();

        car.setRenter(owner);
        return carRepository.save(car);
    }


    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    public Car getCarById(int carId) throws InvalidIDException {
        Optional<Car> optional = carRepository.findById(carId);
        if (!optional.isPresent()) {
            throw new InvalidIDException("Car ID is invalid");
        }
        return optional.get();
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public List<Car> getCarsByRenterId(Long renterId) throws InvalidIDException {
        Optional<CarRenter> optional = carRenterRepository.findById(renterId);
        if (!optional.isPresent()) {
            throw new InvalidIDException("Renter ID is invalid");
        }
        return carRepository.findByRenterId(renterId);
    }

    public List<Car> getCarsByStatus(String status) {
        return carRepository.findByCarStatus(CarStatus.valueOf(status.toUpperCase()));
    }

    public Car updateCar(int carId, Car updatedCar) throws InvalidIDException {
        Car car = getCarById(carId);
        car.setModel(updatedCar.getModel());
        car.setBrand(updatedCar.getBrand());
        car.setFuelType(updatedCar.getFuelType());
        car.setMileage(updatedCar.getMileage());
        car.setPrice(updatedCar.getPrice());
        car.setYear(updatedCar.getYear());
        car.setTransmission(updatedCar.getTransmission());
        car.setCarStatus(updatedCar.getCarStatus());
        car.setWeeklyRate(updatedCar.getWeeklyRate());
        car.setMonthlyRate(updatedCar.getMonthlyRate());
        car.setSecurityDeposit(updatedCar.getSecurityDeposit());
        car.setAdditionalFees(updatedCar.getAdditionalFees());
        return carRepository.save(car);
    }

    public Car updateCarPricing(int carId, Car pricingUpdate) throws InvalidIDException {
        Car car = getCarById(carId);
        car.setWeeklyRate(pricingUpdate.getWeeklyRate());
        car.setMonthlyRate(pricingUpdate.getMonthlyRate());
        car.setSecurityDeposit(pricingUpdate.getSecurityDeposit());
        car.setAdditionalFees(pricingUpdate.getAdditionalFees());
        return carRepository.save(car);
    }
}
