package com.baseClass;
    import java.time.Duration;

import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.*;

	//common functionality for every testcase
	//open application,close application,takes screenshots,log files generation
	public class BaseClass {
	   
	   public static WebDriver driver;
	   
	   @BeforeClass
	   public void openApplication() {
	       
	       driver=new ChromeDriver();
	       driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	       driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	       
	   }
	   
	   @AfterClass
	   public void closeApplication() {
	       driver.close();
	   }
	   

	}

	

