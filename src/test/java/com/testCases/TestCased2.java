package com.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;


import com.baseClass.BaseClassd2;
import com.pageObjects.*;


public class TestCased2 extends BaseClassd2 {

   @Test
   public void logintest() throws InterruptedException,IOException {
       
       LoginPaged2 lp=new LoginPaged2(driver);
       lp.setUsername(username);
       log.info("username is enetered");
       Thread.sleep(2000);
       lp.setPassword(password);
       log.info("password is enetered");
       Thread.sleep(2000);
       lp.ClickLoginbtn();
       log.info("user is succefully logging inito the account");
       
   
       
       String exp_title = "OrangeHRM";
       String act_title = driver.getTitle();
       
       if(exp_title.equals(act_title)) {
    	   Assert.assertTrue(true);
    	   log.info("Test case is pass");
    	  
    	 }
         else {
    	        proof(driver, "logintest");
    	        Assert.assertTrue(false);
    	        log.info("Test case is faild");
         }
     }
}
