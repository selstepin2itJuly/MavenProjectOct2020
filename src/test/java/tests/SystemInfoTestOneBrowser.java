package tests;

import org.testng.annotations.Test;

import baseDriver.TestBase;
import junit.framework.Assert;
import pages.DashBoardPage;
import pages.LoginPage;
import pages.SystemInfoPage;
import utilities.Utility;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class SystemInfoTestOneBrowser {
	private WebDriver dr;
	LoginPage lp;
	DashBoardPage dp;
	SystemInfoPage sip;
  @Test
  public void getOSInfoSingleBrowsr() throws IOException 
  {

	  String s = sip.getOSDetailsInSystemInfo();
	  Utility.addCaptureScreenToReport(dr);
	  Assert.assertEquals("Microsoft Windows NT 6.1.7601 Service Pack 1", s);
  
  }
  @Test
  public void getLocakSystemtimeSingleBrowser() throws IOException
  {
	 
	  String s = sip.getSerLovaltimeISystemInfo();
	  Utility.addCaptureScreenToReport(dr);
	  Assert.assertFalse(s.isEmpty());
  }
  @Parameters("browser")
  @BeforeClass
  public void beforeClass(String browser) throws IOException {
	  dr=TestBase.getInstance(browser);
	  lp=new LoginPage(dr);
	  dp = new DashBoardPage(dr);
	  sip = new SystemInfoPage(dr);
	  lp.loginToApplication("admin@yourstore.com", "admin");
	  Assert.assertTrue(dp.isDashBoardTextDisplayed());
	  sip.navigateToSystemInfo();
  }

  @AfterClass
  public void afterClass() {
	  dr.quit();
  }

}
