package com.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.dto.DepartmentDto;
import com.emp.service.DepartmentService;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	// Build Add Department REST API
	
	@PostMapping
	public ResponseEntity<DepartmentDto> createDepartment(@RequestBody  DepartmentDto departmentDto){
		DepartmentDto department = departmentService.createDepartment(departmentDto);
		return new ResponseEntity<>(department , HttpStatus.CREATED);
		
	}
	
	// Build Get Department  REST API
	
	@GetMapping("{departmentId}")
	public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable  Long departmentId){
		DepartmentDto departmentDto=departmentService.getDepartmentById(departmentId);
		return ResponseEntity.ok(departmentDto);
	}
	
	// Build Get All Department REST API
	
	@GetMapping
	public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
	    List<DepartmentDto> departments = departmentService.getAllDepartments();
		return ResponseEntity.ok(departments);
	}
	
	// Build Update Department REST API
	
	@PutMapping("{id}")
	public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id")   Long departmentId ,@RequestBody DepartmentDto updateDepartment){
		DepartmentDto departmentDto= departmentService.updateDepartment(departmentId, updateDepartment);
		return ResponseEntity.ok(departmentDto);
	}
 // Build delete Department REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long departmentId){
		departmentService.deleteDepartment(departmentId);
		return ResponseEntity.ok("Department delted sucessfully!");
	}
}
