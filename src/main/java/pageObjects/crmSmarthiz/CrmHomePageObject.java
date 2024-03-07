package pageObjects.crmSmarthiz;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.crmSmarthiz.CrmHomePageUI;

public class CrmHomePageObject extends BasePage {
	WebDriver driver;

	public CrmHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isEmailAddressDisplayed() {
		waitForElementUndisplayed(driver, CrmHomePageUI.GLOBAL_LOADING);
		waitForElementVisible(driver, CrmHomePageUI.ACCOUNT_NAME);
		return isElementDisplayed(driver, CrmHomePageUI.ACCOUNT_NAME);
	}

	public void clickToExpandSidebar() {
		waitForElementClickable(driver, CrmHomePageUI.SIDEBAR_EXPAND_BUTTON);
		clickToElementByJS(driver, CrmHomePageUI.SIDEBAR_EXPAND_BUTTON);
	}

	public CrmGTKHPageObject openGTKHSideMenu() {
		waitForElementClickable(driver, CrmHomePageUI.SIDEBAR_GTKH_LINK);
		clickToElement(driver, CrmHomePageUI.SIDEBAR_GTKH_LINK);
		return CrmPageGeneratorManager.getGTKHPage(driver);
	}

	public CrmGTKHFacebookTestPageObject openCrmTestPage() {
		waitForElementClickable(driver, CrmHomePageUI.SIDEBAR_CRM_TESTPAGE_LINK);
		clickToElement(driver, CrmHomePageUI.SIDEBAR_CRM_TESTPAGE_LINK);
		return CrmPageGeneratorManager.getGTKHTestPage(driver);
	}

}
