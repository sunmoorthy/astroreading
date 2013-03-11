package com.astroreading.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class State {

	
	private String code;
	private String name;
	private String countryCode;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	
	
}

