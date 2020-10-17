package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoardPage {

private WebDriver dr;
	
	public DashBoardPage(WebDriver driver)
	{
		this.dr=driver;
		//Important
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(xpath="//*[@class='menu-item-title'][text()='Dashboard']")
	private WebElement dashboardText;
	
	@FindBy(linkText="Logout")
	WebElement logout;
	
	@FindBy(css="#nopSideBarPusher")
	private WebElement hamburger;
	
	@FindBy(xpath="//i[@class='fa fa-cube']/following::span[text()='System']")
	private WebElement systemInMenu;
	
	@FindBy(xpath="//*[@class='menu-item-title'][text()='System information']")
	private WebElement systemInfoSubMenu;
	
	public void clickOnHamBurger()
	{
		hamburger.click();
	}
	public void clickOnSystemInMenu()
	{
		systemInMenu.click();
	}
	public void clickOnSystemInfoSubMenu()
	{
		systemInfoSubMenu.click();
	}
	public void logout()
	{
		logout.click();
	}
	public Boolean isDashBoardTextDisplayed()
	{
		boolean b=false;
		try {
			waitForElement(dashboardText);
			b=dashboardText.isDisplayed();
		}catch(Exception e)
		{
			
		}
		return b;
	}
	
	public void waitForElement(WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(this.dr, 25);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
}
