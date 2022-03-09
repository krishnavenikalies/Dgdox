package dgdox;

import java.io.IOException;
import java.security.PublicKey;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.LogStatus;

import dgdox.utilities.extentutilities;

public class Listeners extends Baseclass implements ITestListener{
	
	ExtentReports extent= extentutilities.config();
	ExtentTest test;
	//object for Thread safe
	private static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS,"Successful");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		extentTest.get().fail(result.getThrowable());
		WebDriver driver=null;
  String testMethodName =result.getMethod().getMethodName();
  try {
 
  driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
  }catch(Exception e)
  {
	  
  }
  try {
	  extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver),testMethodName);
	  }
  catch(IOException e) {
	  e.printStackTrace();
  }
	
	// TODO Auto-generated method stub
		
	}
		
		
			
	


	
	
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		extent.flush();
	}

}
