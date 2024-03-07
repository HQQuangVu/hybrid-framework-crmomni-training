package pageObjects.crmSmarthiz;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.GlobalConstants;
import pageUIs.crmSmarthiz.CrmGTKHFacebookTestPageUI;

public class CrmGTKHFacebookTestPageObject extends BasePage {
	WebDriver driver;

	public CrmGTKHFacebookTestPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getTestPageText() {
		waitForElementVisible(driver, CrmGTKHFacebookTestPageUI.TESTPAGE_TEXT);
		return getElementText(driver, CrmGTKHFacebookTestPageUI.TESTPAGE_TEXT);
	}

	public String getTinNhanText() {
		waitForElementVisible(driver, CrmGTKHFacebookTestPageUI.TESTPAGE_TINNHAN_TEXT);
		return getElementText(driver, CrmGTKHFacebookTestPageUI.TESTPAGE_TINNHAN_TEXT);
	}

	public void inputToSearchField(String facebookUsername) {
		waitForElementVisible(driver, CrmGTKHFacebookTestPageUI.TESTPAGE_SEARCH_FACEBOOK);
		sendkeyToElement(driver, CrmGTKHFacebookTestPageUI.TESTPAGE_SEARCH_FACEBOOK, facebookUsername);
		submitElement(driver, CrmGTKHFacebookTestPageUI.TESTPAGE_SEARCH_FACEBOOK);
	}

	public String getSearchUsernameText() {
		waitForElementVisible(driver, CrmGTKHFacebookTestPageUI.TESTPAGE_SEARCH_USERNAME);
		return getElementText(driver, CrmGTKHFacebookTestPageUI.TESTPAGE_SEARCH_USERNAME);
	}

	public void openFacebookUserMessage() {
		waitForElementVisible(driver, CrmGTKHFacebookTestPageUI.TESTPAGE_SEARCH_USERNAME);
		clickToElement(driver, CrmGTKHFacebookTestPageUI.TESTPAGE_SEARCH_USERNAME);
	}

	public boolean isTestPageMessageDisplayed(String testMessage) {
		waitForElementVisible(driver, CrmGTKHFacebookTestPageUI.DYNAMIC_TESTPAGE_FACEBOOK_MESSAGE, testMessage);
		return isElementDisplayed(driver, CrmGTKHFacebookTestPageUI.DYNAMIC_TESTPAGE_FACEBOOK_MESSAGE, testMessage);
	}

	public void sendTestMessageToUser(String crmMessage) {
		waitForElementVisible(driver, CrmGTKHFacebookTestPageUI.TESTPAGE_CRM_TEXTAREA);
		sendkeyToElement(driver, CrmGTKHFacebookTestPageUI.TESTPAGE_CRM_TEXTAREA, crmMessage);

		waitForElementClickable(driver, CrmGTKHFacebookTestPageUI.TESTPAGE_CRM_TEXTAREA_SENDBUTTON);
		clickToElement(driver, CrmGTKHFacebookTestPageUI.TESTPAGE_CRM_TEXTAREA_SENDBUTTON);
	}

	public String getReplyTextareaText() {
		waitForElementVisible(driver, CrmGTKHFacebookTestPageUI.TESTPAGE_CRM_TEXTAREA);
		return getElementText(driver, CrmGTKHFacebookTestPageUI.TESTPAGE_CRM_TEXTAREA);
	}

	public boolean isTimestampDisplayedByName(String userName) {
		waitForElementVisible(driver, CrmGTKHFacebookTestPageUI.DYNAMIC_TESTPAGE_TIME_BY_USERNAME, userName);
		return isElementDisplayed(driver, CrmGTKHFacebookTestPageUI.DYNAMIC_TESTPAGE_TIME_BY_USERNAME, userName);
	}

	public void uploadFileToUser(WebDriver driver, String... fileNames) {
		String filePath = GlobalConstants.UPLOAD_FILE;
		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		getWebElement(driver, CrmGTKHFacebookTestPageUI.UPLOAD_FILE).sendKeys(fullFileName);
	}

	public boolean isUploadErrorMessageDisplayed() {
		waitForElementVisible(driver, CrmGTKHFacebookTestPageUI.UPLOAD_FAILED_MESSAGE);
		return isElementDisplayed(driver, CrmGTKHFacebookTestPageUI.UPLOAD_FAILED_MESSAGE);
	}

	public void clickToCloseButton() {
		waitForElementVisible(driver, CrmGTKHFacebookTestPageUI.UPLOAD_FAILED_CLOSE_BUTTON);
		clickToElement(driver, CrmGTKHFacebookTestPageUI.UPLOAD_FAILED_CLOSE_BUTTON);
	}

	public void clickOnEmoticonButton() {
		waitForElementVisible(driver, CrmGTKHFacebookTestPageUI.EMOTICON_BUTTON);
		clickToElement(driver, CrmGTKHFacebookTestPageUI.EMOTICON_BUTTON);
	}

	public void clickOnLovelyEmot() {
		waitForElementVisible(driver, CrmGTKHFacebookTestPageUI.EMOTICON_LOVELY2);
		clickToElement(driver, CrmGTKHFacebookTestPageUI.EMOTICON_LOVELY2);
	}

	public boolean isEmotSentSuccessfully() {
		waitForElementVisible(driver, CrmGTKHFacebookTestPageUI.EMOTICON_SENT_IN_CHAT);
		return isElementDisplayed(driver, CrmGTKHFacebookTestPageUI.EMOTICON_SENT_IN_CHAT);
	}

	public boolean isUploadImageDisplayed() {
		waitForElementVisible(driver, CrmGTKHFacebookTestPageUI.UPLOAD_IMAGE_DISPLAY);
		return isImageLoaded(driver, CrmGTKHFacebookTestPageUI.UPLOAD_IMAGE_DISPLAY);
	}

	public void clickToSearchButtonUserInfor() {
		waitForElementClickable(driver, CrmGTKHFacebookTestPageUI.INFOR_SEARCH_BUTTON);
		clickToElement(driver, CrmGTKHFacebookTestPageUI.INFOR_SEARCH_BUTTON);
	}

	public void inputPhoneNumberToRequiredField(String phoneNumber) {
		waitForElementVisible(driver, CrmGTKHFacebookTestPageUI.INFOR_PHONE_FIELD);
		sendkeyToElement(driver, CrmGTKHFacebookTestPageUI.INFOR_PHONE_FIELD, phoneNumber);
	}

	public boolean isUsernameDisplayedInforField(String userName) {
		waitForElementVisible(driver, CrmGTKHFacebookTestPageUI.INFOR_USERNAME, userName);
		return isElementDisplayed(driver, CrmGTKHFacebookTestPageUI.INFOR_USERNAME, userName);
	}

	public void clickToUsernameInInforSearch(String userName) {
		waitForElementVisible(driver, CrmGTKHFacebookTestPageUI.INFOR_USERNAME, userName);
		clickToElement(driver, CrmGTKHFacebookTestPageUI.INFOR_USERNAME, userName);
	}

	public CrmUserInforPageObject clickToEditInforButtonAndOpenUserInforPage() {
		waitForElementClickable(driver, getReplyTextareaText());
		clickToElement(driver, getReplyTextareaText());
		return CrmPageGeneratorManager.getUserInforPage(driver);
	}

}
