package pageObjects.crmSmarthiz;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.crmSmarthiz.CrmGTKHFacebookPageUI;

public class CrmGTKHFacebookPageObject extends BasePage {
	WebDriver driver;

	public CrmGTKHFacebookPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getGTKHFacebookText() {
		waitForElementVisible(driver, CrmGTKHFacebookPageUI.GTKH_FACEBOOK_TEXT);
		return getElementText(driver, CrmGTKHFacebookPageUI.GTKH_FACEBOOK_TEXT);
	}

	public void expandGTKHFacebookMenu() {
		waitForElementClickable(driver, CrmGTKHFacebookPageUI.GTKH_FACEBOOK_TEXT);
		clickToElement(driver, CrmGTKHFacebookPageUI.GTKH_FACEBOOK_TEXT);
	}

	public CrmGTKHFacebookTestPageObject openGTKHFacebookTestPage() {
		waitForElementClickable(driver, CrmGTKHFacebookPageUI.GTKH_TEST_PAGE_LINK);
		clickToElement(driver, CrmGTKHFacebookPageUI.GTKH_TEST_PAGE_LINK);
		return CrmPageGeneratorManager.getGTKHTestPage(driver);
	}

}
