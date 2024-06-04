package PageObject;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

import BaseClass.BaseBrowser;

public class FilterPage extends BaseBrowser {
	@Test
	public static void filter() throws IOException, InterruptedException {
		// To read the locators file
		FileReader file = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\Locators\\FilterPageLocators.properties");
		Properties readLoc = new Properties();
		readLoc.load(file);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
		
		WebElement AllFilter = driver.findElement(By.xpath(readLoc.getProperty("AllFilter")));
		wait.until(ExpectedConditions.elementToBeClickable(AllFilter)).click();
		
		WebElement filterPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(readLoc.getProperty("filterPopup"))));
		WebElement scroller = filterPopup.findElement(By.xpath(readLoc.getProperty("scroller")));
		
		WebElement Price = scroller.findElement(By.id(readLoc.getProperty("Price")));
		wait.until(ExpectedConditions.elementToBeClickable(Price)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(readLoc.getProperty("Options"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(readLoc.getProperty("minValue")))).sendKeys("500");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(readLoc.getProperty("maxValue")))).sendKeys("1000");
        
		WebElement Conditions = scroller.findElement(By.id(readLoc.getProperty("Conditions")));
		wait.until(ExpectedConditions.elementToBeClickable(Conditions)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(readLoc.getProperty("Options"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(readLoc.getProperty("fieldSet"))));
		WebElement temp1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(readLoc.getProperty("subPanel1"))));
		WebElement temp2 = temp1.findElement(By.id(readLoc.getProperty("subPanel2")));
		WebElement temp3 = temp2.findElement(By.xpath(readLoc.getProperty("subField")));
		WebElement temp4 = temp3.findElement(By.xpath(readLoc.getProperty("Checkbox")));
		temp4.findElement(By.xpath(readLoc.getProperty("CheckboxSubmit"))).click();
		
		WebElement Location = scroller.findElement(By.id(readLoc.getProperty("Location")));
		wait.until(ExpectedConditions.elementToBeClickable(Location)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(readLoc.getProperty("Options"))));
		WebElement temp5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(readLoc.getProperty("usOnly"))));
		WebElement temp6 = temp5.findElement(By.xpath(readLoc.getProperty("subField")));
		temp6.findElement(By.xpath(readLoc.getProperty("usOnlyOption"))).click();
		
		
		String count = driver.findElement(By.xpath(readLoc.getProperty("count"))).getText();
		String name = driver.findElement(By.id(readLoc.getProperty("name"))).getText();
		
		// Expected values
		String expectedCount = "(3) Filter(s) selected";
		String expectedName = "$500 - $1000NewUS Only";		
		driver.findElement(By.xpath(readLoc.getProperty("submit"))).click();
		
		Assert.assertEquals(count, expectedCount);
		Assert.assertEquals(name, expectedName);
	}
}
