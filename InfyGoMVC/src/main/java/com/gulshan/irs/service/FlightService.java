package com.gulshan.irs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gulshan.irs.DAO.FlightDAO;
@Service
public class FlightService {
	@Autowired
	FlightDAO flightDAO = null;

	public List<String> getSources() {
System.out.println("Inside flight service");
		List<String> flightSources=flightDAO.getSource();
		return flightSources;
	}
	public List<String> getDestination() {

		List<String> flightSources=flightDAO.getDestination();
		return flightSources;
	}
}
