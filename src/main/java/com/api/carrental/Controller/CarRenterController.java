package com.api.carrental.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.carrental.Service.CarRenterService;
import com.api.carrental.model.CarRenter;

@RestController
@RequestMapping("/api/renter")
public class CarRenterController {

    @Autowired
    private CarRenterService carRenterService;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from Spring Boot - Renter Module!";
    }

    @PostMapping("/add")
    public CarRenter addRenter(@RequestBody CarRenter renter) {
        return carRenterService.addRenter(renter);
    }

    @GetMapping("/all")
    public List<CarRenter> getAllRenters() {
        return carRenterService.getAllRenters();
    }

    @GetMapping("/{id}")
    public CarRenter getRenterById(@PathVariable Long id) {
        return carRenterService.getRenterById(id);
    }

    @PutMapping("/update/{id}")
    public CarRenter updateRenter(@PathVariable Long id, @RequestBody CarRenter renter) {
        return carRenterService.updateRenter(id, renter);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteRenter(@PathVariable Long id) {
        carRenterService.deleteRenterById(id);
        return "Renter deleted successfully";
    }
}
