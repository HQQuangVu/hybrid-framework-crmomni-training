package pageObjects.crmSmarthiz;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.crmSmarthiz.CrmGTKHPageUI;

public class CrmGTKHPageObject extends BasePage {
	WebDriver driver;

	public CrmGTKHPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getGTKHText() {
		waitForElementVisible(driver, CrmGTKHPageUI.GTKH_TEXT);
		return getElementText(driver, CrmGTKHPageUI.GTKH_TEXT);
	}

	public CrmGTKHFacebookPageObject openFacebookPage() {
		waitForElementClickable(driver, CrmGTKHPageUI.GTKH_FACEBOOK_LINK);
		clickToElement(driver, CrmGTKHPageUI.GTKH_FACEBOOK_LINK);
		return CrmPageGeneratorManager.getGTKHFacebookPage(driver);
	}

	public void expandGTKHMenu() {
		waitForElementClickable(driver, CrmGTKHPageUI.GTKH_TEXT);
		clickToElement(driver, CrmGTKHPageUI.GTKH_TEXT);
	}

}
