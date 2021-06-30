package com.converttojson.ConvertXmlToJson;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.conversion.bean.Users;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
	public final static String XML_FILE = "C:\\Users\\P7112764\\eclipse-workspace\\ConvertXmlToJson\\target\\users.xml";

    public static void main( String[] args ) throws FileNotFoundException, JAXBException{

       Users users = convertXmlToObject(new FileInputStream(new File(XML_FILE)));
       System.out.println(convertObjectToJson(users));
    }
    public static Users convertXmlToObject(InputStream in) throws JAXBException {
    	JAXBContext jaxbContent = JAXBContext.newInstance(Users.class);
    	Unmarshaller unmarshaller = jaxbContent.createUnmarshaller();
    	return (Users) unmarshaller.unmarshal(in);
    	} 
    
    public static String convertObjectToJson(Users user) {
    	GsonBuilder gsonBuilder = new GsonBuilder();
    	gsonBuilder.setPrettyPrinting();
    	gsonBuilder.disableHtmlEscaping();
    	
    	Gson gson = gsonBuilder.create();
    	return gson.toJson(user , Users.class);
    	}
}
