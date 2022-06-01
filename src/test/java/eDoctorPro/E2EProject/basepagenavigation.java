package eDoctorPro.E2EProject;
//Intitilized Global Variable using file property
// Created   the Base class and created the object for the file properties
//Created the FileInputStream fils object and assign the path of file properties
//load the properties 
//Implemented the Page Object Module and created the methods accordignly
//Inplemented the testNG Framework by right click and click on convert to TestNG
//Run the test suite using test.xml file
//Run the Maven project and from Maven site, Copy the Test.XML File and past it to POM.xml
//Right click on Project> Properties and travels till project 
//open cmd command prompt
//mvn clear
//mvn compile
//mvn test
//Add Log4j
//Add extended report
//
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageOjectPaturn.LandingPage;
import PageOjectPaturn.LoginPage;
import resources.Base;

public class basepagenavigation extends Base {
	public WebDriver driver;
	public static Logger Log=LogManager.getLogger(Base.class.getName());
	 
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=Intializedriver();
		Log.info("Driver is Intialized");
		
		
	}
	@Test(dataProvider="getData")
	public void HomePage(String username,String password) throws IOException
	{
		driver.get(prop.getProperty("url"));
		Log.info("Navigated to Home Page");
		LandingPage l=new LandingPage(driver);
		l.getlogin().click();
	 	 LoginPage lp=new LoginPage(driver);
		lp.emailid().sendKeys(username);
		lp.password().sendKeys(password);
		//System.out.println(text);
		lp.submit().click();
		
		 
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//Need to create an Array for this 
		
		Object[][] data=new Object[2][2];
		//fill the date for row ans column 
		data[0][0]="sandeepdeshmukh2009@gmail.com";
		data[0][1]="Sandeep";
		//data[0][2]="nonristricted user";
		
		data[1][0]="abc@gmail.com";
		data[1][1]="xyz";
		//data[1][2]="Ristricted user";
	 return data; 
	}
	
	@AfterTest
	
	public void teardown()
	{
		
		driver.close();
	}
	 

}
