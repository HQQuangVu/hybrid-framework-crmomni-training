package pageObjects.crmSmarthiz;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.crmSmarthiz.CrmLoginPageUI;

public class CrmLoginPageObject extends BasePage {
	WebDriver driver;

	public CrmLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public CrmHomePageObject inputToEmailPasswordAndLogin(String crmEmail, String crmPassword) {

		waitForElementUndisplayed(driver, CrmLoginPageUI.LOADING_TEXT);
		waitForElementVisible(driver, CrmLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, CrmLoginPageUI.EMAIL_TEXTBOX, crmEmail);

		waitForElementVisible(driver, CrmLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, CrmLoginPageUI.PASSWORD_TEXTBOX, crmPassword);

		waitForElementClickable(driver, CrmLoginPageUI.LOGIN_BUTTON);
		clickToElementByJS(driver, CrmLoginPageUI.LOGIN_BUTTON);
		return CrmPageGeneratorManager.getHomePage(driver);
	}

}
