package com.tms.rpa;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class RejectRpaReportController {
	@GetMapping("/RejectRPAReport")
	public String postRejectRpawithvalue() throws IOException {

		String jsondata = FileUtils.readFileToString(new File("target/rpaRejectReport.json"), "UTF-8");

		return jsondata;

	}
}
