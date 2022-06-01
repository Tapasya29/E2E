package PageOjectPaturn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	 
	By emailid=By.cssSelector("[id='user_email']");
	By password=By.cssSelector("[id='user_password']");
	By submit=By.cssSelector("[type='submit']");
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}
	 
	
	public WebElement emailid()
	{
		
		return driver.findElement(emailid);
			
	}
	
	public WebElement password()
	{
		return driver.findElement(password);
		
	}
	public WebElement submit()
	{
		return driver.findElement(submit);
		
	}
	
	
}
