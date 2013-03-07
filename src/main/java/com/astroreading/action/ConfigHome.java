package com.astroreading.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.astroreading.model.Country;
import com.astroreading.service.ConfigService;

@Namespace(value = "/config")
public class ConfigHome extends JsonBaseHome{

	private List<Country> countries;
	
	@Autowired
	private ConfigService configService;
	@Action(value="countries",results = {
		    @Result(name="success", type="json")
		})
		public String countries() {
			countries = configService.getCountries();
			return SUCCESS;
		}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
	
	
	
}
