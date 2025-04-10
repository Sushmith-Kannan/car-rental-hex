package com.api.carrental.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.carrental.model.CarAvailability;

@Repository
public interface CarAvailabilityRepository extends JpaRepository<CarAvailability, Long> {
    List<CarAvailability> findByCarCarId(int carId);
}
