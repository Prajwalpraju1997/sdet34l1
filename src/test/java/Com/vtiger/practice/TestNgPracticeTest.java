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

public class TestNgPracticeTest {
	
	@BeforeSuite
	public void beforeSuite1Test() {
		Reporter.log("beforesuite", true);
	}
	
	@BeforeTest
	public void beforeTest1Test() {
		Reporter.log("beforetest", true);
	}
	@BeforeClass
	public void beforeClassTest() {
		Reporter.log("beforeclass", true);
	}
	@BeforeMethod
	public void beforeMethod1Test() {
		Reporter.log("beforemethod1", true);
	}
	@BeforeMethod
	public void beforeMethod2Test() {
		Reporter.log("beforemethod2", true);
	}
	@BeforeMethod
	public void beforeMethod3Test() {
		Reporter.log("beforemethod3", true);
	}
	
	@Test
	public void test1Test() {
		Reporter.log("test1", true);
	}
	
	@Test
	public void test2Test() {
		Reporter.log("test2", true);
	}

	@AfterMethod
	public void afterMethod1Test() {
		Reporter.log("aftermethod1", true);
	}
	@AfterMethod
	public void afterMethod2Test() {
		Reporter.log("aftermethod2", true);
	}
	
	@AfterClass
	public void afterClassTest() {
	Reporter.log("afterclass", true);
	}
	@AfterTest
	public void afterTestTest() {
		Reporter.log("aftertest", true);
		}
     @AfterSuite
    public void afterSuiteTest1() {
	Reporter.log("aftersuite1", true);
	}
     @AfterSuite
     public void afterSuiteTest2() {
 	Reporter.log("aftersuite2", true);
 	}
     
}
