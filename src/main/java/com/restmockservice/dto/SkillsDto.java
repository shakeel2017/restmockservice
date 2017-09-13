package com.restmockservice.dto;

import java.io.Serializable;

public class SkillsDto implements Serializable {
	private static final long serialVersionUID = 14L;

    private String id;

    private String skills;
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}
 
}



