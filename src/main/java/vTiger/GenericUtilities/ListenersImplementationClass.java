package vTiger.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class consists of all implementation methods of ITestListenrs
 * @author Shivunayak
 *
 */

public class ListenersImplementationClass implements ITestListener{


	ExtentReports report;
	ExtentTest test;
	
	public void onStart(ITestContext context) {
		
		// TODO Auto-generated method stub
		
		System.out.println("Suite Execution Started"); 
		
		ExtentSparkReporter htmlReport=new ExtentSparkReporter(".\\ExtentReports\\Reports"+new JavaUtility().GetSystemDateFormat()+".html");
		htmlReport.config().setDocumentTitle("Vtiger Execution Report");
		htmlReport.config().setReportName("Vtiger Execution Report");
		htmlReport.config().setTheme(Theme.DARK);
		
		 report=new ExtentReports();
		 report.attachReporter(htmlReport);
		 report.setSystemInfo("Base URL", "http://localhost:8888");
		 report.setSystemInfo("Base Browser", "chrome");
		 report.setSystemInfo("Base OS", "Windows 10");
		 report.setSystemInfo("Reporter Name", "Parimala");
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		WebDriverUtility wUtil=new WebDriverUtility();
		JavaUtility jUtil=new JavaUtility();
		
		String MethodName= result.getMethod().getMethodName();
		test.log(Status.FAIL, "Test Script Failed"+ MethodName);
		test.log(Status.FAIL, result.getThrowable()+MethodName);
		
		//To get the srceenshot if testScritpt got  failed 
		
		String ScreeshotName = MethodName+"-"+jUtil.GetSystemDateFormat();
		
		//use driver reference from baseclass 
		
		try {
			String path=wUtil.takeScreenshot(BaseClass.Sdriver, ScreeshotName);
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		String MethodName= result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName + " Test Script Skipped");
		
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String MethodName= result.getMethod().getMethodName();
		test=report.createTest(MethodName);
		 test.log(Status.INFO, MethodName +"Test Execution Started-");
		
	}

	public void onTestSuccess(ITestResult result) {
		
		// TODO Auto-generated method stub
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, "Test Script  Passed-"+ MethodName);
		 
		
	}
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method 
		test.log(Status.INFO, "Suite execution  Finished ");
		report.flush();
	
	}

}
