package baseDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {

	private static WebDriver driver;
	private static Properties prop;
	private static String URL;
	public static String browser;
	public static WebDriver getInstance() throws IOException
	{
		String configFile="./src/main/resources/config.properties";
		FileInputStream instream = new FileInputStream(new File(configFile));
		prop = new Properties(); 
		prop.load(instream);
		browser = prop.getProperty("browser");
		URL = prop.getProperty("url");
		if(browser.equalsIgnoreCase("chrome"))
		{	
			String loc=prop.getProperty("chromeAgent");
			String cmd="webdriver.chrome.driver";
			System.setProperty(cmd, loc);
			driver= new ChromeDriver();
		} else if(browser.equalsIgnoreCase("firefox"))
		{
			String loc=prop.getProperty("firefoxAgent");
			String cmd="webdriver.gecko.driver";
			System.setProperty(cmd, loc);
			driver= new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			String loc=prop.getProperty("edgeAgent");
			String cmd="webdriver.edge.driver";
			System.setProperty(cmd, loc);
			driver= new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("IE") || browser.equalsIgnoreCase("internetExplorer"))
		{
			String loc=prop.getProperty("IEAgent");
			String cmd="webdriver.ie.driver";
			System.setProperty(cmd, loc);
			driver= new InternetExplorerDriver();
		}
		else
		{
			Throwable thr= new Throwable();
			thr.initCause(null);
		}
		driver.manage().window().maximize();
		driver.get(URL);
		return driver;
	}
	
	public static WebDriver getInstance(String locBrowser) throws IOException
	{
		String configFile="./src/main/resources/config.properties";
		FileInputStream instream = new FileInputStream(new File(configFile));
		prop=new Properties();
		prop.load(instream);
		//browser = prop.getProperty("browser");
		URL = prop.getProperty("url");
		if(locBrowser.equalsIgnoreCase("chrome"))
		{	
			String loc=prop.getProperty("chromeAgent");
			String cmd="webdriver.chrome.driver";
			System.setProperty(cmd, loc);
			driver= new ChromeDriver();
		} else if(locBrowser.equalsIgnoreCase("firefox"))
		{
			String loc=prop.getProperty("firefoxAgent");
			String cmd="webdriver.gecko.driver";
			System.setProperty(cmd, loc);
			driver= new FirefoxDriver();
		}
		else if(locBrowser.equalsIgnoreCase("edge"))
		{
			String loc=prop.getProperty("edgeAgent");
			String cmd="webdriver.edge.driver";
			System.setProperty(cmd, loc);
			driver= new EdgeDriver();
		}
		else if(locBrowser.equalsIgnoreCase("IE") || browser.equalsIgnoreCase("internetExplorer"))
		{
			String loc=prop.getProperty("IEAgent");
			String cmd="webdriver.ie.driver";
			System.setProperty(cmd, loc);
			driver= new InternetExplorerDriver();
		}else
		{
			Throwable thr= new Throwable();
			thr.initCause(null);
		}
		driver.manage().window().maximize();
		driver.get(URL);
		return driver;
	}
}
