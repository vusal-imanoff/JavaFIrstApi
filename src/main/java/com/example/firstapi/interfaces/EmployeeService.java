package com.example.firstapi.interfaces;

import com.example.firstapi.dto.EmployeeDTO;
import com.example.firstapi.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(EmployeeDTO employeeDTO);
    List<EmployeeDTO> getEmployees();
    EmployeeDTO getEmployeeById(long id);
    Employee updateEmployee(long id, EmployeeDTO employeeDTO);
    void deleteEmployee(long id);
}

