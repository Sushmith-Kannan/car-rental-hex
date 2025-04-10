package com.api.carrental.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.carrental.model.Car;
import com.api.carrental.model.Car.CarStatus;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findByRenterId(Long renterId);
    List<Car> findByCarStatus(CarStatus carStatus);
}
