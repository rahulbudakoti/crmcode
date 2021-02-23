package qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.BaseClass;
import qa.pages.HomePage;
import qa.pages.LoginPage;

public class HomePageTest extends BaseClass {
	LoginPage loginpage;
	HomePage homepage;

	public HomePageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialize();
		loginpage= new LoginPage();
		homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void userhometest() throws InterruptedException 
	{
		String userhome = homepage.validateusername();
		Assert.assertEquals(userhome, "Rahul Budakoti");
	}
	@Test()
	public void calanderlinktest()
	{
		homepage.contactlink();
	}
	
			@AfterMethod
	public void teardown() throws InterruptedException {
				
				Thread.sleep(6000);
				driver.quit();
	}
}
