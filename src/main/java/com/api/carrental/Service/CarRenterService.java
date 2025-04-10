package com.api.carrental.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.carrental.Repository.CarRenterRepository;
import com.api.carrental.model.CarRenter;

@Service
public class CarRenterService {

    @Autowired
    private CarRenterRepository carRenterRepository;

    public CarRenter addRenter(CarRenter renter) {
        return carRenterRepository.save(renter);
    }

    public List<CarRenter> getAllRenters() {
        return carRenterRepository.findAll();
    }

    public CarRenter getRenterById(Long id) {
        return carRenterRepository.findById(id).orElse(null);
    }

    public void deleteRenterById(Long id) {
        carRenterRepository.deleteById(id);
    }

    public CarRenter updateRenter(Long id, CarRenter updatedRenter) {
        updatedRenter.setId(id);
        return carRenterRepository.save(updatedRenter);
    }
}
