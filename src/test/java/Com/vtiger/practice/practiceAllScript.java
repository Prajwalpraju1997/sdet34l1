package Com.vtiger.practice;

public class practiceAllScript {
//public static void main(String[] args) {
	
}
//campaign module

/*public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
	JavaClassFileUtility jutil=new JavaClassFileUtility();

	ExcelclassFileUtility.openExcel(IconstantClassPath.EXCELFILEPATH);
	FileClassUtility.openPropertyfile(IconstantClassPath.PROPERTYFILEPATH);	
	
	String url =FileClassUtility.getDataFromPropertyFile("url");
	String timeout = FileClassUtility.getDataFromPropertyFile("timeout");
	String username =FileClassUtility.getDataFromPropertyFile("username");
	String password = FileClassUtility.getDataFromPropertyFile("password");
	String browser = FileClassUtility.getDataFromPropertyFile("browser");
	
	long longTimeOut=jutil.StringToLong(timeout);	
	int randomnumber = jutil.getRandomNumber(1000);
	
	String productnname = ExcelclassFileUtility.getDataFromExcel("Products", 2, 1)+randomnumber;
	String campaignname = ExcelclassFileUtility.getDataFromExcel("campaign", 2, 1)+randomnumber;

	WebDriver driver=null;
	switch (browser) {
	case "chrome":
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		break;
		
	case "firefox":
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		break;
	default: {
		System.out.println("please specifiy the browser");
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}		
	}
	  SeleniumDriverUtility.navigateApp(url, driver);
	    SeleniumDriverUtility.browsersetting(longTimeOut, driver);
	LoginPage loginpage=new LoginPage(driver);
    HomePage homepage=new HomePage(driver);
    loginpage.loginActions(username, password);
    homepage.clickOnProduct();
    CreateNewProduct createProduct=new CreateNewProduct(driver);
    createProduct.clickOnProductContact();
    ProductPage productPageDetails=new ProductPage(driver);
    productPageDetails.enterProductNameTxtName(productnname);
    productPageDetails.saveProduct();
    Thread.sleep(2000);
    homepage.clickCampaign(driver);
    CampaignPage campaignpage=new CampaignPage(driver);
    campaignpage.clickcraeteCampaign();
    CreateNewCampaignPage createnewcampaignpage=new CreateNewCampaignPage(driver);
    
   createnewcampaignpage.enterCampaignName(campaignname);
   CampaignProductChildBrowser productChildBrowse=new CampaignProductChildBrowser(driver);
   campaignpage.clickOnProductSelect();
   SeleniumDriverUtility.switchToWindowBasedOnTitle(driver, productnname);
   productChildBrowse.childBrowsetHandels(driver, productnname);
   SeleniumDriverUtility
   .switchToWindowBasedOnTitle(driver, "CAMPAIGNS");
   createnewcampaignpage.saveCampaign();
   CampaignInformationPage campaignInfo=new CampaignInformationPage(driver);
	jutil.assertionThroughifCondition(campaignInfo.getCampaignName(),campaignname,"campaign and product");
	  Thread.sleep(2000); 
	   homepage.signOut(driver);
	   Thread.sleep(2000);
	SeleniumDriverUtility.quitbrowser(driver);


   
   
}
}
	/*WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	SeleniumDriverUtility.navigateApp(url, driver);
	SeleniumDriverUtility.browsersetting(longTimeOut, driver);
	
	driver.findElement(By.name("user_name")).sendKeys(username);
	 driver.findElement(By.name("user_password")).sendKeys(password);
	 driver.findElement(By.id("submitButton")).click();
	 
	 driver.findElement(By.xpath("//a[.='Products']")).click();
	 driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();

	 driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(productnname);
	 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	 
	 WebElement moreLink = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		SeleniumDriverUtility.mousehoverOntheElement(moreLink, driver);	
		
			driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
			driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
			driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(campaignname);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	 
			  Set<String> sessionId = driver.getWindowHandles();
			  for(String id:sessionId)
			  {
				  driver.switchTo().window(id);
				  if(driver.getTitle().contains("Products&action"));
				  {
					  break;
				  }
			  }
			  driver.findElement(By.id("search_txt")).sendKeys(productnname);
				 Thread.sleep(2000);
				  driver.findElement(By.xpath("//input[@name='search']")).click();
				  driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();	
}
}*/


//2)

/*public static void main(String[] args) throws IOException, InterruptedException
{
	JavaClassFileUtility jutil=new JavaClassFileUtility();	
	
	ExcelclassFileUtility.openExcel(IconstantClassPath.EXCELFILEPATH);
	FileClassUtility.openPropertyfile(IconstantClassPath.PROPERTYFILEPATH);
//FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.Properties");
//Properties property=new Properties();
//property.load(fis);
	
String url =FileClassUtility.getDataFromPropertyFile("url");
String timeout = FileClassUtility.getDataFromPropertyFile("timeout");
String username =FileClassUtility.getDataFromPropertyFile("username");
String password = FileClassUtility.getDataFromPropertyFile("password");
String browser = FileClassUtility.getDataFromPropertyFile("browser");
	
long longTimeOut=jutil.StringToLong(timeout);	
int randomnumber = jutil.getRandomNumber(1000);

String campaignname = ExcelclassFileUtility.getDataFromExcel("campaign", 2, 1)+randomnumber;
WebDriver driver=null;
switch (browser) {
case "chrome":
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	break;
	
case "firefox":
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
	break;
default: {
	System.out.println("please specifiy the browser");
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
}		
}
    SeleniumDriverUtility.navigateApp(url, driver);
    SeleniumDriverUtility.browsersetting(longTimeOut, driver);
LoginPage loginpage=new LoginPage(driver);
HomePage homepage=new HomePage(driver);
loginpage.loginActions(username, password);
homepage.clickCampaign(driver);
CampaignPage campaignpage=new CampaignPage(driver);
campaignpage.clickcraeteCampaign();
CreateNewCampaignPage createnewcampaignpage=new CreateNewCampaignPage(driver);
CampaignInformationPage campaigninformation=new CampaignInformationPage(driver);

createnewcampaignpage.enterCampaignName(campaignname);
createnewcampaignpage.saveCampaign();
jutil.assertionThroughifCondition(campaigninformation.getCampaignName(), campaignname,"campaign");
Thread.sleep(2000); 
homepage.signOut(driver);
Thread.sleep(2000);
	SeleniumDriverUtility.quitbrowser(driver);
}
}*/

//contacts



/*public static void main(String[] args) throws IOException, InterruptedException {
	JavaClassFileUtility jutil=new JavaClassFileUtility();	

	ExcelclassFileUtility.openExcel(IconstantClassPath.EXCELFILEPATH);
	FileClassUtility.openPropertyfile(IconstantClassPath.PROPERTYFILEPATH);
FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.Properties");
	Properties property = new Properties();
	property.load(fis);
	
	String url =FileClassUtility.getDataFromPropertyFile("url");
	String timeout = FileClassUtility.getDataFromPropertyFile("timeout");
	String username =FileClassUtility.getDataFromPropertyFile("username");
	String password = FileClassUtility.getDataFromPropertyFile("password");
	String browser = FileClassUtility.getDataFromPropertyFile("browser");
			
	
	long longTimeOut=jutil.StringToLong(timeout);	
	int randomnumber = jutil.getRandomNumber(1000);
	
	String contactfirstname = ExcelclassFileUtility.getDataFromExcel("Contacts", 2, 1)+randomnumber;
	String contactlastname = ExcelclassFileUtility.getDataFromExcel("Contacts", 2, 2)+randomnumber;
	
	WebDriver driver=null;
	switch (browser) {
	case "chrome":
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		break;
		
	case "firefox":
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		break;
	default: {
		System.out.println("please specifiy the browser");
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}		
	}
	  SeleniumDriverUtility.navigateApp(url, driver);
	    SeleniumDriverUtility.browsersetting(longTimeOut, driver);
	LoginPage loginpage=new LoginPage(driver);
    HomePage homepage=new HomePage(driver);
    loginpage.loginActions(username, password);
    homepage.clickOnContact();
	CreateNewContact createnewcontact=new CreateNewContact(driver);
	createnewcontact.clickOnCreateContact();
	ContactPage contactpagename=new ContactPage(driver);
	contactpagename.enterContactNameTxtName(contactlastname);
	contactpagename.savecontact();
	ContactInformationPage contcatinfo=new ContactInformationPage(driver);
	
	 jutil.assertionThroughifCondition(contcatinfo.getcontactName(),contactlastname,"Contact");

	  Thread.sleep(2000); 
	   homepage.signOut(driver);
	   Thread.sleep(2000);
			SeleniumDriverUtility.quitbrowser(driver);
*******************************************************************************	
/**	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
    SeleniumDriverUtility.navigateApp(url, driver);	
	SeleniumDriverUtility.browsersetting(longTimeOut, driver);

    driver.findElement(By.name("user_name")).sendKeys(username);
	 driver.findElement(By.name("user_password")).sendKeys(password);
	 driver.findElement(By.id("submitButton")).click();
	 
	 driver.findElement(By.linkText("Contacts")).click();
	 driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	 
	 driver.findElement(By.name("firstname")).sendKeys(contactfirstname);
	 driver.findElement(By.name("lastname")).sendKeys(contactlastname);
	 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	 WebElement Actualfirstname = driver.findElement(By.id("dtlview_First Name"));
	 WebElement Actualastname = driver.findElement(By.id("dtlview_First Name"));
	 
	/* if(Actualfirstname.getText().equalsIgnoreCase(firstname)&&Actualastname.getText().equalsIgnoreCase(lastname));
	 {
		System.out.println("contact created successfully");
		 System.out.println("TC pass");
	 }*/
	/* jutil.assertionThroughifCondition(Actualfirstname.getText(), contactfirstname, "Contact name is created");
	 jutil.assertionThroughifCondition(Actualastname.getText(), contactlastname, "Contacts name is created");
	
	 WebElement atoradminist = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	 SeleniumDriverUtility.mousehoverOntheElement(atoradminist, driver);
	 /** Actions act=new Actions(driver);
	 act.moveToElement(atoradminist).build().perform();*/
	/* driver.findElement(By.xpath("//a[.='Sign Out']"));
	 SeleniumDriverUtility.quitbrowser(driver);	*/




/*public static void main(String[] args) throws IOException, InterruptedException {
JavaClassFileUtility jutil=new JavaClassFileUtility();
ExcelclassFileUtility.openExcel(IconstantClassPath.EXCELFILEPATH);	
FileClassUtility.openPropertyfile(IconstantClassPath.PROPERTYFILEPATH);

String url =FileClassUtility.getDataFromPropertyFile("url");
String timeout = FileClassUtility.getDataFromPropertyFile("timeout");
String username =FileClassUtility.getDataFromPropertyFile("username");
String password = FileClassUtility.getDataFromPropertyFile("password");
String browser = FileClassUtility.getDataFromPropertyFile("browser");

long longTimeOut=jutil.StringToLong(timeout);	
int randomnumber = jutil.getRandomNumber(1000);

String organizationname = ExcelclassFileUtility.getDataFromExcel("Organization", 2, 1)+randomnumber;
String contactname = ExcelclassFileUtility.getDataFromExcel("Contacts", 2, 1)+randomnumber;

WebDriver driver=null;
switch (browser) {
case "chrome":
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	break;
	
case "firefox":
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
	break;
default: {
	System.out.println("please specifiy the browser");
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
}		
}
 SeleniumDriverUtility.navigateApp(url, driver);
    SeleniumDriverUtility.browsersetting(longTimeOut, driver);
LoginPage loginpage=new LoginPage(driver);
loginpage.loginActions(username, password);
HomePage homepage=new HomePage(driver);
homepage.clickOnOrganzations();
CreateNewOrganization createOrganization=new CreateNewOrganization(driver);
createOrganization.clickOnCreateOrganization();
OrganizationPage organizationPage=new OrganizationPage(driver);
organizationPage.enterOrganizationNameTxtName(organizationname);	
 organizationPage.saveOrganization();
 Thread.sleep(2000);
 homepage.clickOnContact();
	CreateNewContact createnewcontact=new CreateNewContact(driver);
	createnewcontact.clickOnCreateContact();
	ContactPage contactpagename=new ContactPage(driver);
	contactpagename.enterContactNameTxtName(contactname);
	ContactChildBrowser childBrowse=new ContactChildBrowser(driver);
	contactpagename.clickOnSelect();
	//childBrowse.sendDataTochildBrowser(organizationname);
	//childBrowse.searchDataTochildBrowser();
	//childBrowse.childBrowsetHandels(driver, contactname);
	SeleniumDriverUtility.switchToWindowBasedOnTitle(driver, organizationname);
	childBrowse.childBrowsetHandels(driver, organizationname);
	SeleniumDriverUtility.switchToWindowBasedOnTitle(driver, "Contacts");
    contactpagename.savecontact();
    
    ContactInformationPage contcatinfo=new ContactInformationPage(driver);
	
	 jutil.assertionThroughifCondition(contcatinfo.getcontactName(),contactname,"Contact");

	  Thread.sleep(2000); 
	   homepage.signOut(driver);
	   Thread.sleep(2000);
			SeleniumDriverUtility.quitbrowser(driver);
	

testcase
31

	
	/*public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
	
		
		JavaClassFileUtility jutil=new JavaClassFileUtility();
		ExcelclassFileUtility.openExcel(IconstantClassPath.EXCELFILEPATH);
		FileClassUtility.openPropertyfile(IconstantClassPath.PROPERTYFILEPATH);
		
		String url =FileClassUtility.getDataFromPropertyFile("url");
		String timeout = FileClassUtility.getDataFromPropertyFile("timeout");
		String username =FileClassUtility.getDataFromPropertyFile("username");
		String password = FileClassUtility.getDataFromPropertyFile("password");
		String browser = FileClassUtility.getDataFromPropertyFile("browser");
		String emailid = FileClassUtility.getDataFromPropertyFile("email");
		
		long longTimeOut=jutil.StringToLong(timeout);	
		int randomnumber = jutil.getRandomNumber(1000);
		
		String contactfirstname = ExcelclassFileUtility.getDataFromExcel("Contacts", 2, 1)+randomnumber;

		WebDriver driver=null;
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		default: {
			System.out.println("please specifiy the browser");
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}		
		}
		 SeleniumDriverUtility.navigateApp(url, driver);
		    SeleniumDriverUtility.browsersetting(longTimeOut, driver);
		LoginPage loginpage=new LoginPage(driver);
	    HomePage homepage=new HomePage(driver);
	    loginpage.loginActions(username, password);
	    ExcelclassFileUtility.setDataIntoExcel("Contacts", 9, 4, "home page is displayd");
		 ExcelclassFileUtility.setDataIntoExcel("Contacts", 9, 5, "Tc Pass");
	    homepage.clickOnContact();
		CreateNewContactPage createnewcontact=new CreateNewContactPage(driver);
		createnewcontact.clickOnCreateContact();
		 ExcelclassFileUtility.setDataIntoExcel("Contacts", 10, 4, "Contacts page is displayd");
		 ExcelclassFileUtility.setDataIntoExcel("Contacts", 10, 5, "Tc Pass");
		ContactPage contactpagename=new ContactPage(driver);
		contactpagename.enterContactNameTxtName(contactfirstname);
		contactpagename.enterContactNameEmailId(emailid);
		contactpagename.clickOnPortal();
		contactpagename.savecontact();
		ContactInformationPage contcatinfo=new ContactInformationPage(driver);
		
		 jutil.assertionThroughifCondition(contcatinfo.getcontactName(),contactfirstname,"Contact");
	
		  Thread.sleep(2000); 
		   homepage.signOut(driver);
		   Thread.sleep(2000);
				SeleniumDriverUtility.quitbrowser(driver);
		
		
		
		
		
		
		
		
		
		
		
		
       /* WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
		SeleniumDriverUtility.navigateApp(url, driver);
		SeleniumDriverUtility.browsersetting(longTimeOut, driver);
		
       driver.findElement(By.name("user_name")).sendKeys(username);
       driver.findElement(By.name("user_password")).sendKeys(password);
       driver.findElement(By.id("submitButton")).click();
       driver.findElement(By.xpath("//a[.='Contacts']")).click(); 
  	 driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
  	 driver.findElement(By.name("lastname")).sendKeys(contactfirstname);
  	 driver.findElement(By.xpath("//input[@id='email']")).sendKeys(emailid);
  	 driver.findElement(By.xpath("//input[@name='portal']")).click();
  	 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
  	 WebElement Actualastname = driver.findElement(By.id("dtlview_First Name"));
		
  	jutil.assertionThroughifCondition(Actualastname.getText(), contactfirstname, "Contact name is displayed");
	
  	 WebElement atoradminist = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	 Actions act=new Actions(driver);
	 act.moveToElement(atoradminist).build().perform();
	 driver.findElement(By.xpath("//a[.='Sign Out']"));
	 SeleniumDriverUtility.quitbrowser(driver);	*/
	


//32

/*public static void main(String[] args) throws IOException, InterruptedException {
	
	JavaClassFileUtility jutil=new JavaClassFileUtility();
	ExcelclassFileUtility.openExcel(IconstantClassPath.EXCELFILEPATH);
	FileClassUtility.openPropertyfile(IconstantClassPath.PROPERTYFILEPATH);
	
	String url =FileClassUtility.getDataFromPropertyFile("url");
	String timeout = FileClassUtility.getDataFromPropertyFile("timeout");
	String username =FileClassUtility.getDataFromPropertyFile("username");
	String password = FileClassUtility.getDataFromPropertyFile("password");
	String browser = FileClassUtility.getDataFromPropertyFile("browser");
	
	long longTimeOut=jutil.StringToLong(timeout);	
	int randomnumber = jutil.getRandomNumber(1000);
	
	String contactlasttname = ExcelclassFileUtility.getDataFromExcel("Contacts", 2, 1)+randomnumber;

	WebDriver driver=null;
	switch (browser) {
	case "chrome":
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		break;
		
	case "firefox":
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		break;
	default: {
		System.out.println("please specifiy the browser");
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}		
	}
	 SeleniumDriverUtility.navigateApp(url, driver);
	    SeleniumDriverUtility.browsersetting(longTimeOut, driver);
	LoginPage loginpage=new LoginPage(driver);
    HomePage homepage=new HomePage(driver);
    loginpage.loginActions(username, password);
    ExcelclassFileUtility.setDataIntoExcel("Contacts", 9, 4, "home page is displayd");
	 ExcelclassFileUtility.setDataIntoExcel("Contacts", 9, 5, "Tc Pass");
    homepage.clickOnContact();
	CreateNewContactPage createnewcontact=new CreateNewContactPage(driver);
	createnewcontact.clickOnCreateContact();
	 ExcelclassFileUtility.setDataIntoExcel("Contacts", 10, 4, "Contacts page is displayd");
	 ExcelclassFileUtility.setDataIntoExcel("Contacts", 10, 5, "Tc Pass");
	ContactPage contactpagename=new ContactPage(driver);
	contactpagename.enterContactNameTxtName(contactlasttname);
	//contactpagename.enterContactNameEmailId(emailid);
	//contactpagename.clickOnPortal();
	contactpagename.savecontact();
	ContactInformationPage contcatinfo=new ContactInformationPage(driver);
	
	 jutil.assertionThroughifCondition(contcatinfo.getcontactName(),contactlasttname,"Contact");

	  Thread.sleep(2000); 
	   homepage.signOut(driver);
	   Thread.sleep(2000);
			SeleniumDriverUtility.quitbrowser(driver);
	
	
	
	
	
	
	
	
	
	
   /* WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
	SeleniumDriverUtility.navigateApp(url, driver);
	SeleniumDriverUtility.browsersetting(longTimeOut, driver);
	
   driver.findElement(By.name("user_name")).sendKeys(username);
   driver.findElement(By.name("user_password")).sendKeys(password);
   driver.findElement(By.id("submitButton")).click();
   
   ExcelclassFileUtility.setDataIntoExcel("Contacts", 9, 4, "home page is displayd");
	   ExcelclassFileUtility.setDataIntoExcel("Contacts", 9, 5, "Tc Pass");
   
   driver.findElement(By.xpath("//a[.='Contacts']")).click(); 
   ExcelclassFileUtility.setDataIntoExcel("Contacts", 10, 4, "Contacts page is displayd");
	 ExcelclassFileUtility.setDataIntoExcel("Contacts", 10, 5, "Tc Pass");
	 
	   driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	  // ExcelclassFileUtility.setDataIntoExcel("Contacts", 11, 4, "create contact page is displayd");
	// ExcelclassFileUtility.setDataIntoExcel("Contacts", 11, 5, "Tc Pass");
	 
	   driver.findElement(By.name("lastname")).sendKeys(contactlasttname);
	   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	   
	  //ExcelclassFileUtility.setDataIntoExcel("Contacts", 12, 4, "contact name is displayd");
	// ExcelclassFileUtility.setDataIntoExcel("Contacts", 12, 5, "Tc Pass");
	   
	   WebElement Actualastname = driver.findElement(By.id("dtlview_First Name"));
	
	jutil.assertionThroughifCondition(Actualastname.getText(), contactlasttname, "Contact name is displayed");

	 WebElement atoradminist = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
 Actions act=new Actions(driver);
 act.moveToElement(atoradminist).build().perform();
 driver.findElement(By.xpath("//a[.='Sign Out']"));
 // ExcelclassFileUtility.setDataIntoExcel("Contacts", 13, 4, "login page is displayd");
	 //ExcelclassFileUtility.setDataIntoExcel("Contacts", 13, 5, "Tc Pass");
	
//ExcelclassFileUtility.closeExcel();
 SeleniumDriverUtility.quitbrowser(driver);	*/



//33

/*public static void main(String[] args) throws IOException, InterruptedException {
	
	JavaClassFileUtility jutil=new JavaClassFileUtility();
	ExcelclassFileUtility.openExcel(IconstantClassPath.EXCELFILEPATH);
	FileClassUtility.openPropertyfile(IconstantClassPath.PROPERTYFILEPATH);
	
	String url =FileClassUtility.getDataFromPropertyFile("url");
	String timeout = FileClassUtility.getDataFromPropertyFile("timeout");
	String username =FileClassUtility.getDataFromPropertyFile("username");
	String password = FileClassUtility.getDataFromPropertyFile("password");
	String browser = FileClassUtility.getDataFromPropertyFile("browser");
	
	long longTimeOut=jutil.StringToLong(timeout);	
	int randomnumber = jutil.getRandomNumber(1000);
	
	String contactlasttname = ExcelclassFileUtility.getDataFromExcel("Contacts", 2, 1)+randomnumber;

	WebDriver driver=null;
	switch (browser) {
	case "chrome":
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		break;
		
	case "firefox":
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		break;
	default: {
		System.out.println("please specifiy the browser");
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}		
	}
	 SeleniumDriverUtility.navigateApp(url, driver);
	    SeleniumDriverUtility.browsersetting(longTimeOut, driver);
	LoginPage loginpage=new LoginPage(driver);
    HomePage homepage=new HomePage(driver);
    loginpage.loginActions(username, password);
    ExcelclassFileUtility.setDataIntoExcel("Contacts", 9, 4, "home page is displayd");
	 ExcelclassFileUtility.setDataIntoExcel("Contacts", 9, 5, "Tc Pass");
    homepage.clickOnContact();
	CreateNewContactPage createnewcontact=new CreateNewContactPage(driver);
	createnewcontact.clickOnCreateContact();
	 ExcelclassFileUtility.setDataIntoExcel("Contacts", 10, 4, "Contacts page is displayd");
	 ExcelclassFileUtility.setDataIntoExcel("Contacts", 10, 5, "Tc Pass");
	ContactPage contactpagename=new ContactPage(driver);
	contactpagename.enterContactNameTxtName(contactlasttname);
	//contactpagename.enterContactNameEmailId(emailid);
	//contactpagename.clickOnPortal();
	contactpagename.savecontact();
	ContactInformationPage contcatinfo=new ContactInformationPage(driver);
	
	 jutil.assertionThroughifCondition(contcatinfo.getcontactName(),contactlasttname,"Contact");

	  Thread.sleep(2000); 
	   homepage.signOut(driver);
	   Thread.sleep(2000);
			SeleniumDriverUtility.quitbrowser(driver);
	
	
	
	
	
	
	
	
	
	
   /* WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
	SeleniumDriverUtility.navigateApp(url, driver);
	SeleniumDriverUtility.browsersetting(longTimeOut, driver);
	
   driver.findElement(By.name("user_name")).sendKeys(username);
   driver.findElement(By.name("user_password")).sendKeys(password);
   driver.findElement(By.id("submitButton")).click();
   
   ExcelclassFileUtility.setDataIntoExcel("Contacts", 9, 4, "home page is displayd");
	   ExcelclassFileUtility.setDataIntoExcel("Contacts", 9, 5, "Tc Pass");
   
   driver.findElement(By.xpath("//a[.='Contacts']")).click(); 
   ExcelclassFileUtility.setDataIntoExcel("Contacts", 10, 4, "Contacts page is displayd");
	 ExcelclassFileUtility.setDataIntoExcel("Contacts", 10, 5, "Tc Pass");
	 
	   driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	  // ExcelclassFileUtility.setDataIntoExcel("Contacts", 11, 4, "create contact page is displayd");
	// ExcelclassFileUtility.setDataIntoExcel("Contacts", 11, 5, "Tc Pass");
	 
	   driver.findElement(By.name("lastname")).sendKeys(contactlasttname);
	   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	   
	  //ExcelclassFileUtility.setDataIntoExcel("Contacts", 12, 4, "contact name is displayd");
	// ExcelclassFileUtility.setDataIntoExcel("Contacts", 12, 5, "Tc Pass");
	   
	   WebElement Actualastname = driver.findElement(By.id("dtlview_First Name"));
	
	jutil.assertionThroughifCondition(Actualastname.getText(), contactlasttname, "Contact name is displayed");

	 WebElement atoradminist = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
 Actions act=new Actions(driver);
 act.moveToElement(atoradminist).build().perform();
 driver.findElement(By.xpath("//a[.='Sign Out']"));
 // ExcelclassFileUtility.setDataIntoExcel("Contacts", 13, 4, "login page is displayd");
	 //ExcelclassFileUtility.setDataIntoExcel("Contacts", 13, 5, "Tc Pass");
	
//ExcelclassFileUtility.closeExcel();
 SeleniumDriverUtility.quitbrowser(driver);	*/


//34

/*public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
	
	JavaClassFileUtility jutil=new JavaClassFileUtility();
	ExcelclassFileUtility.openExcel(IconstantClassPath.EXCELFILEPATH);
	FileClassUtility.openPropertyfile(IconstantClassPath.PROPERTYFILEPATH);
	
	String url =FileClassUtility.getDataFromPropertyFile("url");
	String timeout = FileClassUtility.getDataFromPropertyFile("timeout");
	String username =FileClassUtility.getDataFromPropertyFile("username");
	String password = FileClassUtility.getDataFromPropertyFile("password");
	String browser = FileClassUtility.getDataFromPropertyFile("browser");
	
	long longTimeOut=jutil.StringToLong(timeout);	
	int randomnumber = jutil.getRandomNumber(1000);
	
	String contactlasttname = ExcelclassFileUtility.getDataFromExcel("Contacts", 2, 1)+randomnumber;
	String contactmodule1 = ExcelclassFileUtility.getDataFromExcel("Contacts", 2, 3);
	String contactfile = ExcelclassFileUtility.getDataFromExcel("Contacts", 4, 0);
	

	WebDriver driver=null;
	switch (browser) {
	case "chrome":
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		break;
		
	case "firefox":
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		break;
	default: {
		System.out.println("please specifiy the browser");
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}		
	}
	 SeleniumDriverUtility.navigateApp(url, driver);
	    SeleniumDriverUtility.browsersetting(longTimeOut, driver);
	LoginPage loginpage=new LoginPage(driver);
    HomePage homepage=new HomePage(driver);
    loginpage.loginActions(username, password);
    homepage.clickOnContact();
    CreateNewContactPage createContact=new CreateNewContactPage(driver);
    createContact.ClickOnMailTemplate();
    ContactMailMergeTemplatePage contactMail=new ContactMailMergeTemplatePage(driver);
    contactMail.clickFile(contactfile);
    Thread.sleep(2000);
    contactMail.clickDropDown();
	
    Thread.sleep(2000); 
	   homepage.signOut(driver);
	   Thread.sleep(2000);
			SeleniumDriverUtility.quitbrowser(driver);
	jutil.printStatement("contact is created");
	
	
	
	
	
	
	
	
	/*WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
	SeleniumDriverUtility.navigateApp(url, driver);
	SeleniumDriverUtility.browsersetting(longTimeOut, driver);
	
   driver.findElement(By.name("user_name")).sendKeys(username);
   driver.findElement(By.name("user_password")).sendKeys(password);
   driver.findElement(By.id("submitButton")).click();
   driver.findElement(By.xpath("//a[.='Contacts']")).click(); 
   driver.findElement(By.xpath("//a[.='Create Mail Merge templates ']")).click();
   driver.findElement(By.xpath("//input[@type='file']")).sendKeys(contactfile);
   driver.findElement(By.xpath("//select[@name='target_module']")).click();
   driver.findElement(By.xpath("//option[.='Organizations']")).click();
   driver.findElement(By.xpath("//input[@title='Save']")).click();
   
	 WebElement atoradminist = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	 Actions act=new Actions(driver);
	 act.moveToElement(atoradminist).build().perform();
	 driver.findElement(By.xpath("//a[.='Sign Out']"));
	 SeleniumDriverUtility.quitbrowser(driver);	*/

//35

/*public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
	
	JavaClassFileUtility jutil=new JavaClassFileUtility();

	ExcelclassFileUtility.openExcel(IconstantClassPath.EXCELFILEPATH);
	FileClassUtility.openPropertyfile(IconstantClassPath.PROPERTYFILEPATH);
	
	String url =FileClassUtility.getDataFromPropertyFile("url");
	String timeout = FileClassUtility.getDataFromPropertyFile("timeout");
	String username =FileClassUtility.getDataFromPropertyFile("username");
	String password = FileClassUtility.getDataFromPropertyFile("password");
	String browser = FileClassUtility.getDataFromPropertyFile("browser");
	
	long longTimeOut=jutil.StringToLong(timeout);	
	int randomnumber = jutil.getRandomNumber(1000);
	String contactlasttname = ExcelclassFileUtility.getDataFromExcel("Contacts", 2, 1)+randomnumber;
	String contactmodule1 = ExcelclassFileUtility.getDataFromExcel("Contacts", 2, 3);
	String contactfile = ExcelclassFileUtility.getDataFromExcel("Contacts", 4, 0);
	

	WebDriver driver=null;
	switch (browser) {
	case "chrome":
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		break;
		
	case "firefox":
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		break;
	default: {
		System.out.println("please specifiy the browser");
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}		
	}
	 SeleniumDriverUtility.navigateApp(url, driver);
	    SeleniumDriverUtility.browsersetting(longTimeOut, driver);
	LoginPage loginpage=new LoginPage(driver);
    HomePage homepage=new HomePage(driver);
    loginpage.loginActions(username, password);
    homepage.clickOnContact();
    CreateNewContactPage createContact=new CreateNewContactPage(driver);
    createContact.ClickOnMailTemplate();
    ContactMailMergeTemplatePage contactMail=new ContactMailMergeTemplatePage(driver);
    contactMail.clickFile(contactfile);
    Thread.sleep(2000);
    contactMail.clickDropDown();
	
    Thread.sleep(2000); 
	   homepage.signOut(driver);
	   Thread.sleep(2000);
			SeleniumDriverUtility.quitbrowser(driver);
	jutil.printStatement("contact is created");
	
	
		
	
	/*WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
	SeleniumDriverUtility.navigateApp(url, driver);
	SeleniumDriverUtility.browsersetting(longTimeOut, driver);
	
   driver.findElement(By.name("user_name")).sendKeys(username);
   driver.findElement(By.name("user_password")).sendKeys(password);
   driver.findElement(By.id("submitButton")).click();
   driver.findElement(By.xpath("//a[.='Contacts']")).click(); 
   driver.findElement(By.xpath("//a[.='Create Mail Merge templates ']")).click();
   driver.findElement(By.xpath("//input[@type='file']")).sendKeys(contactfile);
   driver.findElement(By.xpath("//select[@name='target_module']")).click();
   driver.findElement(By.xpath("//option[.='Organizations']")).click();
   driver.findElement(By.xpath("//input[@title='Save']")).click();
   
	 WebElement atoradminist = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	 Actions act=new Actions(driver);
	 act.moveToElement(atoradminist).build().perform();
	 driver.findElement(By.xpath("//a[.='Sign Out']"));
	 SeleniumDriverUtility.quitbrowser(driver);	*/


  /*  WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
	SeleniumDriverUtility.navigateApp(url, driver);
	SeleniumDriverUtility.browsersetting(longTimeOut, driver);
	
   driver.findElement(By.name("user_name")).sendKeys(username);
   driver.findElement(By.name("user_password")).sendKeys(password);
   driver.findElement(By.id("submitButton")).click();
   driver.findElement(By.xpath("//a[.='Contacts']")).click(); 
   driver.findElement(By.xpath("//a[.='Create Mail Merge templates ']")).click();
   driver.findElement(By.xpath("//select[@name='target_module']")).click();
   driver.findElement(By.xpath("//option[.='Organizations']")).click();
   driver.findElement(By.xpath("//input[@title='Save']")).click();
   
System.out.println("PopUp is displayed");

driver.switchTo().alert().accept();

WebElement atoradminist = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	 Actions act=new Actions(driver);
	 act.moveToElement(atoradminist).build().perform();
	 driver.findElement(By.xpath("//a[.='Sign Out']"));
	 SeleniumDriverUtility.quitbrowser(driver);	
}	
}*/




























/*WebDriverManager.chromedriver().setup();
driver=new ChromeDriver();
driver.findElement(By.name("user_name")).sendKeys(username);
driver.findElement(By.name("user_password")).sendKeys(password);
driver.findElement(By.id("submitButton")).click();
driver.findElement(By.xpath("//a[.='Organizations']")).click();

driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(organizationname);
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click(); 
Thread.sleep(3000);
driver.findElement(By.xpath("//a[.='Contacts']")).click();
driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
// String contactname="prajwalpraju231997";
driver.findElement(By.name("lastname")).sendKeys(contactname);
driver.findElement(By.xpath("//img[@title='Select']")).click();


String parentpage = driver.getWindowHandle();
Set<String> sessionId = driver.getWindowHandles();
for(String id:sessionId)
{
  driver.switchTo().window(id);
/*  if(driver.getTitle().contains("Accounts&action"));
  {
	  break;
  }
}
// String orgaoname="prajwal199723381";
driver.findElement(By.id("//input[@id='search_txt']")).sendKeys(organizationname);

driver.findElement(By.xpath("//input[@name='search']")).click();
driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();
driver.switchTo().parentFrame();
WebElement atoradminist = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
 Actions act=new Actions(driver);
 act.moveToElement(atoradminist).build().perform();
 driver.findElement(By.xpath("//a[.='Sign Out']"));
 driver.quit(); */

//3)document


/*public static void main(String[] args) throws IOException, AWTException, InterruptedException {
	JavaClassFileUtility jutil=new JavaClassFileUtility();

	ExcelclassFileUtility.openExcel(IconstantClassPath.EXCELFILEPATH);
	FileClassUtility.openPropertyfile(IconstantClassPath.PROPERTYFILEPATH);
	/*FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.Properties");
	Properties property=new Properties();
	property.load(fis);
	
	String url =FileClassUtility.getDataFromPropertyFile("url");
	String timeout = FileClassUtility.getDataFromPropertyFile("timeout");
	String username =FileClassUtility.getDataFromPropertyFile("username");
	String password = FileClassUtility.getDataFromPropertyFile("password");
	String browser = FileClassUtility.getDataFromPropertyFile("browser");
	String file = FileClassUtility.getDataFromPropertyFile("file");
	

	long longTimeOut=jutil.StringToLong(timeout);	
	int randomnumber = jutil.getRandomNumber(1000);
			
	String document = ExcelclassFileUtility.getDataFromExcel("document", 2, 1)+randomnumber;
	String documentpath =ExcelclassFileUtility.getDataFromExcel("document", 3, 1);
	String documentdescription =ExcelclassFileUtility.getDataFromExcel("document", 2, 2);
	
	WebDriver driver=null;
	switch (browser) {
	case "chrome":
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		break;
		
	case "firefox":
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		break;
	default: {
		System.out.println("please specifiy the browser");
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}		
	}
	  SeleniumDriverUtility.navigateApp(url, driver);
	    SeleniumDriverUtility.browsersetting(longTimeOut, driver);
	LoginPage loginpage=new LoginPage(driver);
    HomePage homepage=new HomePage(driver);
    loginpage.loginActions(username, password);
    homepage.clickOnDocument();
    CreateNewDocument createDocument=new CreateNewDocument(driver);
    createDocument.clickOnCreateDocument();
    DocumentPage documentName=new DocumentPage(driver);
    documentName.enterdocumentNameTxtName(document);
    driver.switchTo().frame(0);
    documentName.enterdocumentinfoTxt(documentdescription);
    driver.switchTo().defaultContent();
    documentName.clickOnBold();
    documentName.clickOnItalic();
    documentName.clickOnFiles(documentpath);
    documentName.saveDocument();
    DocumentInfoPage documentname=new DocumentInfoPage(driver);
    		
    
    jutil.assertionThroughifCondition(documentname.getDocumentName(),document ,"Document");
	   Thread.sleep(2000); 
	   homepage.signOut(driver);
	   Thread.sleep(2000);
			SeleniumDriverUtility.quitbrowser(driver);
		}
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
     SeleniumDriverUtility.navigateApp(url, driver);
	SeleniumDriverUtility.browsersetting(longTimeOut, driver);
			
	 driver.findElement(By.name("user_name")).sendKeys(username);
	 driver.findElement(By.name("user_password")).sendKeys(password);
	 driver.findElement(By.id("submitButton")).click();
	
	 driver.findElement(By.xpath("//a[.='Documents']")).click();
	 driver.findElement(By.xpath("//img[@title='Create Document...']")).click();
	 driver.findElement(By.xpath("//input[@name='notes_title']")).sendKeys(document);
	Thread.sleep(2000);
	driver.switchTo().frame(0);
	driver.findElement(By.xpath("//body[@class='cke_show_borders']")).sendKeys(documentdescription,Keys.CONTROL+"a");
	driver.switchTo().defaultContent();
	driver.findElement(By.xpath("//a[@title='Bold']")).click();
	driver.findElement(By.xpath("//a[@title='Italic']")).click();
    Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@id='filename_I__']")).sendKeys(documentpath);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	WebElement documenttitlename = driver.findElement(By.xpath("//td[@id='mouseArea_Title']"));
	/*if(documenttitlename.getText().equalsIgnoreCase(document));
	{
		jutil.printStatement("document name is created");
		jutil.printStatement("TC pass");
	
	
	jutil.assertionThroughifCondition(documenttitlename.getText(), document, "Document name is created");
	
	
	 WebElement atoradminist = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	 SeleniumDriverUtility.mousehoverOntheElement(atoradminist, driver);
	 driver.findElement(By.xpath("//a[.='Sign Out']"));
	 SeleniumDriverUtility.quitbrowser(driver);*/
	 
	
	

//4)organization

/*	public static void main(String[] args) throws IOException, InterruptedException {
	
	JavaClassFileUtility jutil=new JavaClassFileUtility();
	ExcelclassFileUtility.openExcel(IconstantClassPath.EXCELFILEPATH);
	FileClassUtility.openPropertyfile(IconstantClassPath.PROPERTYFILEPATH);
	
	String url =FileClassUtility.getDataFromPropertyFile("url");
	String timeout = FileClassUtility.getDataFromPropertyFile("timeout");
	String username =FileClassUtility.getDataFromPropertyFile("username");
	String password = FileClassUtility.getDataFromPropertyFile("password");
	String browser = FileClassUtility.getDataFromPropertyFile("browser");
	String industryname = FileClassUtility.getDataFromPropertyFile("industryname");
	String typename = FileClassUtility.getDataFromPropertyFile("typename");
	
	long longTimeOut=jutil.StringToLong(timeout);	
	int randomnumber = jutil.getRandomNumber(1000);	

	String organizationname = ExcelclassFileUtility.getDataFromExcel("Organization", 2, 1)+randomnumber;
	
	WebDriver driver=null;
	switch (browser) {
	case "chrome":
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		break;
		
	case "firefox":
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		break;
	default: {
		System.out.println("please specifiy the browser");
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}		
	}
	  SeleniumDriverUtility.navigateApp(url, driver);
	    SeleniumDriverUtility.browsersetting(longTimeOut, driver);
	LoginPage loginpage=new LoginPage(driver);
    HomePage homepage=new HomePage(driver);
    loginpage.loginActions(username, password);
	homepage.clickOnOrganzations();
	CreateNewOrganization createOrganization=new CreateNewOrganization(driver);
	createOrganization.clickOnCreateOrganization();
	OrganizationPage organizationPage=new OrganizationPage(driver);
	organizationPage.enterOrganizationNameTxtName(organizationname);		
    organizationPage.oganizationDropDownIndustry(industryname);
    organizationPage.oganizationDropDownType(typename);
    organizationPage.saveOrganization();
    OrganizationInfoPage orgoInfo=new OrganizationInfoPage(driver);	
    
    jutil.assertionThroughifCondition(orgoInfo.getOrganizationName(), organizationname,"Organization");
    homepage.signOut(driver);
 		SeleniumDriverUtility.quitbrowser(driver);
 	}
	
	
	
	
	
	
	
	
	
	
	
/***	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
    SeleniumDriverUtility.navigateApp(url, driver);
	SeleniumDriverUtility.browsersetting(longTimeOut, driver);
	
	 driver.findElement(By.name("user_name")).sendKeys(username);
	 driver.findElement(By.name("user_password")).sendKeys(password);
	 driver.findElement(By.id("submitButton")).click();
	 driver.findElement(By.xpath("//a[.='Organizations']")).click();
	 driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	 driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(organizationname);
	WebElement industry = driver.findElement(By.xpath("//select[@name='industry']")); 
	WebElement type = driver.findElement(By.xpath("//select[@name='accounttype']"));
	Select s=new Select(industry);
	 s.selectByValue(industryname);
	  s=new Select(type);
	 s.selectByValue(typename);
	 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
 WebElement organaization = driver.findElement(By.xpath("//td[@id='mouseArea_Organization Name']"));
	/*if(organaization.getText().equalsIgnoreCase(organizationname));
	{
		jutil.printStatement("Organization name is created");
		jutil.printStatement("TC pass");
 jutil.assertionThroughifCondition(organaization.getText(), organizationname, "Organization name is created");
	 WebElement atoradminist = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	 SeleniumDriverUtility.mousehoverOntheElement(atoradminist, driver);
	 driver.findElement(By.xpath("//a[.='Sign Out']"));
	 SeleniumDriverUtility.quitbrowser(driver);	 	**/



/*public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {



JavaClassFileUtility jutil=new JavaClassFileUtility();
ExcelclassFileUtility.openExcel(IconstantClassPath.EXCELFILEPATH);
FileClassUtility.openPropertyfile(IconstantClassPath.PROPERTYFILEPATH);

String url =FileClassUtility.getDataFromPropertyFile("url");
String timeout = FileClassUtility.getDataFromPropertyFile("timeout");
String username =FileClassUtility.getDataFromPropertyFile("username");
String password = FileClassUtility.getDataFromPropertyFile("password");
String browser = FileClassUtility.getDataFromPropertyFile("browser");


long longTimeOut=jutil.StringToLong(timeout);
int randomnumber = jutil.getRandomNumber(1000);
String organizationname = ExcelclassFileUtility.getDataFromExcel("Organization", 2, 1)+randomnumber;

WebDriver driver=null;
switch (browser) {
case "chrome":
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	break;
	
case "firefox":
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
	break;
default: {
	System.out.println("please specifiy the browser");
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
}		
}
  SeleniumDriverUtility.navigateApp(url, driver);
    SeleniumDriverUtility.browsersetting(longTimeOut, driver);
LoginPage loginpage=new LoginPage(driver);
 loginpage.loginActions(username, password);
HomePage hompepage=new HomePage(driver);
hompepage.clickOnOrganzations();
CreateNewOrganization createOrganization=new CreateNewOrganization(driver);
createOrganization.clickOnCreateOrganization();
OrganizationPage organizationPage=new OrganizationPage(driver);
organizationPage.enterOrganizationNameTxtName(organizationname);
  organizationPage.saveOrganization();
    OrganizationInfoPage orgoInfo=new OrganizationInfoPage(driver);
    		
    jutil.assertionThroughifCondition(orgoInfo.getOrganizationName(), organizationname,"Organization");	
	
    Thread.sleep(2000); 
    hompepage.signOut(driver);
    Thread.sleep(2000);
 		SeleniumDriverUtility.quitbrowser(driver);
 	}
   }





/** WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("http://localhost:8888");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
driver.findElement(By.xpath("//input[@type='submit']")).click();
driver.findElement(By.xpath("//a[.='Organizations']")).click();
driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(organizationname);
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
WebElement organization = driver.findElement(By.xpath("//td[@id='mouseArea_Organization Name']"));

/* boolean p = ele.isDisplayed();

if(p)
{
 System.out.println("Element is displayed");
}
else
{
 System.out.println("Element is not displayed");
}
jutil.assertionThroughifCondition(organization.getText(), organizationname, "Organization name is created");
WebElement organization1=  driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
SeleniumDriverUtility.mousehoverOntheElement(organization1, driver);
driver.findElement(By.xpath("//a[.='Sign Out']"));
SeleniumDriverUtility.quitbrowser(driver);

/* Actions act=new Actions(driver);
act.moveToElement(ele1).build().perform();
ele1.click();*/



//5)product
/*public static void main(String[] args) throws IOException, InterruptedException
{
	JavaClassFileUtility jutil=new JavaClassFileUtility();

	ExcelclassFileUtility.openExcel(IconstantClassPath.EXCELFILEPATH);
	FileClassUtility.openPropertyfile(IconstantClassPath.PROPERTYFILEPATH);
			
	String url =FileClassUtility.getDataFromPropertyFile("url");
	String timeout = FileClassUtility.getDataFromPropertyFile("timeout");
	String username =FileClassUtility.getDataFromPropertyFile("username");
	String password = FileClassUtility.getDataFromPropertyFile("password");
	String browser = FileClassUtility.getDataFromPropertyFile("browser");
	
	long longTimeOut=jutil.StringToLong(timeout);	
	int randomnumber = jutil.getRandomNumber(1000);

	String productname = ExcelclassFileUtility.getDataFromExcel("Products", 2, 1)+randomnumber;
    
	WebDriver driver=null;
	switch (browser) {
	case "chrome":
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		break;
		
	case "firefox":
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		break;
	default: {
		System.out.println("please specifiy the browser");
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}		
	}
	  SeleniumDriverUtility.navigateApp(url, driver);
	    SeleniumDriverUtility.browsersetting(longTimeOut, driver);
	LoginPage loginpage=new LoginPage(driver);
    HomePage homepage=new HomePage(driver);
    loginpage.loginActions(username, password);
    homepage.clickOnProduct();
    CreateNewProduct createProduct=new CreateNewProduct(driver);
    createProduct.clickOnProductContact();
    ProductPage productPageDetails=new ProductPage(driver);
    productPageDetails.enterProductNameTxtName(productname);
    productPageDetails.saveProduct();
    ProductInfoPage productInfo=new ProductInfoPage(driver);
    
    jutil.assertionThroughifCondition(productInfo.getProductName(), productname,"Product");
   
    Thread.sleep(2000);
    homepage.signOut(driver);
 		SeleniumDriverUtility.quitbrowser(driver);
 	}
}
	
	
	
	
	
	
	
	/**WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	SeleniumDriverUtility.navigateApp(url, driver);
	SeleniumDriverUtility.browsersetting(longTimeOut, driver);
	
	driver.findElement(By.name("user_name")).sendKeys(username);
	 driver.findElement(By.name("user_password")).sendKeys(password);
	 driver.findElement(By.id("submitButton")).click();
	 driver.findElement(By.xpath("//a[.='Products']")).click();
	 driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
	 //String productname = "prajwal234";
	 driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(productname);
	 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	 WebElement product1 = driver.findElement(By.xpath("//td[@id='mouseArea_Product Name']"));
	 
	 jutil.assertionThroughifCondition(product1.getText(), productname, "Product name is created");
	/* if(product1.getText().equalsIgnoreCase(productname));
		{
			jutil.printStatement("Product name is created");
			jutil.printStatement("TC pass");
		
			
 WebElement atoradminist = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
 SeleniumDriverUtility.mousehoverOntheElement(atoradminist, driver);
 driver.findElement(By.xpath("//a[.='Sign Out']"));
 SeleniumDriverUtility.quitbrowser(driver);	 
}
}*/
