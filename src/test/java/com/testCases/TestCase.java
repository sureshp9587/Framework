package com.testCases;

import org.testng.annotations.Test;

//import com.baseClass.BaseClass;
import com.baseClass.BaseClassd2;
import com.pageObjects.*;


public class TestCase extends BaseClassd2 {

   @Test
   public void logintest() throws InterruptedException {
       
       LoginPaged2 lp=new LoginPaged2(driver);
       lp.setUsername("username");
       System.out.println("username is enetered");
       Thread.sleep(2000);
       lp.setPassword("password");
       System.out.println("password is enetered");
       Thread.sleep(2000);
       lp.ClickLoginbtn();
       System.out.println("user is succefully logging inito the account");
   }
}
