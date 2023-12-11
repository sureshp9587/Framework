package com.baseClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.annotations.*;

import com.utilities.ReadConfig;

	//common functionality for every testcase
	//open application,close application,takes screenshots,log files generation
	public class BaseClassd2 {
		
	   public Logger log;
	   ReadConfig readconfig=new ReadConfig();
	   
	   public String url=readconfig.getApplicationURL();
	   public String username=readconfig.getUsername();
	   public String password=readconfig.getPassword();
	   public String firstname=readconfig.getFirstname();
	   public String middlename=readconfig.getMiddlename();
	   public String lastname=readconfig.getLastname();
	   public String nickname=readconfig.getNickname();
		
	   public static WebDriver driver;
	   @Parameters("browser")
	   @BeforeClass
	   public void openApplication(String browser) {
	       if(browser.equals("chrome")) {
	       driver=new ChromeDriver();
	       }
	       else if(browser.equals("edge")) {
	    	   driver = new EdgeDriver();
	       }
	       else if(browser.equals("firefox")) {
	    	   driver = new FirefoxDriver();
	       }
	       driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	       
	       log = Logger.getLogger(this.getClass());
	       PropertyConfigurator.configure("./Configurationfile/log4j.properties");
	       driver.get(url);
	       
	   }
	   
	   public void proof(WebDriver driver, String name) throws IOException, InterruptedException {
		   Thread.sleep(2000); 
		  TakesScreenshot ts = (TakesScreenshot) driver;
		  
		  File src = ts.getScreenshotAs(OutputType.FILE);
		  File target = new  File("./Screenshots/"+name+".png");
		  FileUtils.copyFile(src, target);
		  log.info("Screenshot is taken");
	    }
	   
	   @AfterClass
	   public void closeApplication() {
	       driver.close();
	   }
	   

	}

	

