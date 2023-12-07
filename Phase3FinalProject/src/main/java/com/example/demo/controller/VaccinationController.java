package com.example.demo.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.pojo.Centers;
import com.example.demo.pojo.Citizens;
import com.example.demo.pojo.Registration;
import com.example.demo.repository.RegisterRepo;
import com.example.demo.service.CenterService;
import com.example.demo.service.CitizenService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class VaccinationController {
	
	@Autowired
	RegisterRepo repo;
	
	@Autowired
	CenterService centerservice;
	
	@Autowired
	CitizenService citizenservice;
	
	Logger log = Logger.getAnonymousLogger();
	
	@RequestMapping("/")
	public ModelAndView defaultLoader(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("login.jsp");
		
		return mv;
	}
	
	@RequestMapping("/login")
	public ModelAndView loginaction(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		String user=request.getParameter("email");
		String pwd=request.getParameter("password");
		Registration re=repo.findByuserpwd(user, pwd);
		if(re!=null) {
			mv.setViewName("vaccinationhomepage.jsp");
			 List<Centers> centersList = centerservice.gettall();
		     mv.addObject("centersList", centersList);
		     int val =  centerservice.countinfo();
		     mv.addObject("val", val);

		}
		else {
			mv.setViewName("fail.jsp");
		}
		return mv;
	}
	
	@RequestMapping("/insert")
	public ModelAndView insertrecord(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		Registration r=new Registration();
		r.setName(request.getParameter("name"));
		r.setEmail(request.getParameter("email"));
		r.setPassword(request.getParameter("password"));
		if(repo.save(r)!=null) {
			mv.setViewName("display.jsp");
		}

		return mv;
	}
	
	@RequestMapping("/centerinsert")
	public ModelAndView insertcenter(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mv = new ModelAndView();
	    Centers c = new Centers();
	    c.setName(request.getParameter("name"));
	    c.setCity(request.getParameter("city"));
	    
	     int val =  centerservice.countinfo();
	     mv.addObject("val", val);
	    if (centerservice.insert(c) != null) {
	        mv.setViewName("vaccinationhomepage.jsp");
	        
	        List<Centers> centersList = centerservice.gettall();
	        mv.addObject("centersList", centersList);
	    }
	    return mv;
	}
	
	
	@RequestMapping("/delete/{id}")
	public ModelAndView deletecenter(@PathVariable("id") int id) {
	
		
		centerservice.deletebyId(id);
		
		ModelAndView mv=new ModelAndView();

		
		 mv.setViewName("redirect:/home2");
		
		return mv;

}
	@RequestMapping("/deleteCitizen/{id}")
	public ModelAndView deleteCitizen(@PathVariable("id") int id) {
		
		citizenservice.deletebyId(id);
		
		ModelAndView mv=new ModelAndView();
		
		mv.setViewName("redirect:/home1");
		
		return mv;
		
	}
	
	 @RequestMapping("/updateCenter")
	    public ModelAndView updateCenter(
	        @RequestParam("id") int id,
	        @RequestParam("name") String newName,
	        @RequestParam("city") String newCity
	    ) {       
		 ModelAndView mv = new ModelAndView();
	        
	        Centers updatedCenter = (Centers) centerservice.updateCenterById(id, newName, newCity);
	        
	        if (updatedCenter != null) {
	            mv.setViewName("/home2");
	           
	        } 
	        
	        return mv;
	 }
	 
	 
	 @RequestMapping("/updateCitizen")
	 
	 public ModelAndView updateCitizen(  @RequestParam("id") int id,
		        @RequestParam("name") String newName,
		        @RequestParam("city") String newCity,
		        @RequestParam("doses") String newDoses,
		        @RequestParam("center") String newCenter) {
		 
		 ModelAndView mv = new ModelAndView();
		 
		 Citizens updateCitizen = (Citizens) citizenservice.updateCitizenById(id, newName, newCity, newDoses, newCenter);
		 
		 if(updateCitizen != null) {
			 
			 mv.setViewName("/home1");
		 }
		 
		 return mv;
		 
	 }
	 
	 

	
	 @RequestMapping("/home")
	 public ModelAndView home() {
		 ModelAndView mv = new ModelAndView();
		 List<Centers> centersList = centerservice.gettall();
	     mv.addObject("centersList", centersList);
	     int val =  centerservice.countinfo();
	     mv.addObject("val", val);
		 
	     mv.setViewName("vaccinationhomepage.jsp");
	     
	     return mv; 
	 }
	 
		
	 @RequestMapping("/citizeninsert")
	 public ModelAndView insertcitizen(HttpServletRequest request, HttpServletResponse response) {
	     ModelAndView mv = new ModelAndView();
	     Citizens c = new Citizens();
	     c.setName(request.getParameter("name"));
	     c.setCity(request.getParameter("city"));
	     c.setDoses(request.getParameter("doses"));
	     c.setCenter(request.getParameter("center"));
	     

	     String doses = c.getDoses();
	     if ("0".equals(doses)) {
	         c.setStatus("Not Vaccinated");
	     } else if ("1".equals(doses)) {
	         c.setStatus("Half Vaccinated");
	     } else {
	         c.setStatus("Fully Vaccinated");
	     }
	     
	     if (citizenservice.insert(c) != null) {
	         mv.setViewName("citizenshomepage.jsp");
	         
	         List<Citizens> citizenList = citizenservice.gettall();
	         mv.addObject("citizenList", citizenList);
	     }
	     
int val =  citizenservice.countinfocitizen();
	     
	     log.info("Value" + val);
	     mv.addObject("value", val);
	     return mv;
	 }

	 
	 
	 
	 @RequestMapping("/home1")
	 public ModelAndView home1() {
		 ModelAndView mv = new ModelAndView();
		 List<Citizens> citizenList = citizenservice.gettall();
	     mv.addObject("citizenList", citizenList);
	     int val =  citizenservice.countinfocitizen();
	     
	     log.info("Value" + val);
	     mv.addObject("value", val);
		 
	     mv.setViewName("citizenshomepage.jsp");
	     
	     return mv; 
	 }

	 @RequestMapping("/home2")
	 public ModelAndView home2() {
		 ModelAndView mv = new ModelAndView();
		 List<Centers> centersList = centerservice.gettall();
	     mv.addObject("centersList", centersList);
	     int val =  centerservice.countinfo();
	     mv.addObject("val", val);
		 
	     mv.setViewName("vaccinationhomepage.jsp");
	     
	     return mv; 
	 }

	 
	 @RequestMapping("/viewCenters")
	 public ModelAndView viewCenters(@RequestParam("id") int id) {
	     ModelAndView mv = new ModelAndView();
	     
	     List<Centers> centersList = centerservice.viewCenter(id);
	     mv.addObject("centersList", centersList); // Ensure centersList is added to the model
	     
	     mv.setViewName("viewcenter.jsp");
	     
	     return mv;
	 }



	 @RequestMapping("/viewCitizens")
	 public ModelAndView viewCitizens(@RequestParam("id") int id) {
	     ModelAndView mv = new ModelAndView();
	     
	     List<Citizens> citizenList = citizenservice.viewCenter(id);
	     mv.addObject("citizenList", citizenList); // Ensure centersList is added to the model
	     
	     mv.setViewName("viewcitizen.jsp");
	     
	     return mv;
	 }

	

}

