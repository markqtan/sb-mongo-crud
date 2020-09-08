package com.markqt.sbmongocrud.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.markqt.sbmongocrud.model.Department;
import com.markqt.sbmongocrud.repo.DepartmentRepository;

@RestController
public class HelloController {

	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private MongoTemplate template;

	@GetMapping("/hi")
	public Object hi() {
		return "Hi, " + LocalDateTime.now();
	}

	@PostMapping("/dept")
	@Transactional
	public Department createDept(@RequestBody Department department) {
		System.out.println(department);
		departmentRepository.save(department);
		return department;
	}
	@Transactional
	@PutMapping("/dept/{deptId}")
	public Department updateDept(@RequestBody Department department, @PathVariable String deptId) {
		department.setId(deptId);
		departmentRepository.save(department);
//		if(true) throw new RuntimeException("test acid tx");
		return department;
	}

	@GetMapping("/depts")
	public List<Department> listDepts() {
//	    return departmentRepository.findAll();
		return template.findAll(Department.class);

	}
	
	@Transactional
	@DeleteMapping("/dept/{deptId}")
    public String deleteDept(@PathVariable String deptId) {
        departmentRepository.deleteById(deptId);
        return deptId;
    }
	
	@GetMapping("/dept/{deptName}")
    public List<Department> findDeptByName(@PathVariable String deptName) {
        return departmentRepository.findDepartmentByName(deptName);
    }

	@GetMapping("/dept/{name}/emp")
    public Department listDept(@PathVariable String name){
        return departmentRepository.findDepartmentByEmployeeName(name);
    }
}
