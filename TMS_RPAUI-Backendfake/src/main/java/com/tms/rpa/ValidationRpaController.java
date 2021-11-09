package com.tms.rpa;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin("*")
public class ValidationRpaController {
	ObjectMapper mapper=new ObjectMapper();

	@PostMapping("/getvalidationRpa")
	public String postValidationRpawithvalue(@RequestBody String posteditrpa) throws IOException 
	{
		
String jsondata=FileUtils.readFileToString(new File("target/validationrpa.json"),"UTF-8");
		
		
	return jsondata;
		
		
	}
	
	@PostMapping("/postvalidationRpa")
	public String postValidationRpa(@RequestBody String validationrpa) 
	{
		
		System.out.println(validationrpa);
		try {
			//JSONObject json = new JSONObject(editrpa);
			//System.out.println(json);
			JsonNode actualObj = mapper.readTree(validationrpa);
			mapper.writeValue(new File("target/validationrpa.json"), actualObj);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return validationrpa;
	}
}
