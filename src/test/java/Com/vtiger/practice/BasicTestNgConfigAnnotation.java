package Com.vtiger.practice;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BasicTestNgConfigAnnotation {
	
	@BeforeSuite(groups = "sanity")
	public void beforesuite1Test() {
		Reporter.log("beforesuite1", true);
	}
	@AfterSuite(groups = "sanity")
	public void aftersuite1Test() {
		Reporter.log("aftersuite1", true);
	}
	
	@BeforeClass(groups = "regreesion")
	public void beforeclass1Test() {
		Reporter.log("beforeclass1", true);
	} 
	@AfterClass(groups = "sanity")
	public void afterClassTest() {
		Reporter.log("afterclass1", true);
	}
	@BeforeTest(groups = "regreesion")
	public void beforeTest1Test() {
		Reporter.log("beforetest1", true);
	}
	
	@AfterTest(groups = "sanity")
	public void afterTest1Test() {
		Reporter.log("aftertest1", true);
	}
	
	
	@BeforeMethod(groups = "regreesion")
	public void beforemethodTest1() {
		Reporter.log("beforemethod1", true);
	}
	@BeforeMethod(groups = "regreesion")
	public void beforemethodTest2() {
		Reporter.log("beformehod2", true);
	}
	@AfterMethod(groups = "regreesion")
	public void aftermeghod1Test() {
		Reporter.log("aftermethod1", true);
	}
}
