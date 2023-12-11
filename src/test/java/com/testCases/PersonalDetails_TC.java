package com.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.baseClass.BaseClassd2;
import com.pageObjects.PersonalDetails;

public class PersonalDetails_TC extends BaseClassd2{
	@Test
	public void PersonalDetailsTest() throws IOException, InterruptedException {
		
		PersonalDetails pd = new PersonalDetails(driver);
		pd.setUserUsername(username);
		log.info("Username is entered");
		pd.setUserPassword(password);
		log.info("Password is entered");
		pd.ClickLogin();
		log.info("Login button is clicked");
		pd.ClickMyinfo();
		log.info("Myinfo buttun is clicked");
		pd.setUserFirstname(firstname);
		log.info("First name is entered");
		pd.setUserMiddlename(middlename);
		log.info("Middlename is entered");
		pd.setUserLastname(lastname);
		log.info("Lastname is entered");
		pd.setUserNickName(nickname);
		log.info("Nickname is enterd");
		Thread.sleep(2000);
		pd.ClickOnSavebtn();
		log.info("Save button clicked");
		
		String exp_title = "OrangeHRM";
		
	       String act_title = driver.getTitle();
	       
	       if(exp_title.equals(act_title)) {
	    	   Assert.assertTrue(true);
	    	   log.info("Test case is pass");
	    	  
	    	 }
	         else {
	    	        proof(driver, "PersonalDetailsTest");
	    	        Assert.assertTrue(false);
	    	        log.info("Test case is faild");
	         }
	     }
		
		
}
	


