package com.api.carrental.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.carrental.model.CarRenter;

@Repository
public interface CarRenterRepository extends JpaRepository<CarRenter, Long> {

}
