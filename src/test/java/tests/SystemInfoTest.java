package tests;

import org.testng.annotations.Test;

import baseDriver.TestBase;
import junit.framework.Assert;
import pages.DashBoardPage;
import pages.LoginPage;
import pages.SystemInfoPage;
import utilities.Utility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class SystemInfoTest {
	private WebDriver dr;
	LoginPage lp;
	DashBoardPage dp;
	SystemInfoPage sip;
  @Test
  public void getOSInfo() throws IOException 
  {
	  lp.loginToApplication("admin@yourstore.com", "admin");
	  Assert.assertTrue(dp.isDashBoardTextDisplayed());
	  sip.navigateToSystemInfo();
	  String s = sip.getOSDetailsInSystemInfo();
	  Utility.addCaptureScreenToReport(dr);
	  Assert.assertEquals("Microsoft Windows NT 6.1.7601 Service Pack 1", s);
  
  }
  @Test
  public void getLocakSystemtime() throws IOException
  {
	  lp.loginToApplication("admin@yourstore.com", "admin");
	  Assert.assertTrue(dp.isDashBoardTextDisplayed());
	  sip.navigateToSystemInfo();
	  String s = sip.getSerLovaltimeISystemInfo();
	  Utility.addCaptureScreenToReport(dr);
	  Assert.assertFalse(s.isEmpty());
  }
  @Parameters("browser")
  @BeforeMethod
  public void beforeMethod(String browser) throws IOException {
	  dr=TestBase.getInstance(browser); //with browser from testng
	  lp=new LoginPage(dr);
	  dp = new DashBoardPage(dr);
	  sip = new SystemInfoPage(dr);
  }

  @AfterMethod
  public void afterMethod() {
	  dr.quit();
  }

}
