package qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import qa.util.WebEventListener;

public class BaseClass {

			public static WebDriver driver;
			public static Properties prop;
            public  static EventFiringWebDriver e_driver;
	        public static WebEventListener eventListener;
			public static WebDriverWait wait;
			// before all test cases
			public BaseClass() {

			try{
			  prop = new Properties();	
				FileInputStream fis = new FileInputStream(
							System.getProperty("user.dir") + "\\src\\main\\java\\config\\config.properties");
					prop.load(fis);
	 	     }
			catch(FileNotFoundException e){e.printStackTrace();}
			catch(IOException e){e.printStackTrace();}
				}

public static void initialize() {
	
	String browser=prop.getProperty("browser");
	if (browser.equals("chrome")) {
		 WebDriverManager.chromedriver().setup();
	     driver = new ChromeDriver();

	// e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
	//	eventListener = new WebEventListener();
		//e_driver.register(eventListener);
		//driver = e_driver;
		
		
	    driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
}

