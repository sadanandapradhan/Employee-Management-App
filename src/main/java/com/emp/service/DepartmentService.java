package com.emp.service;

import java.util.List;

import com.emp.dto.DepartmentDto;

public interface DepartmentService {
	
	DepartmentDto createDepartment (DepartmentDto departmentDto);
	
	DepartmentDto getDepartmentById(Long departmentId);
	
	List<DepartmentDto> getAllDepartments();
	
	DepartmentDto updateDepartment(Long departmentId, DepartmentDto updaDepartment);
	
	void deleteDepartment(Long departmentId);


}