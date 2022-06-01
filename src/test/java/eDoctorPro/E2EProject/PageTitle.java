package eDoctorPro.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageOjectPaturn.LandingPage;
import PageOjectPaturn.LoginPage;
import resources.Base;

public class PageTitle extends Base {
	public WebDriver driver;
	public static Logger Log=LogManager.getLogger(Base.class.getName());
	 @BeforeTest
	 
	 public void initialize() throws IOException
	 {
		driver=Intializedriver();
		driver.get(prop.getProperty("url"));
	 }
	
	@Test( )
	public void gettitle( ) throws IOException
	{
		 
		LandingPage l=new LandingPage(driver);
		Assert.assertEquals(l.gettitle().getText(), "FEATURED COURSES123");
		 //(l.gettitle().getText());
		Log.info("Actual TitleName and Expected TitileName are Same(PASS) ");
	}
	  
	@AfterTest
	public void teardown()
	{
		
		driver.close();
	}
		
	}


