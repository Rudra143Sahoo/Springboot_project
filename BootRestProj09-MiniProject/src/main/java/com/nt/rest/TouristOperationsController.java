package com.nt.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Tourist;
import com.nt.service.ITouristMgmtService;


@RestController
@RequestMapping("/tourist-api")
public class TouristOperationsController {
	@Autowired
	private ITouristMgmtService  touristService;
	
	@PostMapping("/save")
	public  ResponseEntity<String>  saveTourist(@RequestBody Tourist tourist){
		
		try {
			//use service
			String msg=touristService.registerTourist(tourist);
			return  new  ResponseEntity<String>(msg,HttpStatus.CREATED);
		}
		catch(Exception e) {
			return  new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	   @GetMapping("/all")
	   public  ResponseEntity<?>   displayAllTourists(){
		   try {
			   //use service
			   List<Tourist> list=touristService.showAllTourists();
			   return new ResponseEntity<List<Tourist>>(list,HttpStatus.OK);
		   }
		   catch(Exception e) {
			   return new  ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		   }
	   }
	   
	   @GetMapping("/find/{id}")
	   public   ResponseEntity<?>  findTouristById(@PathVariable("id") Integer id){
		 try {
			 //use service
			  Tourist  tourist=touristService.showTouristById(id);
			  return  new ResponseEntity<Tourist>(tourist,HttpStatus.OK);
		 }
		 catch(Exception e) {
			  return new  ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		 }
	   }
	   
	   @PutMapping("/update")
	   public   ResponseEntity<String>   updateTourist(@RequestBody  Tourist tourist ){
		   try {
			   //use service
			   String msg=touristService.updateTourist(tourist);
			   return new ResponseEntity<String>(msg,HttpStatus.OK);
		   }
		   catch(Exception  e) {
			   return  new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		   }
		   
	   }
	   
	   @PatchMapping("/update/{id}/{hikePercentage}")
	   public   ResponseEntity<String>   updateTouristBuget(@PathVariable("id") int id,
			                                                                                                  @PathVariable("hikePercentage") double percentage){
		   try {
			   //use service
			   String msg=touristService.updateTouristBudget(id, percentage);
			   return new ResponseEntity<String>(msg,HttpStatus.OK);
		   }
		   catch(Exception  e) {
			   return  new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		   }
		   
		   
	   }
	   
	   
	   @DeleteMapping("/delete/{id}")
	   public   ResponseEntity<String>   deleteTouristById(@PathVariable("id") int id ){
		   try {
			   //use service
			   String msg=touristService.deleteTouristById(id);
			   return new ResponseEntity<String>(msg,HttpStatus.OK);
		   }
		   catch(Exception  e) {
			   return  new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		   }
		   
	   }
	   

}
