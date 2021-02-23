package qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.base.BaseClass;

public class LoginPage extends BaseClass {
 
	
	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement username;
	
	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/input[1]")
	WebElement password;
	
	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[1]/form[1]/div[1]/div[3]")
	WebElement loginbutton;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validatetitle() {
		return driver.getTitle();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbutton.click();
		
		return new HomePage();
	}
	
}
