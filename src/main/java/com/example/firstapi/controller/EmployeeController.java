package com.example.firstapi.controller;

import com.example.firstapi.dto.EmployeeDTO;
import com.example.firstapi.mapping.EmployeeMapper;
import com.example.firstapi.model.Employee;
import com.example.firstapi.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody EmployeeDTO employeeDTO)
    {
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employeeDTO), HttpStatus.CREATED);
    }

    @GetMapping("/getall")
    public List<EmployeeDTO> getEmployees()
    {
        return employeeService.getEmployees();
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name = "id") long id)
    {
        return new ResponseEntity<EmployeeDTO>(employeeService.getEmployeeById(id),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(name = "id") long id,
                                                   @RequestBody EmployeeDTO employeeDTO)
    {
        return new ResponseEntity<Employee>(employeeService.updateEmployee(id,employeeDTO),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable(name = "id") long id)
    {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Deleting was succesfuly",HttpStatus.OK);
    }
}
