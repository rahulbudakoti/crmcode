package qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.base.BaseClass;
import qa.pages.LoginPage;

public class LoginPageTest extends BaseClass {
	
	LoginPage loginpage;

	public LoginPageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialize();
		loginpage= new LoginPage();
	}
	
	@Test
	public void logintest() {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void titletest() 
	{
		String title = loginpage.validatetitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
			@AfterMethod
	public void teardown() throws InterruptedException {
				
				Thread.sleep(6000);
				driver.quit();
	}
}
