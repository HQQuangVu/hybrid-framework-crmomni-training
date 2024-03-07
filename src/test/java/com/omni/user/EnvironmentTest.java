package com.omni.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EnvironmentTest extends BaseTest {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01() {
		driver.get("https://www.google.com/");
		sleepInSecond(3);
		WebElement searchTextarea = driver.findElement(By.xpath("//textarea[@title='Tìm kiếm']"));
		sleepInSecond(3);
		searchTextarea.sendKeys("automation HQ");

		driver.get("https://www.facebook.com/");
	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
