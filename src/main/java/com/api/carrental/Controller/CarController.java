package com.api.carrental.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.carrental.Exception.InvalidIDException;
import com.api.carrental.Service.CarService;
import com.api.carrental.model.Car;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping
    public Car addCar(@RequestBody Car car) {
        return carService.addCar(car);
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable int id) throws InvalidIDException {
        return carService.getCarById(id);
    }

    @GetMapping("/all")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/renter/{renterId}")
    public List<Car> getCarsByRenterId(@PathVariable Long renterId) throws InvalidIDException {
        return carService.getCarsByRenterId(renterId);
    }

    @GetMapping("/status/{status}")
    public List<Car> getCarsByStatus(@PathVariable String status) {
        return carService.getCarsByStatus(status);
    }
    
    @PutMapping("/{carId}/assign-owner/{ownerId}")
    public Car assignOwner(@PathVariable int carId, @PathVariable Long ownerId) {
        return carService.assignOwnerToCar(carId, ownerId);
    }


    @PutMapping("/{id}")
    public Car updateCar(@PathVariable int id, @RequestBody Car updatedCar) throws InvalidIDException {
        return carService.updateCar(id, updatedCar);
    }

    @PutMapping("/pricing/{id}")
    public Car updateCarPricing(@PathVariable int id, @RequestBody Car pricingUpdate) throws InvalidIDException {
        return carService.updateCarPricing(id, pricingUpdate);
    }
}
