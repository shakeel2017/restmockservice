package com.restmockservice.domain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "SKILLS")
public class Skills implements Serializable {
	private static final long serialVersionUID = 4L;

    @Field("skills")
    private String skills;
    
    public Skills(final String skills) { 
	    this.skills = skills;
    } 

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}
 
}



