package tests;

import org.testng.annotations.Test;

import baseDriver.TestBase;
import utilities.Utility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TestScenarioOne {
	
	private static WebDriver dr; 
  @Test(description="Login", priority=1, enabled=true)
  public void testcaseOne() {
		dr.findElement(By.id("Email")).clear();
        dr.findElement(By.id("Email")).sendKeys("admin@yourstore.com");
        dr.findElement(By.id("Password")).clear();
        dr.findElement(By.id("Password")).sendKeys("admin");
        dr.findElement(By.cssSelector("[type='submit']")).click();
        Assert.assertEquals(dr.findElement(By.xpath("//*[text()='Logout']")).isDisplayed(), true);
  }
  @Test(description="MultipleWindow", priority=2, enabled=true)
  public void testCaseTwo() {
	  dr.findElement(By.id("Email")).clear();
      dr.findElement(By.id("Email")).sendKeys("admin@yourstore.com");
      dr.findElement(By.id("Password")).clear();
      dr.findElement(By.id("Password")).sendKeys("admin");
      dr.findElement(By.cssSelector("[type='submit']")).click();
      Utility.scrollToElement(dr, dr.findElement(By.xpath("//a[text()='nopCommerce']")));
      dr.findElement(By.xpath("//a[text()='nopCommerce']")).click();
      
      //Set<String> s = dr.getWindowHandles();
      //System.out.println(s);
      ArrayList<String> handles=new ArrayList<String>(dr.getWindowHandles());
      Assert.assertEquals(handles.size(), 2);
  }
  @Test(description="Login", priority=1, enabled=true)
  public void Three() {
	  Assert.assertTrue(false);
  }
  @Parameters("browser")
  @BeforeMethod
  public void beforeMethod(String browser) throws IOException 
  {
	dr=TestBase.getInstance(browser);
	dr.get("https://admin-demo.nopcommerce.com/");
  }

  @AfterMethod
  public void afterMethod() {
	  dr.quit();
  }

}
