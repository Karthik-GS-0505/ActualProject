package genericUtilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnersImplementation implements ITestListener{
	
	//To capture current system date and time
	Date d = new Date(); //import java.util.Date;
	SimpleDateFormat f = new SimpleDateFormat(" dd-MM-yyyy hh-mm-ss");
	String date = f.format(d);
	
	//For extend report
	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) 
	{
		String testMethodName = result.getMethod().getMethodName();
		System.out.println(testMethodName+"--- Test Execution Started ---");
		
		//Intimate the @Test for extent reports
		test = report.createTest(testMethodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		String testMethodName = result.getMethod().getMethodName();
		System.out.println(testMethodName+"--- Test PASS ---");
		
		//Capture Exception
		System.out.println("Exception - "+result.getThrowable());
		
		//Log the test status as PASS in Extent reports
		test.log(Status.PASS, testMethodName+" --- Test PASS ---");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		String testMethodName = result.getMethod().getMethodName();
		System.out.println(testMethodName+"--- Test FAIL ---");
		
		//Capture Exception
		System.out.println("Exception - "+result.getThrowable());
		
		//Log the test status as FAIL in Extent reports
		test.log(Status.FAIL, testMethodName+" --- Test FAIL ---");
		
		//Capture ScreenShot
		SeleniumUtilities sUtil = new SeleniumUtilities();
		
		//For ScreenShot name
		String screenshotName = testMethodName+date;
		
		try {
			String path = sUtil.captureScreenShot(BaseClass.sdriver, screenshotName);
			//Attach the screenshot to extent reports 
			test.addScreenCaptureFromPath(path, screenshotName); 
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		String testMethodName = result.getMethod().getMethodName();
		System.out.println(testMethodName+"--- Test SKIP ---");
		
		//Capture Exception
		System.out.println(result.getThrowable());
		
		//Log the test status as SKIP in Extent reports
		test.log(Status.SKIP, testMethodName+" --- Test SKIP ---");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) 
	{

	}

	@Override
	public void onStart(ITestContext context) 
	{
		System.out.println("Suite Execution Started");
		
		//Configure extended report
		ExtentSparkReporter esr = new ExtentSparkReporter(".\\ExtendReports\\Report -"+date+".html");
		esr.config().setDocumentTitle("Sauce Labs Bike Light Execution Report");
		esr.config().setReportName("Execution Report");
		esr.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base Platform", "Windows Family");
		report.setSystemInfo("Base URL", "http://testEnv.com");
		report.setSystemInfo("Reorter Name", "Karthik");
		
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		System.out.println("Suite Execution Completed");
		
		//Generate extent Report
		report.flush();
	}

}
