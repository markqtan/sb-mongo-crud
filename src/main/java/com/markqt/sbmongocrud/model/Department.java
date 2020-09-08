package com.markqt.sbmongocrud.model;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Department")
public class Department {

    @Id
    private String id;

    @Indexed(name = "deptName")
    private String name;
    private String description;

    //@DBRef
    private List<Employee> employees;

    
    @Override
    public String toString( ) {
    	return ToStringBuilder.reflectionToString(this);
    }
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
 
    
    
    
}