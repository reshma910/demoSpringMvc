package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.error.studentNotFound;

@RestController
@RequestMapping("/students")
public class studentController {
	
	 @Autowired
	 studentRepo repo;
      
      @PostMapping("/post")
      public ResponseEntity<student> addPerson(@Valid student person){
          
          student newPerson = repo.save(person);       
          
          return new ResponseEntity<student>(newPerson, HttpStatus.OK) ;
      }
      
      
      @GetMapping("/get")
      @ResponseBody
      public List<student> getAllstudent(){
     	   
 			/*
 			 * List<student> s = new ArrayList<student>();
 			 * 
 			 * for(student s1: repo.findAll()) { s.add(s1); } return new
 			 * ResponseEntity<List<student>>(s,HttpStatus.OK);
 			 */
    	  
             List<student> list = new ArrayList<student>();
             list = repo.findAll();
             
             for(student s : list) {
            	System.out.print(s);
             }
     	 return repo.findAll();
    	// return "reshma";
      }
      @PutMapping("/update/{id}")
      public String getAllUpdatedData(@PathVariable Integer id,student std) throws studentNotFound{
    	  
			/*
			 * Long id1 = Long.valueOf(id); student s = repo.findById(id1).get();
			 * s.setName(std.getName()); repo.save(s);
			 */
		
		 Long id1 = Long.valueOf(id);
		 Optional<student> s = repo.findById(id1);
		 if(!s.isPresent()) {
			 throw new studentNotFound("Department Not Available");
		 }
		 
		 student s1 = s.get();
		 s1.setName(std.getName()); 
		 repo.save(s1);
			 
    	  return "data has been updated";  
      }
	  @DeleteMapping("/delete/{id}")
      public String deleteData(@PathVariable Integer id) throws studentNotFound {
		  Long id1 = Long.valueOf(id);
		  Optional<student> s = repo.findById(id1);
		  if(!s.isPresent()) {
			  throw new studentNotFound("Id is not available");
		  }

    	  repo.deleteById(id1);
		  return "data has been deleted";
      }
	  
	  @GetMapping("/getByName/{name}")
	  public List<student> getname(@PathVariable String name) {
		  return repo.findByName(name);
	  }
      
}
