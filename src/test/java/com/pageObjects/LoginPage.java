package com.pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
   
   public static WebDriver rdriver;
   public LoginPage(WebDriver ldriver) {
       
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
   
   public void setUsername(String uname) {
       txtusername.sendKeys(uname);
   }
   public void setPassword(String upwd){
       txtpassword.sendKeys(upwd);
   }
   public void ClickLoginbtn() {
       btnLogin.click();
   }

}

