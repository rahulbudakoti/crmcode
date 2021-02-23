package qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.base.BaseClass;

public class HomePage extends BaseClass {

	@FindBy(xpath="//span[contains(text(),'Rahul Budakoti')]")
	WebElement user;
	
	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[1]/div[1]/a[1]")
	WebElement hover;
	
	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[1]/div[3]/a[1]/i[1]")
	WebElement contactlink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateusername() throws InterruptedException {	
		Thread.sleep(5000);
		System.out.println("username is-->"+user.getText());
		return user.getText();
	}
	
	public ContactPage contactlink()
	{
		Actions action=new Actions(driver);
		action.moveToElement(hover).build().perform();
		contactlink.click();
		
		return new ContactPage();
	}
}
