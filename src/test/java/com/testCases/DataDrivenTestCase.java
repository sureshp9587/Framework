package com.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.baseClass.BaseClassd2;
import com.pageObjects.LoginPaged2;
import com.utilities.ExceldataUtils;

public class DataDrivenTestCase extends BaseClassd2{
  
  @Test(dataProvider="ExcelTestData")
  public void DatadrivenTest(String uname, String upswd) throws InterruptedException, IOException {
	  
	  LoginPaged2 lp = new LoginPaged2(driver);
	  
	  Thread.sleep(2000);
	  lp.setUsername(username);
	  log.info("username is enetered");
	  Thread.sleep(2000);
	  lp.setPassword(password);
	  log.info("password is enetered");
	  Thread.sleep(2000);
	  lp.ClickLoginbtn();
	  
	  String exp_title = "OrangeHRM";
      String act_title = driver.getTitle();
      
      if(exp_title.equals(act_title)) {
   	   Assert.assertTrue(true);
   	   log.info("Test case is pass");
   	  
   	 }
        else {
   	        proof(driver, "DatadrivenTest");
   	        Assert.assertTrue(false);
   	        log.info("Test case is faild");
        }
	  
	  }
  @DataProvider(name="ExcelTestData")
  String [][] getData() throws IOException{
	  String path=System.getProperty("user.dir")+"\\src\\test\\java\\testData1\\ExcelTestData.xlsx";
	  int rownum=ExceldataUtils.getRowcount(path, "Sheet1");
	  int colcount=ExceldataUtils.getCellcount(path, "Sheet1", 1);
	  
	  String logindata[][] = new String[rownum][colcount];
	  for(int i=1; i<=rownum; i++) {
		  for(int j=0;j<colcount;j++) {
			  logindata[i-1][j]=ExceldataUtils.getCelldata(path, "Sheet1", i, j);
		  }
	  }
	  return logindata;
  }
}
