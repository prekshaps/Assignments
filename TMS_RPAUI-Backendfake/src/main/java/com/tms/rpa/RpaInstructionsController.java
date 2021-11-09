package com.tms.rpa;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class RpaInstructionsController {
	@GetMapping("/rpaInstruction")
	public String postRejectRpawithvalue() throws IOException 
	{
		
String jsondata=FileUtils.readFileToString(new File("target/rpaInstruction.json"),"UTF-8");
		
		
	return jsondata;
		
		
	}
}
