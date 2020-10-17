package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SystemInfoPage {

private WebDriver dr;
	
	public SystemInfoPage(WebDriver driver)
	{
		this.dr=driver;
		//Important
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(xpath="//*[@class='col-md-9']/div[@class='form-text-row']")
	List<WebElement> sysDetails;
	
	
	public void navigateToSystemInfo()
	{
		DashBoardPage db= new DashBoardPage(dr);
		//db.clickOnHamBurger();
		db.clickOnSystemInMenu();
		db.clickOnSystemInfoSubMenu();
	}
	
	public String getOSDetailsInSystemInfo()
	{
		String s= sysDetails.get(1).getText();
		return s.trim();
	}
	
	public String getSerLovaltimeISystemInfo()
	{
		String s= sysDetails.get(5).getText();
		return s.trim();
	}
	
}
