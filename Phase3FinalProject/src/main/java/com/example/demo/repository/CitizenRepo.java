package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.pojo.Citizens;

public interface CitizenRepo extends JpaRepository<Citizens, Integer>{
	
	 
	    
	    @Query("select count(*) from Citizens")
	    public int countinfocitizen();
	    
	    String query2 = "UPDATE Citizens c SET c.name = ?2, c.city = ?3, c.doses =?4, c.center = ?5 WHERE c.id = ?1";
	    @Query(query2)
	    Citizens updateCenterById(int id, String newName, String newCity, String newDoses, String newCenter);
	    
	    
	    String query3 = "Select c from Citizens c  where c.id = ?1";
	    @Query(query3)
	    public List<Citizens> viewCenters(int id);
	 

}
