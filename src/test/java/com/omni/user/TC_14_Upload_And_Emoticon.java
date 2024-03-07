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

public class TC_14_Upload_And_Emoticon extends BaseTest {
	private WebDriver driver;
	private CrmLoginPageObject crmLoginPage;
	private CrmHomePageObject crmHomePage;
	private CrmGTKHFacebookTestPageObject crmGTKHFacebookTestPage;
	private String crmEmail, crmPassword;
	private String facebookUsername;
	private String uploadFailFileName, uploadSuccessFileName;

	@Parameters({ "browser", "crmUrl" })
	@BeforeClass
	public void beforeClass(String browserName, String crmUrl) {
		driver = getBrowserDriver(browserName, crmUrl);
		crmLoginPage = CrmPageGeneratorManager.getLoginPage(driver);
		crmEmail = GlobalConstants.CRM_ACCOUNT_NAME;
		crmPassword = GlobalConstants.CRM_ACCOUNT_PASSWORD;

		facebookUsername = GlobalConstants.FACEBOOK_USER_NAME;
		uploadFailFileName = "Fail25MB.jpg";
		uploadSuccessFileName = "Success25MB.jpg";
		log.info("Pre-Condition: Login To Crm Home Page");
		crmHomePage = crmLoginPage.inputToEmailPasswordAndLogin(crmEmail, crmPassword);
		verifyTrue(crmHomePage.isEmailAddressDisplayed());
	}

	@Test
	public void TC_14_Upload_Fail() {

		log.info("FB Upload Fail 01: Expand Sidemenu and Open Crm TestPage");
		crmHomePage.clickToExpandSidebar();
		crmGTKHFacebookTestPage = crmHomePage.openCrmTestPage();

		log.info("FB Upload Fail 02: Verify GTKH TestPage Tin nhắn");
		verifyEquals(crmGTKHFacebookTestPage.getTinNhanText(), "Tin nhắn");

		log.info("FB Upload Fail 03: Input and Submit to Search field");
		crmGTKHFacebookTestPage.inputToSearchField(facebookUsername);

		log.info("FB Upload Fail 04: Verify Facebook Username");
		verifyEquals(crmGTKHFacebookTestPage.getSearchUsernameText(), facebookUsername);

		log.info("FB Upload Fail 05: Open Facebook User Message");
		crmGTKHFacebookTestPage.openFacebookUserMessage();

		log.info("FB Upload Fail 06: Upload File to User");
		crmGTKHFacebookTestPage.uploadFileToUser(driver, uploadFailFileName);

		log.info("FB Upload Fail 07: Verify upload error message is displayed");
		verifyTrue(crmGTKHFacebookTestPage.isUploadErrorMessageDisplayed());

		log.info("FB Upload Fail 08: Close error message");
		crmGTKHFacebookTestPage.clickToCloseButton();

	}

	@Test
	public void TC_14_Upload_Success() {

		log.info("FB Upload Success 01: Upload File to User >> Not Verified<<");
		crmGTKHFacebookTestPage.uploadFileToUser(driver, uploadSuccessFileName);

		log.info("FB Upload Success 02: Verify uploadImage Displayed");
		verifyTrue(crmGTKHFacebookTestPage.isUploadImageDisplayed());

	}

	@Test
	public void TC_14_Send_Emoticon() {

		log.info("Crm Send Emot 01: Click on emoticon button");
		crmGTKHFacebookTestPage.clickOnEmoticonButton();

		log.info("Crm Send Emot 02: Click on Lovely-emot");
		crmGTKHFacebookTestPage.clickOnLovelyEmot();

		log.info("Crm Send Emot 03: Verify sending emot successfully");
		verifyTrue(crmGTKHFacebookTestPage.isEmotSentSuccessfully());

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
