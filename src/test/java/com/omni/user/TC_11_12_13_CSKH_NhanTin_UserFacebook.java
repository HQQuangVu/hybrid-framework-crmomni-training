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
import pageObjects.crmSmarthiz.CrmPageGeneratorManager;
import pageObjects.facebook.FacebookHomePageObject;

public class TC_11_12_13_CSKH_NhanTin_UserFacebook extends BaseTest {
	private WebDriver driver;
	private CrmLoginPageObject crmLoginPage;
	private CrmHomePageObject crmHomePage;
	private CrmGTKHFacebookTestPageObject crmGTKHFacebookTestPage;
	private FacebookHomePageObject fbHomePage;
	private String crmEmail, crmPassword;
	private String facebookEmail, facebookPassword, crmReplyMessage, crmReplyTextareaText;
	private String facebookUsername;

	@Parameters({ "browser", "crmUrl" })
	@BeforeClass
	public void beforeClass(String browserName, String crmUrl) {
		driver = getBrowserDriver(browserName, crmUrl);
		crmLoginPage = CrmPageGeneratorManager.getLoginPage(driver);
		crmEmail = GlobalConstants.CRM_ACCOUNT_NAME;
		crmPassword = GlobalConstants.CRM_ACCOUNT_PASSWORD;

		facebookEmail = GlobalConstants.FACEBOOK_USER_EMAIL;
		facebookPassword = GlobalConstants.FACEBOOK_USER_PASSWORD;
		facebookUsername = GlobalConstants.FACEBOOK_USER_NAME;

		crmReplyTextareaText = "Nhập tin nhắn...";
		crmReplyMessage = "Test Reply message";
		log.info("Pre-Condition: Login To Crm Home Page");
		crmHomePage = crmLoginPage.inputToEmailPasswordAndLogin(crmEmail, crmPassword);
		verifyTrue(crmHomePage.isEmailAddressDisplayed());
	}

	@Test
	public void TC_11_Verify_Name_CSKH() {

		log.info("FB Nhan Tin 01: Expand Sidemenu and Open Crm TestPage");
		crmHomePage.clickToExpandSidebar();
		crmGTKHFacebookTestPage = crmHomePage.openCrmTestPage();

		log.info("FB Nhan Tin 02: Verify GTKH TestPage Tin nhắn");
		verifyEquals(crmGTKHFacebookTestPage.getTinNhanText(), "Tin nhắn");

		log.info("FB Nhan Tin 03: Input and Submit to Search field");
		crmGTKHFacebookTestPage.inputToSearchField(facebookUsername);

		log.info("FB Nhan Tin 04: Verify Facebook Username");
		verifyEquals(crmGTKHFacebookTestPage.getSearchUsernameText(), facebookUsername);

		log.info("FB Nhan Tin 05: Open Facebook User Message");
		crmGTKHFacebookTestPage.openFacebookUserMessage();

		log.info("FB Nhan Tin 06: Verify Reply Textarea text");
		verifyEquals(crmGTKHFacebookTestPage.getReplyTextareaText(), crmReplyTextareaText);

	}

	@Test
	public void TC_12_13_Verify_Crm_Message_Text_And_Time() {

		log.info("Crm Reply 01: Send Test message to User");
		crmGTKHFacebookTestPage.sendTestMessageToUser(crmReplyMessage);

		log.info("Crm Reply 02: Verify 'crmReplyMessage' text is displayed");
		verifyTrue(crmGTKHFacebookTestPage.isTestPageMessageDisplayed(crmReplyMessage));

		log.info("Crm Reply 03: Verify Timestamp Displayed by Username");
		verifyTrue(crmGTKHFacebookTestPage.isTimestampDisplayedByName(facebookUsername));

		log.info("Crm Reply 04: Open Facebook TestPage");
		fbHomePage = crmGTKHFacebookTestPage.openFacebookTestPage(driver);

		log.info("Crm Reply 05: Login To Facebook Test Page successfully");
		fbHomePage.enterFacebookEmailPasswordThenLogin(facebookEmail, facebookPassword);
		verifyTrue(fbHomePage.isMessageButtonIsDisplayed());

		log.info("Crm Reply 06 : Click to Message button");
		fbHomePage.clickToMessageButton();

		log.info("Crm Reply 07 : Verify Reply message is displayed in Facebook Message");
		fbHomePage.isFacebookMessageDisplayed(crmReplyMessage);

	}

	@Test
	public void TC_13_Verify_Message_Timestamp() {

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
