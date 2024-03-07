package com.omni.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.crmSmarthiz.CrmGTKHFacebookTestPageObject;
import pageObjects.crmSmarthiz.CrmHomePageObject;
import pageObjects.crmSmarthiz.CrmLoginPageObject;
import pageObjects.facebook.FacebookHomePageObject;
import pageObjects.facebook.FacebookPageGeneratorManager;

public class TC_07_08_09_10_User_Facebook_NhanTin extends BaseTest {
	private WebDriver driver;
	private FacebookHomePageObject fbHomePage;
	private CrmLoginPageObject crmLoginPage;
	private CrmHomePageObject crmHomePage;
	private CrmGTKHFacebookTestPageObject crmGTKHFacebookTestPage;
	private String crmEmail, crmPassword;
	private String facebookEmail, facebookPassword, facebookMessage;
	private String facebookUsername;

	@Parameters({ "browser", "facebookUrl" })
	@BeforeClass
	public void beforeClass(String browserName, String facebookUrl) {
		driver = getBrowserDriver(browserName, facebookUrl);
		fbHomePage = FacebookPageGeneratorManager.getHomePage(driver);

		facebookEmail = GlobalConstants.FACEBOOK_USER_EMAIL;
		facebookPassword = GlobalConstants.FACEBOOK_USER_PASSWORD;
		facebookUsername = GlobalConstants.FACEBOOK_USER_NAME;
		facebookMessage = "Test Message";

		crmEmail = GlobalConstants.CRM_ACCOUNT_NAME;
		crmPassword = GlobalConstants.CRM_ACCOUNT_PASSWORD;

		log.info("Pre-Condition: Open And Login To Facebook Test Page successfully");
		fbHomePage.enterFacebookEmailPasswordThenLogin(facebookEmail, facebookPassword);
		verifyTrue(fbHomePage.isMessageButtonIsDisplayed());
	}

	@Test
	public void TC_07_08_09_10_Nhan_Tin_Facebook() {

		log.info("FB Nhan Tin 01 : Click to Message button");
		fbHomePage.clickToMessageButton();

		log.info("FB Nhan Tin 02 : Input 'facebookMessage' to Message field");
		fbHomePage.inputToMessageField(facebookMessage);

		log.info("FB Nhan Tin 03 : Click to Send message button");
		fbHomePage.clickToSendMessageButton();

		log.info("FB Nhan Tin 04 : Verify 'facebookMessage' sent successfully");
		verifyEquals(fbHomePage.getMessageTestText(), facebookMessage);

		log.info("FB Nhan Tin 05 : Open Crm LoginPage");
		crmLoginPage = fbHomePage.openCrmLoginPage();

		log.info("FB Nhan Tin 06 : Verify Login to HomePage successfully");
		crmHomePage = crmLoginPage.inputToEmailPasswordAndLogin(crmEmail, crmPassword);
		verifyTrue(crmHomePage.isEmailAddressDisplayed());

		log.info("FB Nhan Tin 07: Expand Sidemenu and Open Crm TestPage");
		crmHomePage.clickToExpandSidebar();
		crmGTKHFacebookTestPage = crmHomePage.openCrmTestPage();

		log.info("FB Nhan Tin 08: Verify GTKH TestPage Tin nhắn");
		verifyEquals(crmGTKHFacebookTestPage.getTinNhanText(), "Tin nhắn");

		log.info("FB Nhan Tin 09: Input and Submit to Search field");
		crmGTKHFacebookTestPage.inputToSearchField(facebookUsername);

		log.info("FB Nhan Tin 10: Verify Facebook Username");
		verifyEquals(crmGTKHFacebookTestPage.getSearchUsernameText(), facebookUsername);

		log.info("FB Nhan Tin 11: Open Facebook User Message");
		crmGTKHFacebookTestPage.openFacebookUserMessage();

		log.info("FB Nhan Tin 12: Verify 'facebookMessage' Text");
		verifyTrue(crmGTKHFacebookTestPage.isTestPageMessageDisplayed(facebookMessage));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
