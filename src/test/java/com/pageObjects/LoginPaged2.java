package com.pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPaged2 {
   
   public static WebDriver rdriver;
   public LoginPaged2(WebDriver ldriver) {
       
       rdriver=ldriver;
       PageFactory.initElements(ldriver, this);
   }
   
   //locate the all webElements
   
   @FindBy(name="username")
   WebElement txtusername;
   
   @FindBy(name="password")
   WebElement txtpassword;
   
   @FindBy(xpath ="//button[@type='submit']")
   WebElement btnLogin;
   
   public void setUsername(String usname) {
	   txtusername.sendKeys(usname);
   }
   public void setPassword(String uspswd) {
	   txtpassword.sendKeys(uspswd);
   }
   public void ClickLoginbtn() {
       btnLogin.click();
   }

}

