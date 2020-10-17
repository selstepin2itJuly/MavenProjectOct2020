package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Utility {

	public static  void scrollToElement(WebDriver dr, WebElement ele)
	{
		JavascriptExecutor je= (JavascriptExecutor) dr;       
        je.executeScript("arguments[0].scrollIntoView(false);", ele);
        je.executeScript("window.scrollBy(0,300)", "");
	}
	
	public static void waitForElementToClickable(WebDriver dr, WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(dr, 25);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	public static void waitForElement(WebDriver dr, WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(dr, 25);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public static void captureScreen(WebDriver dr) throws IOException
	{
		TakesScreenshot tc=(TakesScreenshot) dr;
		File file = tc.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file, new File("image_"+getDate()+"_.jpg"));
	}
	
	public static void addCaptureScreenToReport(WebDriver dr) throws IOException
	{
		TakesScreenshot tc=(TakesScreenshot) dr;
		String file = tc.getScreenshotAs(OutputType.BASE64);
		//File fy = new File("image_"+getDate()+"_.jpg");
		//FileHandler.copy(file, fy );
		String st= "<img src='data:image/jpg;base64" + file
        + "' height='800' width='600' /></a></td>";
		
		Reporter.log(st);
	}
	public static String getDate()
	{
		Date d=new Date();
		System.out.println(d);
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY_MM_dd_HH_mm_ss_SSS");
		String s = sdf.format(d);
		System.out.println(s);
		return s;
		
	}
}
