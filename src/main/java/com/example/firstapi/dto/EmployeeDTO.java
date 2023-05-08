package com.example.firstapi.dto;

import lombok.Data;

@Data
public class EmployeeDTO {
    private long id;
    private String name;
    private String surname;
    private String email;
    private boolean active;
}
