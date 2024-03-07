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
import pageObjects.crmSmarthiz.CrmUserInforPageObject;

public class TC_26_Update_User_Infor extends BaseTest {
	private WebDriver driver;
	private CrmLoginPageObject crmLoginPage;
	private CrmHomePageObject crmHomePage;
	private CrmGTKHFacebookTestPageObject crmGTKHFacebookTestPage;
	private CrmUserInforPageObject crmUserInforPage;
	private String crmEmail, crmPassword, crmUserName, crmPhoneNumber;
	private String diachiTP, diachiQH, diachiPX;

	@Parameters({ "browser", "crmUrl" })
	@BeforeClass
	public void beforeClass(String browserName, String crmUrl) {
		driver = getBrowserDriver(browserName, crmUrl);
		crmLoginPage = CrmPageGeneratorManager.getLoginPage(driver);
		crmEmail = GlobalConstants.CRM_ACCOUNT_NAME;
		crmPassword = GlobalConstants.CRM_ACCOUNT_PASSWORD;

		crmUserName = GlobalConstants.CRM_USERNAME;
		crmPhoneNumber = GlobalConstants.CRM_PHONE_NUMBER;

		diachiTP = "Hà Nội ";
		diachiQH = "Thanh Xuân ";
		diachiPX = "Khương Trung";

		log.info("Pre-Condition: Login To Crm Home Page");
		crmHomePage = crmLoginPage.inputToEmailPasswordAndLogin(crmEmail, crmPassword);
		verifyTrue(crmHomePage.isEmailAddressDisplayed());
	}

	@Test
	public void TC_26_Update_User_Infor_Address() {

		log.info("Update User Address 01: Expand Sidemenu");
		crmHomePage.clickToExpandSidebar();

		log.info("Update User Address 02: Open Crm TestPage");
		crmGTKHFacebookTestPage = crmHomePage.openCrmTestPage();

		log.info("Update User Address 03: Verify GTKH TestPage");
		verifyEquals(crmGTKHFacebookTestPage.getTestPageText(), "CRM Test Page");

		log.info("Update User Address 04: Click to Search button in User infor");
		crmGTKHFacebookTestPage.clickToSearchButtonUserInfor();

		log.info("Update User Address 05: Input userPhoneNumber to PhoneNumber field");
		crmGTKHFacebookTestPage.inputPhoneNumberToRequiredField(crmPhoneNumber);

		log.info("Update User Address 06: Verify Username Displayed");
		verifyTrue(crmGTKHFacebookTestPage.isUsernameDisplayedInforField(crmUserName));

		log.info("Update User Address 07: Click to Username ");
		crmGTKHFacebookTestPage.clickToUsernameInInforSearch(crmUserName);

		log.info("Update User Address 08: Click to Edit button and open User Infor page");
		crmUserInforPage = crmGTKHFacebookTestPage.clickToEditInforButtonAndOpenUserInforPage();

		log.info("Update User Address 09: Verify Panel Title ' Thông tin CRM '");
		verifyTrue(crmUserInforPage.isPanelTitleDisplayed());

		log.info("Update User Address 10: Click to Add User Address");
		crmUserInforPage.clickToAddUserAddress();

		log.info("Update User Address 11: Verify Form name 'Địa chỉ khách hàng'");
		verifyTrue(crmUserInforPage.isUserAddressFormDisplayer());

		log.info("Update User Address 12: Select 'diachiTP' in dropdown");
		crmUserInforPage.selectDiachiTPInAddressForm(diachiTP);

		log.info("Update User Address 13: Select 'diachiQH' in dropdown");
		crmUserInforPage.selectDiachiQHInAddressForm(diachiQH);

		log.info("Update User Address 14: Select 'diachiPX' in dropdown");
		crmUserInforPage.selectDiachiPXInAddressForm(diachiPX);

		log.info("Update User Address 15: Click to 'Lưu' button '");
		crmUserInforPage.clickToSaveButtonInInforForm();

		log.info("Update User Address 16: Verify 'Hồ sơ khách hàng đã được cập nhật.' message displayed]'");
		crmUserInforPage.isHSKHDuocCapNhatMessageDisplayed();

		log.info("Update User Address 17: Click to 'Xóa' button '");
		crmUserInforPage.clickToDeleteButtonInAddressField();

		log.info("Update User Address 18: Verify 'Hồ sơ khách hàng đã được cập nhật.' message displayed]'");
		crmUserInforPage.isHSKHDuocCapNhatMessageDisplayed();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
