package com.example.firstapi.service;

import com.example.firstapi.dto.EmployeeDTO;
import com.example.firstapi.exception.ResourceNotFoundException;
import com.example.firstapi.mapping.EmployeeMapper;
import com.example.firstapi.model.Employee;
import com.example.firstapi.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService implements com.example.firstapi.interfaces.EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    @Override
    public Employee saveEmployee(EmployeeDTO employeeDTO) {
        return employeeRepository.save(employeeMapper.dtoToModel(employeeDTO));
    }

    @Override
    public List<EmployeeDTO> getEmployees() {
        return employeeMapper.modelsToDTOs(employeeRepository.findAll()
                .stream().filter(Employee::isActive).collect(Collectors.toList())
        );
    }

    @Override
    public EmployeeDTO getEmployeeById(long id) {
//        Optional<Employee> employee = employeeRepository.findById(id);
//        if (employee.isPresent())
//        {
//            return employee.get();
//        }
//        else {
//            throw new ResourceNotFoundException("Employee","Id",id);
//        }
        return employeeMapper.modelToDTO(employeeRepository.findById(id)
                .filter(Employee::isActive)
                .orElseThrow(()->
                        new ResourceNotFoundException("Employee","Id",id)));
        //.orElseThrow(()->
        //                new ResourceNotFoundException("Employee","Id",id))
    }

    @Override
    public Employee updateEmployee(long id, EmployeeDTO employeeDTO) {
        Employee curEmployee = employeeRepository.findById(id)
                .filter(Employee::isActive)
                .orElseThrow(()->
                        new ResourceNotFoundException("Employee","Id",id));

        employeeRepository.save(employeeMapper.dtoToModel(employeeDTO));

        return curEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        EmployeeDTO employeeDTO = employeeMapper.modelToDTO(employeeRepository.findById(id)
                .filter(Employee::isActive)
                .orElseThrow(()->
                        new ResourceNotFoundException("Employee","Id",id)));

        Employee employee = employeeRepository.findById(employeeDTO.getId()).get();
        employee.setActive(false);
//        employeeRepository.deleteById(employeeDTO.getId());
        employeeRepository.save(employee);
    }
}
