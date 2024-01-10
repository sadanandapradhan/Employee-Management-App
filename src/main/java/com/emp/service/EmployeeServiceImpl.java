package com.emp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.dto.EmployeeDto;
import com.emp.entity.Department;
import com.emp.entity.Employee;
import com.emp.exception.ResourceNotFoundException;
import com.emp.mapper.EmployeeMapper;
import com.emp.repository.DepartmentRepository;
import com.emp.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired 
	private DepartmentRepository departmentRepository;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		
		
		Department department = departmentRepository.findById(employeeDto.getDepartmentId())
		        .orElseThrow(() -> new ResourceNotFoundException("Department does not exist with id: " + employeeDto.getDepartmentId()));
		
		employee.setDepartment(department);
		
		Employee savedEmployee = employeeRepository.save(employee);
		
		
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		// TODO Auto-generated method stub
		Employee employee =employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee is not exist with given Id:"+employeeId));
		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
		// TODO Auto-generated method stub
		
		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map((employee)->EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
		// TODO Auto-generated method stub
		
		 Employee employee =employeeRepository.findById(employeeId).orElseThrow(
				()-> new ResourceNotFoundException("Employee is not exist with given Id:"+ employeeId)
				
				);
		 employee.setFirstName(updatedEmployee.getFirstName());
		 employee.setLastName(updatedEmployee.getLastName());
		 employee.setEmail(updatedEmployee.getEmail());
		 
		 Department department = departmentRepository.findById(updatedEmployee.getDepartmentId())
			        .orElseThrow(() -> new ResourceNotFoundException("Department does not exist with id: " + updatedEmployee.getDepartmentId()));
			
			employee.setDepartment(department);
		 
		  Employee updatEmployeeObj= employeeRepository.save(employee);
		 
		return EmployeeMapper.mapToEmployeeDto(updatEmployeeObj);
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		// TODO Auto-generated method stub
		
		 Employee employee = employeeRepository.findById(employeeId).orElseThrow(
					()-> new ResourceNotFoundException("Employee is not exist with given Id:"+ employeeId)
					
					);
		 employeeRepository.deleteById(employeeId);
		
	}
 
}
