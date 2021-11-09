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
public class RejectRpaController {
	ObjectMapper mapper=new ObjectMapper();

	@PostMapping("/getrejectRpa")
	public String postRejectRpawithvalue(@RequestBody String posteditrpa) throws IOException 
	{
		
String jsondata=FileUtils.readFileToString(new File("target/rejectRpa.json"),"UTF-8");
		
		
	return jsondata;
		
		
	}
	
	@PostMapping("/postrejectRpa")
	public String postRejectRpa(@RequestBody String rejectrpa) 
	{
		
		//System.out.println(editrpa);
		try {
			//JSONObject json = new JSONObject(editrpa);
			//System.out.println(json);
			JsonNode actualObj = mapper.readTree(rejectrpa);
			mapper.writeValue(new File("D:\\TMS-backend-fake\\rpa\\target/rejectrpa.json"), actualObj);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rejectrpa;
	}
}
