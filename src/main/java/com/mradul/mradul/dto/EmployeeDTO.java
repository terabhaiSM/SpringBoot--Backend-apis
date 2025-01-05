package com.mradul.mradul.dto;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private UUID id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String department;
    private String position;
    private String salary;
    @JsonProperty("isActive")
    private Boolean isActive;
}
