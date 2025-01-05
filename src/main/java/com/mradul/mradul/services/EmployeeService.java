package com.mradul.mradul.services;

import com.mradul.mradul.dto.EmployeeDTO;
import com.mradul.mradul.entities.EmployeeEntity;
import com.mradul.mradul.repositories.EmployeeRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

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
        Stream<EmployeeEntity> employeeStream = employeeEntities.stream();
        System.out.println(employeeStream);
        return employeeStream.map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class)).toList();
    }

    public String deleteEmployeeById(UUID id) {
        try {
            employeeRepository.deleteById(id);
            return "Employee deleted successfully";
        } catch (Exception e) {
            return "Employee not found";
        }
    }

    public EmployeeDTO updateEmployeeById(UUID id, EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Employee not found"));
        
        if (employeeDTO.getName() != null) employeeEntity.setName(employeeDTO.getName());
        if (employeeDTO.getEmail() != null) employeeEntity.setEmail(employeeDTO.getEmail());
        if (employeeDTO.getPhone() != null) employeeEntity.setPhone(employeeDTO.getPhone());
        if (employeeDTO.getAddress() != null) employeeEntity.setAddress(employeeDTO.getAddress());
        if (employeeDTO.getDepartment() != null) employeeEntity.setDepartment(employeeDTO.getDepartment());
        if (employeeDTO.getPosition() != null) employeeEntity.setPosition(employeeDTO.getPosition());
        if (employeeDTO.getSalary() != null) employeeEntity.setSalary(employeeDTO.getSalary());
        if (employeeDTO.getIsActive() != null) employeeEntity.setIsActive(employeeDTO.getIsActive());
        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }

    public EmployeeDTO createEmployee (EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        EmployeeEntity savedEntity = employeeRepository.save(employeeEntity);
        System.out.println(savedEntity);
        return modelMapper.map(savedEntity, EmployeeDTO.class);
    }
}
