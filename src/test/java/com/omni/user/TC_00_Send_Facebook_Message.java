package com.omni.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.facebook.FacebookHomePageObject;
import pageObjects.facebook.FacebookPageGeneratorManager;

public class TC_00_Send_Facebook_Message extends BaseTest {
	private WebDriver driver;
	private FacebookHomePageObject fbHomePage;
	private String facebookEmail, facebookPassword, facebookMessage;

	@Parameters({ "browser", "facebookUrl" })
	@BeforeClass
	public void beforeClass(String browserName, String facebookUrl) {
		driver = getBrowserDriver(browserName, facebookUrl);
		fbHomePage = FacebookPageGeneratorManager.getHomePage(driver);

		facebookEmail = GlobalConstants.FACEBOOK_USER_EMAIL;
		facebookPassword = GlobalConstants.FACEBOOK_USER_PASSWORD;
		facebookMessage = "Test Message";

		log.info("Pre-Condition: Open And Login To Facebook Test Page successfully");
		fbHomePage.enterFacebookEmailPasswordThenLogin(facebookEmail, facebookPassword);
		verifyTrue(fbHomePage.isMessageButtonIsDisplayed());
	}

	@Test
	public void TC_00_Send_Facebook_Message_Success() {

		log.info("FB Nhan Tin 01 : Click to Message button");
		fbHomePage.clickToMessageButton();

		log.info("FB Nhan Tin 02 : Input 'facebookMessage' to Message field");
		fbHomePage.inputToMessageField(facebookMessage);

		log.info("FB Nhan Tin 03 : Click to Send message button");
		fbHomePage.clickToSendMessageButton();

		log.info("FB Nhan Tin 04 : Verify 'facebookMessage' sent successfully");
		verifyEquals(fbHomePage.getMessageTestText(), facebookMessage);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
