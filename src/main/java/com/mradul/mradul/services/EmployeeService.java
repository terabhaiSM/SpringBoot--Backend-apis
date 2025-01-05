package com.mradul.mradul.services;

import com.mradul.mradul.dto.EmployeeDTO;
import com.mradul.mradul.entities.EmployeeEntity;
import com.mradul.mradul.repositories.EmployeeRepository;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    final EmployeeRepository employeeRepository;
    final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmployeeById(UUID id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Employee not found"));
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeEntities.
    }

    public EmployeeDTO createEmployee (EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        EmployeeEntity savedEntity = employeeRepository.save(employeeEntity);
        System.out.println(savedEntity);
        return modelMapper.map(savedEntity, EmployeeDTO.class);
    }
}
