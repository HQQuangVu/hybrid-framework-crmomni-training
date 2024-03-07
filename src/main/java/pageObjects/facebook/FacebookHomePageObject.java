package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.GlobalConstants;
import pageObjects.crmSmarthiz.CrmLoginPageObject;
import pageObjects.crmSmarthiz.CrmPageGeneratorManager;
import pageUIs.facebook.FacebookHomePageUI;

public class FacebookHomePageObject extends BasePage {
	WebDriver driver;

	public FacebookHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterFacebookEmailPasswordThenLogin(String facebookEmail, String facebookPassword) {
		waitForElementVisible(driver, FacebookHomePageUI.LOGIN_EMAIL);
		sendkeyToElement(driver, FacebookHomePageUI.LOGIN_EMAIL, facebookEmail);

		waitForElementVisible(driver, FacebookHomePageUI.LOGIN_PASSWORD);
		sendkeyToElement(driver, FacebookHomePageUI.LOGIN_PASSWORD, facebookPassword);

		waitForElementClickable(driver, FacebookHomePageUI.LOGIN_BUTTON);
		clickToElement(driver, FacebookHomePageUI.LOGIN_BUTTON);
	}

	public boolean isMessageButtonIsDisplayed() {
		waitForElementVisible(driver, FacebookHomePageUI.MESSAGE_BUTTON);
		return isElementDisplayed(driver, FacebookHomePageUI.MESSAGE_BUTTON);
	}

	public void clickToMessageButton() {
		waitForElementClickable(driver, FacebookHomePageUI.MESSAGE_BUTTON);
		clickToElement(driver, FacebookHomePageUI.MESSAGE_BUTTON);
	}

	public void inputToMessageField(String facebookMessage) {
		waitForElementVisible(driver, FacebookHomePageUI.MESSAGE_TEXTBOX);
		sendkeyToElement(driver, FacebookHomePageUI.MESSAGE_TEXTBOX, facebookMessage);
	}

	public void clickToSendMessageButton() {
		waitForElementClickable(driver, FacebookHomePageUI.MESSAGE_SEND_BUTTON);
		clickToElement(driver, FacebookHomePageUI.MESSAGE_SEND_BUTTON);
	}

	public String getMessageTestText() {
		waitForElementVisible(driver, FacebookHomePageUI.MESSAGE_SEND_TEXT);
		return getElementText(driver, FacebookHomePageUI.MESSAGE_SEND_TEXT);
	}

	public CrmLoginPageObject openCrmLoginPage() {
		openPageUrl(driver, GlobalConstants.CRM_PAGE_PORTAL_URL);
		return CrmPageGeneratorManager.getLoginPage(driver);
	}

	public String isFacebookMessageDisplayed(String messageText) {
		waitForElementVisible(driver, FacebookHomePageUI.DYNAMIC_MESSAGE_TEXT, messageText);
		return getElementText(driver, FacebookHomePageUI.DYNAMIC_MESSAGE_TEXT, messageText);
	}

}
