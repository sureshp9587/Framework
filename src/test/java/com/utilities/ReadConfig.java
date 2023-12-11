package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig(){
		File src = new File("./Configurationfile/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
	  }
	  public String getApplicationURL() {
		
			String url =pro.getProperty("baseURL");
			return url;
		}
	  public String getUsername() {
		  String username = pro.getProperty("username");
		  return username;
	  }
	  public String getPassword() {
		  String password = pro.getProperty("password");
		  return password;
	  }
	  
	  public String getFirstname() {
		  String firstname = pro.getProperty("Firstname");
		  return firstname;
	  }
	  
	  public String getMiddlename() {
		  String middlename = pro.getProperty("Middlename");
	      return middlename;
	  }
	  
	  public String getLastname() {
		  String lastname = pro.getProperty("Lastname");
		  return lastname;
	  }
	  
	  public String getNickname() {
		  String nickname = pro.getProperty("Nickname");
		  return nickname;
	  }
	  
}
