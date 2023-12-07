package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.pojo.Registration;

@Repository
public interface RegisterRepo extends JpaRepository<Registration, Integer>{
	
	String query="select registration from Registration registration where registration.email=?1 and registration.password=?2";
	@Query(query)
	public Registration findByuserpwd(String username,String password);
	
	

}


