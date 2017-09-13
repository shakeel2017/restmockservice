package com.restmockservice.domain;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "DEVELOPER")
public class Developer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    private String id;

	@NotEmpty
    @Size(min = 5, max = 100)
    @Field("name")
    private String name;

    @Field("designation")
    private String designation;
    
    private Address address;
	
	private List<Skills>  listSkills;
    
    public Developer(final String id, final String name, final String designation, 
    				 final Address address, final List<Skills> listSkills) { 
	    this.id = id;
	    this.name = name;
	    this.designation = designation;
	    this.address = address;
	    this.listSkills = listSkills;
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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Skills> getListSkills() {
		return listSkills;
	}

	public void setListSkills(List<Skills> listSkills) {
		this.listSkills = listSkills;
	}
    
}



