package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.Centers;
import com.example.demo.repository.CenterRepo;

@Service
public class CenterService {
	
	Logger log = Logger.getAnonymousLogger();
	
	@Autowired
	CenterRepo repo;
	
	
	public List<Centers> gettall(){
		
		return repo.findAll();
	}
	
	public Centers insert(Centers c) {
		
		return repo.save(c);
	}
	
	public void deletebyId(int id) {
		
		repo.deleteById(id);
		
	}
	
	public int countinfo() {
		
		return repo.countinfo();
		
	}
	
//	public Centers viewId(int id) {
//		
//		return repo.viewId(id);
//	}
    public Centers updateCenterById(int id, String newName, String newCity) {
        Optional<Centers> centerOptional = repo.findById(id);
        
        if (centerOptional.isPresent()) {
            Centers center = centerOptional.get();
            center.setName(newName);
            center.setCity(newCity);
            
            
           return repo.save(center);
           
        }
        
        return null;

}
    
//    public List<Centers> viewCenter(int id) {
//        return repo.viewCenters(id);
//    }
    
    public List<Centers> viewCenter(int id) {
        List<Centers> centersList = repo.viewCenters(id);
        log.info("Query executed: " + repo.query3); // Log the executed query
        log.info("Centers List size: " + centersList.size()); // Log the size of the retrieved list
        return centersList;
    }



}
