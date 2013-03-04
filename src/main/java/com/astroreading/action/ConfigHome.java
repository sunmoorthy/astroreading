package com.astroreading.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.astroreading.model.Country;

@Namespace(value = "/config")
public class ConfigHome extends JsonBaseHome{

	private List<Country> countries;
	
	@Action(value="countries",results = {
		    @Result(name="success", type="json")
		})
		public String countries() {
			countries = new ArrayList<Country>();
			Country country = new Country();
			country.setCode("IND");
			country.setName("India");
			countries.add(country);
			country = new Country();
			country.setCode("USA");
			country.setName("United States of America");
			countries.add(country);
			return SUCCESS;
		}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
	
	
	
}
