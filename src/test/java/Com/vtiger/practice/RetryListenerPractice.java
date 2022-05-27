package Com.vtiger.practice;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RetryListenerPractice {

	SoftAssert softAsser=new SoftAssert();
	
@Test
public void PracticeTest1() {
	
	Reporter.log("a.test1", true);
	Reporter.log("b.test2", true);
	//assertEquals("abc", "abd");
	Reporter.log("c.test3", true);
	Reporter.log("d.test4", true);
	Assert.fail();
	Reporter.log("e.test5", true);
	Reporter.log("f.test6", true);	
}
@Test
public void PracticeTest2() {
	
	Reporter.log("a.test7", true);
	Reporter.log("b.test8", true);
	Reporter.log("c.test9", true);
	Reporter.log("d.test10", true);
	//Assert.fail();
	Reporter.log("e.test11", true);
	Reporter.log("f.test12", true);			
}
}