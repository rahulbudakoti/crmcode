package qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.base.BaseClass;

public class ContactPage extends BaseClass {

	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/a[1]/button[1]")
	WebElement adduser;
	
	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement firstname;
	
	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[1]/div[2]/div[1]/div[1]/input[1]")
	WebElement lastname;
	
	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/button[2]")
	WebElement savebutton;
	
	
	public ContactPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void adduser(String fname, String lname){	
		adduser.click();
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		savebutton.click();
	}
}
