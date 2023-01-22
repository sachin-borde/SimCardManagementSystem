package com.example.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.Customer;
import com.example.Model.SimCard;
import com.example.Service.SimCardService;


//This is a SimCard Controller Class
@RestController
public class SimCardController 
{
	@Autowired
	private SimCardService simcardservice;
	
	//Save SimCard Company
	@PostMapping("/simcardvalid")
	public ResponseEntity<SimCard>addValidSimCard(@Valid @RequestBody SimCard s)
	{
		return new ResponseEntity<SimCard>(simcardservice.saveSimCard(s),HttpStatus.CREATED);
		
	}
	
	
	//Fetch/Get SimCard Company by Id
	@GetMapping("/simcard/{id}")
	public SimCard findBySimCardId(@PathVariable int id) 
	{
		return simcardservice.findById(id);
		
	}
	
	//Fetch/Get All SimCard Company
	@GetMapping("/simcard")
	public List<SimCard>findAllSimCard()
	{
		return simcardservice.getAllSimCards();
		
	}
	
	//Delete SimCard Company
	@DeleteMapping("/simcard/{id}")
	public String deleteSimCard(@PathVariable int id) 
	{
		simcardservice.deleteSimCard(id);
		return "SimCard Company is Deleted" ;
		
	}
	
	//Update SimCard Company
	@PutMapping("/simcard")
	public SimCard updateSimCard(@RequestBody SimCard simcard) 
	{
		return simcardservice.updateSimCard(simcard);
		
	}
	
	//This is Customize Method
	//Get SimCard Company by name
	@GetMapping("/simcard/Name/{name}")
	public List<SimCard> findByName(@PathVariable String name) 
	{
		return simcardservice.findByName(name);
		
	}
	

}
