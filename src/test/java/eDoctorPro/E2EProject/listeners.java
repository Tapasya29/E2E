package eDoctorPro.E2EProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtentReporterNG;

public class listeners extends Base implements ITestListener{
	ExtentTest test;
	ExtentReports extent=ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		 test=extent.createTest(result.getMethod().getMethodName());
		 extentTest.set(test);
		 //Initioal Demo
 	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "This Test Cases is PASSED");
 	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
			
		//ScreenShot
		
		extentTest.get().fail(result.getThrowable());
		WebDriver driver=null;
		String testMethosName=result.getMethod().getMethodName();
		try {
		driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		}
		catch(Exception e)
				{
		 
				}
		
		try {

		extentTest.get().addScreenCaptureFromPath(getScreenshotpath(testMethosName, driver), result.getMethod().getMethodName());	
		
		}
		catch(Exception e)
		{
			e.printStackTrace();	
		}
		
 	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
 	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
 	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
 	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
 	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		extent.flush();
 	}
	
	
	
	

}
