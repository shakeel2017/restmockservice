package com.restmockservice.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "ADDRESS")
public class Address implements Serializable {
	private static final long serialVersionUID = 9L;

	@Id
    private String id;

	@Field("street")
    private String street;
    
    @Field("city")
    private String city;
    
    @Field("zip")
    private String zip;
    
    public Address(final String id, final String street, final String city, final String zip) { 
    	    this.id = id;
    	    this.street = street;
    	    this.city = city;
    	    this.zip = zip;
    } 
    
    public Address() {}
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
    
}



