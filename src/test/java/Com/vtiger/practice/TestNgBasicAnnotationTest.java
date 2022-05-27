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
import org.testng.annotations.Test;

public class TestNgBasicAnnotationTest {
	
	@BeforeSuite
	public void beforesuite1Test() {
		Reporter.log("beforesuite1", true);
	}
	@AfterSuite
	public void aftertest1Test() {
		Reporter.log("aftersuite1", true);
	}
	
	@BeforeClass
	public void beforeclass1Test() {
		Reporter.log("beforeclass1", true);
	}
	
	@Test
	public void test1Test() {
		Reporter.log("test1", true);
	}
	
	@Test
	public void test2Test() {
		Reporter.log("test2", true);
	}
	@AfterClass
	public void afterClassTest() {
		Reporter.log("aftertest1", true);
	}
	@BeforeTest
	public void beforeTest1Test() {
		Reporter.log("beforetest1", true);
	}
	
	@AfterTest
	public void afterTest1Test() {
		Reporter.log("aftertest1", true);
	}
	@BeforeMethod
	public void beforemethodTest1() {
		Reporter.log("beforemethod1", true);
	}
	@BeforeMethod
	public void beforemethodTest2() {
		Reporter.log("beformehod2", true);
	}
	@AfterMethod
	public void aftermeghod1Test() {
		Reporter.log("aftermethod1", true);
	}
}

