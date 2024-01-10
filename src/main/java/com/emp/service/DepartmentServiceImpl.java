package com.emp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.emp.dto.DepartmentDto;
import com.emp.entity.Department;
import com.emp.exception.ResourceNotFoundException;
import com.emp.mapper.DepartmentMapper;
import com.emp.repository.DepartmentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

	 private DepartmentRepository departmentRepository;
	 
	 // Manually added constructor
	 public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
	        this.departmentRepository = departmentRepository;
	    }

	@Override
	public DepartmentDto createDepartment(DepartmentDto departmentDto) {
		Department department = DepartmentMapper.mapToDepartment(departmentDto);
		Department savedDepartment = departmentRepository.save(department);
		return DepartmentMapper.mapToDepartmentDto(savedDepartment);
	}

	@Override
	public DepartmentDto getDepartmentById(Long departmentId) {
	Department department=departmentRepository.findById(departmentId).orElseThrow(
		   ()-> new ResourceNotFoundException("Department Is not exists with a given id:"+departmentId)
		   );
		return DepartmentMapper.mapToDepartmentDto(department);
	}

	@Override
	public List<DepartmentDto> getAllDepartments() {
		
		List<Department>departments=departmentRepository.findAll();
		return departments.stream().map((department)->DepartmentMapper.mapToDepartmentDto(department))
				.collect(Collectors.toList());
	}

	@Override
	public DepartmentDto updateDepartment(Long departmentId, DepartmentDto updaDepartment) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department is Not exists with a given Id:" + departmentId));

        // Update the existing department with the new data
        department.setDepartmentName(updaDepartment.getDepartmentName());
        department.setDepartmentDescription(updaDepartment.getDepartmentDescription());
        // Update other fields as needed

        // Save the updated department
        Department savedDepartment = departmentRepository.save(department);

        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

	@Override
	public void deleteDepartment(Long departmentId) {
		// TODO Auto-generated method stub
		
		departmentRepository.findById(departmentId).orElseThrow(
				()-> new ResourceNotFoundException("Department is not exists with a given Id:"+departmentId)
				
				);
		departmentRepository.deleteById(departmentId);
		
	}


}
