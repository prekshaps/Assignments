package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.CustomException;

@RestController
@RequestMapping("/secret-door")
public class SecretDoor{





@GetMapping
public SecretDoorResponse secretBouncer(@RequestParam String passcode) {
	if(!passcode.equals("mango")) {
		throw new CustomException(
				"Wrong passcode",
				"You've entereed an incorrectpasscode,try agin with correct One",
				"Orange , juicy and sweet",
				"Ask your friend for access at http://www.letmeinthisdoor.com",
				"Reach out to http://www.letmeinthissecretdoor.com/support for more help"
				);
		
	}
	return new SecretDoorResponse("see you");
}
}