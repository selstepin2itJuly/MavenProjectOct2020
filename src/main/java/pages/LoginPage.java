package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver dr;
	
	public LoginPage(WebDriver driver)
	{
		this.dr=driver;
		//Important
		PageFactory.initElements(dr, this);
	}
	//dr.findElement(By.id("Email")).clear();
	@FindBy(id="Email")
	private WebElement username;
	
    //dr.findElement(By.id("Email")).sendKeys("admin@yourstore.com");
    //dr.findElement(By.id("Password")).clear();
    @FindBy(id="Password")
    private WebElement password;
    //dr.findElement(By.id("Password")).sendKeys("admin");
    
    //dr.findElement(By.cssSelector("[type='submit']")).click();
    @FindBy(css="[type='submit']")
    WebElement loginButton;
    
    @FindBy(id="Email-error")
    WebElement emailError;
    
    public void loginToApplication(String user, String pass)
    {
    	username.clear();
    	username.sendKeys(user);
    	password.clear();
    	password.sendKeys(pass);
    	loginButton.click();
    }
    
    public Boolean isEmailErrorDisplayed()
    {
    	boolean b=false;
    	try {
    		b=emailError.isDisplayed();
    	}catch(Exception e)
    	{
    		
    	}
		return b;
    }
    
    public String emailErrorText()
    {
    	String s = emailError.getText();
		return s.trim();
    	
    }
}
