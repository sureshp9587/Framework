package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalDetails {

	public WebDriver driverr;
	
	public PersonalDetails(WebDriver driverl) {
		
		driverr =driverl;
		PageFactory.initElements(driverl, this);
	}
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginbtn;
	
	@FindBy(xpath="//div[@class='oxd-sidepanel-body']//li[6]/a")
	WebElement myinfobtn;
	
	@FindBy(name="firstName")
	WebElement firstName;
	
	@FindBy(name="middleName")
	WebElement middleName;
	
	@FindBy(name="lastName")
	WebElement lastName;
	
	@FindBy(xpath="//div[@data-v-957b4417]//input[@class='oxd-input oxd-input--active'][1]")
	WebElement nickName;
	
	@FindBy(xpath="//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//button[@type='submit'][normalize-space()='Save']")
	WebElement btnsave;
	
	public void setUserUsername(String usern) {
		username.sendKeys(usern);
	}
	
	public void setUserPassword(String passw) {
		password.sendKeys(passw);
	}
	
	public void ClickLogin() {
		loginbtn.click();
	}
	
	public void ClickMyinfo() {
		myinfobtn.click();		
	}
	
	public void setUserFirstname(String fname) {
		firstName.sendKeys(fname);
	}
	
	public void setUserMiddlename(String mname) {
		middleName.sendKeys(mname);
	}
	
	public void setUserLastname(String lname) {
		lastName.sendKeys(lname);
	}
	
	public void setUserNickName(String niname) {
		nickName.sendKeys(niname);
	}
	
	public void ClickOnSavebtn() {
		btnsave.click();
	}
	
	
}
