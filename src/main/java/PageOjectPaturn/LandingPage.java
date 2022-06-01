package PageOjectPaturn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	By login=By.cssSelector("a[href*='sign_in']");
	By tital=By.cssSelector(".text-center>h2");
	
	By getNavigationBar=By.xpath("//*[@id=\"homepage\"]/header/div[2]/div/nav/ul");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}

	public WebElement getlogin()
	{
		
		return driver.findElement(login);
			
	}
	public WebElement gettitle()
	{
		
		return driver.findElement(tital);
			
	}
	public WebElement navigationBar()
	{
		
		return driver.findElement(getNavigationBar);
			
	}
}
