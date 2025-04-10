package com.api.carrental.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.carrental.Exception.InvalidIDException;
import com.api.carrental.Service.CarAvailabilityService;
import com.api.carrental.model.CarAvailability;

@RestController
@RequestMapping("/api/availability")
public class CarAvailabilityController {

    @Autowired
    private CarAvailabilityService availabilityService;

    @PostMapping("/add/{carId}")
    public CarAvailability addAvailability(@RequestBody CarAvailability availability,
                                           @PathVariable int carId) throws InvalidIDException {
        return availabilityService.addAvailability(availability, carId);
    }

    @GetMapping("/car/{carId}")
    public List<CarAvailability> getAvailabilityByCar(@PathVariable int carId) {
        return availabilityService.getAvailabilityByCarId(carId);
    }

    @GetMapping("/all")
    public List<CarAvailability> getAllAvailabilities() {
        return availabilityService.getAllAvailabilities();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAvailability(@PathVariable Long id) {
        availabilityService.deleteAvailability(id);
        return "Availability deleted successfully.";
    }
}
