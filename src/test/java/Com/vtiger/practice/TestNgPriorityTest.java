package Com.vtiger.practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNgPriorityTest {
	
	@Test(priority = 0)
	public void testNgPriority() {
		Reporter.log("test23", true);	
	}
	
	@Test
	public void testNgPriority1() {
		Reporter.log("test223", true);	
	}
}
