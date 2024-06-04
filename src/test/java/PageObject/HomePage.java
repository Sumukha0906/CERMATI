package PageObject;

import static org.testng.Assert.assertTrue;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import BaseClass.BaseBrowser;

public class HomePage extends BaseBrowser{
	static Properties readLoc = new Properties();
	static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	public static void homePageSenero1() throws IOException {
		driver.manage().window().maximize();
		FileReader file = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\Locators\\HomePageLocators.properties");

		//To read the locators file
		readLoc.load(file);
		
		Actions action = new Actions(driver);
		
		action.moveToElement(driver.findElement(By.xpath(readLoc.getProperty("Electronics")))).perform();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(readLoc.getProperty("SmartAcce"))))).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(readLoc.getProperty("SmartCell"))))).click();
	
	}
	public static void homePageSenerio2() throws IOException {
		driver.manage().window().maximize();
		//To read the locators file
		FileReader file = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\Locators\\HomePageLocators.properties");
		readLoc.load(file);

		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(readLoc.getProperty("Search"))))).sendKeys("Macbook");;
		Select catagory = new Select(driver.findElement(By.id(readLoc.getProperty("Catagory"))));
		catagory.selectByVisibleText(" Computers/Tablets & Networking");
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(readLoc.getProperty("Submit"))))).click();;
		
		
		List<WebElement> spans = driver.findElements(By.tagName("span"));
		boolean isWordFound = false;
		for (WebElement span : spans) {
            if (span.getText().contains("Macbook")) {
                isWordFound = true;
                break;
            }
        }		
        assertTrue(isWordFound, "The word '" + "Macbook" + "' should be present in one of the <span> elements.");

	}
}
