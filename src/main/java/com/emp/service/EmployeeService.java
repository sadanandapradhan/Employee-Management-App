package com.emp.service;

import java.util.List;

import com.emp.dto.EmployeeDto;

public interface EmployeeService {
	
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	
	EmployeeDto getEmployeeById(Long employeeId);
	
	List<EmployeeDto> getAllEmployee();
	
	EmployeeDto updateEmployee (Long employeeId , EmployeeDto updatedEmployee);
    
	void deleteEmployee (Long employeeId);
}
