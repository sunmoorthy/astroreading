package com.astroreading.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.astroreading.model.Country;
import com.astroreading.model.State;

@Service
public class ConfigService {

	@Autowired
	MongoTemplate mongoTemplate;
	
	
	
	/**
	 * Get all the countries from DB
	 * Need to add Caching mechanism
	 * @return
	 */
	public List<Country> getCountries() {
		List<Country> countries = mongoTemplate.find(new Query().with(new Sort(Direction.ASC, "name")), Country.class);
		return countries;
	}
	
	public List<State> getStates(String countryCode) {
		List<State> states = mongoTemplate.find(new Query(new Criteria("countryCode").is(countryCode)).with(new Sort(Direction.ASC, "name")), State.class);
		return states;
	}
	
}
