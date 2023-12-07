package com.example.demo.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.pojo.Centers;

public interface CenterRepo extends JpaRepository<Centers, Integer> {
    
    String query = "select count(*) from Centers";
    
    @Query(query)
    public int countinfo();
    
    //String query1 = "SELECT * FROM Centers WHERE id = ?1 ";
    
  
    String query2 = "UPDATE Centers c SET c.name = ?2, c.city = ?3 WHERE c.id = ?1";
    @Query(query2)
    Centers updateCenterById(int id, String newName, String newCity);
    
    String query3 = "Select c from Centers c  where c.id = ?1";
    @Query(query3)
    public List<Centers> viewCenters(int id);
 
}

