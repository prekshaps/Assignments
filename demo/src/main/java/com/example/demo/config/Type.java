package com.example.demo.config;

import java.util.HashMap;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "ent")
public class Type {

	
	private HashMap<String,String> map;
	
	public HashMap<String,String> getMap(){
		return map;
	}
	
	public void setMap(HashMap<String,String>map) {
		this.map = map;
	}
}
