package com.restmockservice.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "SKILLS")
public class Skills implements Serializable {
	private static final long serialVersionUID = 4L;

	@Id
    private String id;

    @Field("skills")
    private String skills;
    
    public Skills(final String id, final String skills) { 
	    this.id = id;
	    this.skills = skills;
    } 
    
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



