package qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import qa.base.BaseClass;
import qa.pages.ContactPage;
import qa.pages.HomePage;
import qa.pages.LoginPage;
import qa.util.TestUtil;

public class ContactPageTest extends BaseClass {
	LoginPage loginpage;
	HomePage homepage;
	ContactPage contactpage;
	TestUtil util;
	
	String sheetname="contact";

	public ContactPageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialize();
		contactpage= new ContactPage();
		loginpage= new LoginPage();
		homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@DataProvider
	public Object[][] getcontactdata() {
		Object data [][]= TestUtil.getTestData(sheetname);
		return data;
	}
	
	@Test(dataProvider="getcontactdata")
	public void addinguser(String finame, String laname) throws InterruptedException
	{
		homepage.contactlink();
		Thread.sleep(5000);
	contactpage.adduser(finame, laname);
	}
		
			@AfterMethod
	public void teardown() throws InterruptedException {
				
				Thread.sleep(6000);
				driver.quit();
	}
}

