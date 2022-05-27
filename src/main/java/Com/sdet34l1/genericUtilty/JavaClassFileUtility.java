package Com.sdet34l1.genericUtilty;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebElement;

/**
 * This method is used to convert
 * @author PRAJWAL
 *
 */

public class JavaClassFileUtility {
	
	/**
	 * This method is used to convert string value to long datatype
	 * @param value
	 * @return
	 */
	
	public long StringToLong(String value) {
		return Long.parseLong(value);
}

	/**
	 *This method used to get the random Number 
	 * @param limit
	 * @return
	 */
	public int getRandomNumber(int limit) {
		Random ran=new Random();
		return ran.nextInt(limit);
	}
	
	/**
	 * This method is used to print the message
	 * @param message
	 */

public void printStatement(String message) {
	System.out.println(message);
}

  /**
 * This method is used validated the statement 
 * @param actualResult
 * @param expectedResult
 * @param testCaseName
 */

public void assertionThroughifCondition(String actualResult, String expectedResult, String testCaseName) {
	if(actualResult.equalsIgnoreCase(expectedResult));
	{
		System.out.println(testCaseName+" created Successfully");
				System.out.println("TC pass");
	}
}

/**
 * This method is used to wait untill the element is clickable
 * @param element
 * @param polingtime
 * @param duration
 * @throws InterruptedException
 */

public void customWait(WebElement element, long polingtime, int duration) throws InterruptedException {
	int count = 0;
	while(count<=duration) {
		{
			try {
				element.click();
				break;
			}
			catch (Exception e) {
				Thread.sleep(polingtime*500);
				count++;
			}
		}
	}
}
/**
 * this method is get current date
 * @return
 */
public String dataTimeInFormat() {
	
  return new	SimpleDateFormat("dd_MM_yyyy_HH_mm_sss").format(new Date());
}
}
