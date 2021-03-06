package io.github.madhank93.automating_internet_app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ContextMenu {

	WebDriver driver;
	static final String CHROME_DRIVER_PATH = System.getProperty("user.dir") + "/drivers/chromedriver";

	@BeforeTest
	public void initialSetup() {
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/context_menu");
	}

	@AfterTest
	public void quit() {
		driver.quit();
	}

	@Test
	public void performMouseRightClick() {
		WebElement selectArea = driver.findElement(By.xpath("//div[@id='hot-spot']"));

		// Mouse actions using Actions class
		Actions action = new Actions(driver);
		action.contextClick(selectArea);
		action.build().perform();

		String popupMessage = driver.switchTo().alert().getText();
		Assert.assertEquals(popupMessage, "You selected a context menu");
	}
}
