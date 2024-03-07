package com.omni.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.crmSmarthiz.CrmGTKHFacebookPageObject;
import pageObjects.crmSmarthiz.CrmGTKHFacebookTestPageObject;
import pageObjects.crmSmarthiz.CrmGTKHPageObject;
import pageObjects.crmSmarthiz.CrmHomePageObject;
import pageObjects.crmSmarthiz.CrmLoginPageObject;
import pageObjects.crmSmarthiz.CrmPageGeneratorManager;

public class TC_05_06_UI_GiaoTiepKhachHang extends BaseTest {
	private WebDriver driver;
	private CrmLoginPageObject crmLoginPage;
	private CrmHomePageObject crmHomePage;
	private CrmGTKHPageObject crmGTHKPage;
	private CrmGTKHFacebookPageObject crmGTKHFacebookPage;
	private CrmGTKHFacebookTestPageObject crmGTKHFacebookTestPage;
	private String crmEmail, crmPassword;

	@Parameters({ "browser", "crmUrl" })
	@BeforeClass
	public void beforeClass(String browserName, String crmUrl) {
		driver = getBrowserDriver(browserName, crmUrl);
		crmLoginPage = CrmPageGeneratorManager.getLoginPage(driver);
		crmEmail = GlobalConstants.CRM_ACCOUNT_NAME;
		crmPassword = GlobalConstants.CRM_ACCOUNT_PASSWORD;
		log.info("Pre-Condition: Login To Crm Home Page");
		crmHomePage = crmLoginPage.inputToEmailPasswordAndLogin(crmEmail, crmPassword);
		verifyTrue(crmHomePage.isEmailAddressDisplayed());
	}

	@Test
	public void TC_05_Verify_Sidemenu_GTKH() {

		log.info("GTKH 01: Expand Sidemenu");
		crmHomePage.clickToExpandSidebar();

		log.info("GTKH 02: Open GTKH Sidemenu");
		crmGTHKPage = crmHomePage.openGTKHSideMenu();

		log.info("GTKH 03: Verify Sidemenu's text");
		verifyEquals(crmGTHKPage.getGTKHText(), "Giao tiếp khách hàng");
	}

	@Test
	public void TC_06_Verify_Sidemenu_GTKH_Facebook() {

		log.info("GTKH TestPage 01: Expand GTKH Sidemenu");
		crmGTHKPage.expandGTKHMenu();

		log.info("GTKH TestPage 02: Open GTKH Facebook Sidemenu");
		crmGTKHFacebookPage = crmGTHKPage.openFacebookPage();

		log.info("GTKH TestPage 03: Verify GTKH Facebook Sidemenu");
		verifyEquals(crmGTKHFacebookPage.getGTKHFacebookText(), "Facebook");

		log.info("GTKH TestPage 04: Expand GTKH Facebook Sidemenu");
		crmGTKHFacebookPage.expandGTKHFacebookMenu();

		log.info("GTKH TestPage 04: Open GTKH TestPage Sidemenu");
		crmGTKHFacebookTestPage = crmGTKHFacebookPage.openGTKHFacebookTestPage();

		log.info("GTKH TestPage 05: Verify GTKH TestPage Sidemenu");
		verifyEquals(crmGTKHFacebookTestPage.getTestPageText(), "CRM Test Page");

		log.info("GTKH TestPage 06: Verify GTKH TestPage Tin nhắn");
		verifyEquals(crmGTKHFacebookTestPage.getTinNhanText(), "Tin nhắn");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
