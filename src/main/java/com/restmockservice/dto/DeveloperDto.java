package com.restmockservice.dto;

import java.io.Serializable;
import java.util.List;

public class DeveloperDto implements Serializable {
	private static final long serialVersionUID = 10L;
	
    private String id;

    private String name;

    private String designation;

	private AddressDto addressDto;
	
	private List<SkillsDto>  lskillsDto;
    
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
	
    public AddressDto getAddressDto() {
		return addressDto;
	}

	public void setAddressDto(AddressDto addressDto) {
		this.addressDto = addressDto;
	}
	
    public List<SkillsDto> getLskillsDto() {
		return lskillsDto;
	}

	public void setLskillsDto(List<SkillsDto> lskillsDto) {
		this.lskillsDto = lskillsDto;
	}

}



