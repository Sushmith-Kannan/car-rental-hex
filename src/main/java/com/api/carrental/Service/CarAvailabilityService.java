package com.api.carrental.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.carrental.Exception.InvalidIDException;
import com.api.carrental.Repository.CarAvailabilityRepository;
import com.api.carrental.Repository.CarRepository;
import com.api.carrental.model.Car;
import com.api.carrental.model.CarAvailability;

@Service
public class CarAvailabilityService {

    @Autowired
    private CarAvailabilityRepository carAvailabilityRepository;

    @Autowired
    private CarRepository carRepository;

    public CarAvailability addAvailability(CarAvailability availability, int carId) throws InvalidIDException {
        Optional<Car> optional = carRepository.findById(carId);
        if (optional.isEmpty())
            throw new InvalidIDException("Invalid Car ID");

        availability.setCar(optional.get());
        return carAvailabilityRepository.save(availability);
    }

    public List<CarAvailability> getAvailabilityByCarId(int carId) {
        return carAvailabilityRepository.findByCarCarId(carId);
    }

    public List<CarAvailability> getAllAvailabilities() {
        return carAvailabilityRepository.findAll();
    }

    public void deleteAvailability(Long availabilityId) {
        carAvailabilityRepository.deleteById(availabilityId);
    }
}
