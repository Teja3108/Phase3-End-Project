package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.Citizens;
import com.example.demo.repository.CitizenRepo;

@Service
public class CitizenService {
	
	@Autowired
	CitizenRepo repo;
	
	
	public List<Citizens> gettall(){
		
		return repo.findAll();
	}
	
	public Citizens insert(Citizens c) {
		
		return repo.save(c);
	}

	
	public int countinfocitizen() {
		
		return repo.countinfocitizen();
		
	}
	
	public void deletebyId(int id) {
		
		repo.deleteById(id);
		
	}

	public Citizens updateCitizenById(int id, String newName, String newCity, String newDoses, String newCenter) {
		
	        Optional<Citizens> citizenOptional = repo.findById(id);
	        
	        if (citizenOptional.isPresent()) {
	            Citizens citizen = citizenOptional.get();
	            citizen.setName(newName);
	            citizen.setCity(newCity);
	            citizen.setDoses(newDoses);
	            citizen.setCenter(newCenter);
	            
	           return repo.save(citizen);
	           
	        }
	        
	        return null;

	}
	
  public List<Citizens> viewCenter(int id) {
  return repo.viewCenters(id);
}

}
