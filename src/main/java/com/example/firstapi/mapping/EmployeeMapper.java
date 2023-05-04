package com.example.firstapi.mapping;


import com.example.firstapi.dto.EmployeeDTO;
import com.example.firstapi.model.Employee;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel  ="spring", injectionStrategy =  InjectionStrategy.CONSTRUCTOR,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface EmployeeMapper {
    EmployeeMapper mapper = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDTO modelToDTO(Employee employee);

    List<EmployeeDTO> modelsToDTOs(List<Employee> employees);
    Employee dtoToModel(EmployeeDTO employeeDTO);
}