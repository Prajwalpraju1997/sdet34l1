package Com.vtiger.practice;

import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class PracticeTestNgTest  extends TestNgPracticeTest {
	
	@BeforeSuite
	public void beforeSuite2Test() {
		Reporter.log("beforesuite2", true);
	}
	@BeforeSuite
	public void beforeSuit3Test() {
		Reporter.log("beforesuite3", true);
	}
	@Test
	public void practice1Test() {
		Reporter.log("TestngPractice1---11111", true);
	}
	@Test
	public void practice2Test() {
		Reporter.log("TestngPractice1---2", true);
	}
	@AfterSuite
	public void afterSuite3Test() {
		Reporter.log("aftersuite3", true);
	}
	@AfterSuite
	public void afterSuit4Test() {
		Reporter.log("aftersuite", true);
	}
}