package com.mradul.mradul.repositories;

import com.mradul.mradul.entities.EmployeeEntity;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, UUID> {
}
