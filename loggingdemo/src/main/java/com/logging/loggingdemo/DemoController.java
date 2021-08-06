package com.logging.loggingdemo;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	Logger logger = LoggerFactory.getLogger(DemoController.class);

	@GetMapping("/log")
	public void welcome(String msg) {
		logger.error(msg);
		logger.trace(msg);
		logger.debug(msg);
		logger.info(msg);
		logger.warn(msg);
		logger.error(msg);

	}

}
