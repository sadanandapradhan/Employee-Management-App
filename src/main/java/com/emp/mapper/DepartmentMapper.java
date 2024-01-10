package com.emp.mapper;

import com.emp.dto.DepartmentDto;
import com.emp.entity.Department;

public class DepartmentMapper {
	
	// Convert Department JPA entity into department dto
	
	public static DepartmentDto mapToDepartmentDto(Department department) {
		return  new DepartmentDto(
				department.getId(),
				department.getDepartmentName(),
				department.getDepartmentDescription()
				
				
				);
		
	}
	
	// Conevrt department dto into Department jpa entity
	
	public static Department mapToDepartment(DepartmentDto departmentDto) {
		return new Department(
				departmentDto.getId(),
				departmentDto.getDepartmentName(),
				departmentDto.getDepartmentDescription()
				
				);
		
	}

}
