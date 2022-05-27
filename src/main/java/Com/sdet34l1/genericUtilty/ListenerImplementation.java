package Com.sdet34l1.genericUtilty;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {
	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("On test Start");
		ExtentSparkReporter spark=new ExtentSparkReporter("./extentReporter/extentReport.html");
		spark.config().setDocumentTitle("DocumentTitle");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("ReporterName");
	 report=new ExtentReports();
	 report.attachReporter(spark);
	 report.setSystemInfo("Enviroment","Testing Eniverment");
	 report.setSystemInfo("ReporterName","prajwal");
	 report.setSystemInfo("Platform","Windows10");
	 report.setSystemInfo("Unit testing","TestNg");
	}
   
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("On test sucesss");	
		test.log(Status.PASS, result.getMethod().getMethodName()+"is pass");
	}
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("On test start");
		test=report.createTest(result.getMethod().getMethodName());
		
	}
	@Override
	public void onTestFailure(ITestResult result) {
	System.out.println("On test failure");	
	test.log(Status.FAIL, result.getMethod().getMethodName()+"is failed");
	test.log(Status.FAIL, result.getThrowable());
	
	
//	
//		test.addScreenCaptureFromPath(new SeleniumDriverUtility(BaseClass.class.cast(result.getMethod().getInstance()).driver).takeScreenShot(result.getMethod().getMethodName(), BaseClass.class.cast(result.getMethod().getInstance()).jutil));
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
     JavaClassFileUtility jutil=new JavaClassFileUtility();
	SeleniumDriverUtility seleniumDriverUtility=new SeleniumDriverUtility();
		try {
			test.addScreenCaptureFromPath(seleniumDriverUtility.takeScreenShot(BaseClass.staticdriver, result.getMethod().getMethodName(),jutil));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//SeleniumDriverUtility seleniumDriverUtility=new SeleniumDriverUtility(BaseClass.staticdriver);
	//JavaClassFileUtility javautiliClassFileUtility=new JavaClassFileUtility();
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("On test Skipped");	
		test.log(Status.SKIP, result.getMethod().getMethodName()+"is skipped");
		test.log(Status.SKIP, result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("On test FailedButWithinSuccess");	
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("On test Finish");	
		report.flush();
	}
}
