package com.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportingListener implements ITestListener{

	   public ExtentHtmlReporter report;//Add UI information
	   public ExtentReports extent;//common information about user
	   public ExtentTest logger;//add testcases entities
	   
	   public void onStart(ITestContext testcontext) {
	       //create time stamp
		   String timestamp=new SimpleDateFormat("yyyy.MM.dd.mm.ss").format(new Date());
	       //create report name
	       String repName="Test-Report" + timestamp + ".html";
	       //specify the location
	    report = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Report/"+repName);
	    report.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
	   // provide basic information
	    extent =new ExtentReports();
	    extent.attachReporter(report);
	    extent.setSystemInfo("Hostname", "localhost");
	    extent.setSystemInfo("Environment", "QA");
	    extent.setSystemInfo("user", "suresh");
	   
	    //provide the report information
	    report.config().setDocumentTitle("OrangeHRM Application Automation");
	    report.config().setReportName("Function test report");
	    report.config().setTestViewChartLocation(ChartLocation.TOP);
	    report.config().setTheme(Theme.DARK);
	   
	   
	   }
	   public void onTestSuccess(ITestResult tr) {
	       //create new entry
	       logger=extent.createTest(tr.getName());
	       logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	   }

	   public void onTestFailure(ITestResult tr) {
	       
	       logger=extent.createTest(tr.getName());
	       logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
	   
	       String screenshotpath = System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
	       File  f = new File(screenshotpath);
	       
	       if(f.exists()) {
	    	   try {
	    		   logger.fail("Screenshot is below: "+logger.addScreenCaptureFromPath(screenshotpath));
	    	   }catch(Exception e) {
	    		   e.printStackTrace();
	    	   }
	       }
	   
	   }
	   public void onTestSkipped(ITestResult tr) {
	       
	       logger=extent.createTest(tr.getName());
	       logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	       
	   }

	   public void onFinish(ITestContext testcontext) {
	       
	       extent.flush();//clear you space
	   }
}