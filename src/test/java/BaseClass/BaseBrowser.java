package BaseClass;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseBrowser {
	

	public static Properties prop = new Properties();
	public static FileReader file;
	public static WebDriver driver;
	
	
	//Method to setUp the driver
	@BeforeMethod
	public static void setUp() throws IOException {
		
		//At the firs time when if the driver isn't inititlisied then it will get inititialted 
		if(driver==null) {
			file = new FileReader(System.getProperty("user.dir")+"//src//test//resources//ConfigFiles//Base.properties");
			prop.load(file);
		}
		
		//inititlise the browser to chrome browser 
		if(prop.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(prop.getProperty("URL"));
		}
		else if(prop.getProperty("Browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(prop.getProperty("URL"));
		}
		else if(prop.getProperty("Browser").equalsIgnoreCase("egde")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get(prop.getProperty("URL"));
		}
	}
	
	//Method to close the drive
	@AfterMethod
	public static void  terminate() {
		driver.quit();
	}
	
}
