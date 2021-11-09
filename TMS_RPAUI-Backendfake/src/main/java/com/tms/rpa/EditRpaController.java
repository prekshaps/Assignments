package com.tms.rpa;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.json.XML;
@RestController
@CrossOrigin("*")
public class EditRpaController {
	ObjectMapper mapper=new ObjectMapper();

	@PostMapping("/geteditrpa")
	public String postEditRpawithvalue(@RequestBody String posteditrpa) throws IOException 
	{
		
String jsondata=FileUtils.readFileToString(new File("target/editRpa.json"),"UTF-8");
		
		
	return jsondata;
		
		
	}
	
	@PostMapping("/editrpa")
	public String postEditRpa(@RequestBody String editrpa) 
	{
		
		System.out.println(editrpa);
		try {
			//JSONObject json = new JSONObject(editrpa);
			//System.out.println(json);
			JsonNode actualObj = mapper.readTree(editrpa);
			mapper.writeValue(new File("D:\\TMS-backend-fake\\rpa\\target/editrpa.json"), actualObj);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return editrpa;
	}
	
}
