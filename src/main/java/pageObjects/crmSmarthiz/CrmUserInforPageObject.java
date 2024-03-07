package pageObjects.crmSmarthiz;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.crmSmarthiz.CrmUserInforPageUI;

public class CrmUserInforPageObject extends BasePage {
	WebDriver driver;

	public CrmUserInforPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPanelTitleDisplayed() {
		waitForElementVisible(driver, CrmUserInforPageUI.INFOR_PANEL_TITLE);
		return isElementDisplayed(driver, CrmUserInforPageUI.INFOR_PANEL_TITLE);
	}

	public void clickToAddUserAddress() {
		waitForElementClickable(driver, CrmUserInforPageUI.INFOR_ADD_ADDRESS_BUTTON);
		clickToElement(driver, CrmUserInforPageUI.INFOR_ADD_ADDRESS_BUTTON);
	}

	public boolean isUserAddressFormDisplayer() {
		waitForElementVisible(driver, CrmUserInforPageUI.FORM_ADDRESS_NAME);
		return isElementDisplayed(driver, CrmUserInforPageUI.FORM_ADDRESS_NAME);
	}

	public void selectDiachiTPInAddressForm(String diachiTP) {
		waitForElementClickable(driver, CrmUserInforPageUI.FORM_ADDRESS_NAME);
		clickToElement(driver, CrmUserInforPageUI.FORM_ADDRESS_NAME);
		selectItemInDefaultDropdown(driver, CrmUserInforPageUI.FORM_ADDRESS_NAME, diachiTP);
	}

	public void selectDiachiQHInAddressForm(String diachiQH) {
		waitForElementClickable(driver, CrmUserInforPageUI.FORM_ADDRESS_NAME);
		clickToElement(driver, CrmUserInforPageUI.FORM_ADDRESS_NAME);
		selectItemInDefaultDropdown(driver, CrmUserInforPageUI.FORM_ADDRESS_NAME, diachiQH);
	}

	public void selectDiachiPXInAddressForm(String diachiPX) {
		waitForElementClickable(driver, CrmUserInforPageUI.FORM_SUB_DISTRICT);
		clickToElement(driver, CrmUserInforPageUI.FORM_SUB_DISTRICT);
		selectItemInDefaultDropdown(driver, CrmUserInforPageUI.FORM_SUB_DISTRICT, diachiPX);
	}

	public void clickToSaveButtonInInforForm() {
		waitForElementClickable(driver, CrmUserInforPageUI.FORM_ADDRESS_NAME);
		clickToElement(driver, CrmUserInforPageUI.FORM_ADDRESS_NAME);
	}

	public boolean isHSKHDuocCapNhatMessageDisplayed() {
		waitForElementVisible(driver, CrmUserInforPageUI.HSKH_UPDATE_MESSAGE);
		return isElementDisplayed(driver, CrmUserInforPageUI.HSKH_UPDATE_MESSAGE);
	}

	public void clickToDeleteButtonInAddressField() {
		waitForElementClickable(driver, CrmUserInforPageUI.INFOR_ADDRESS_DELETE_BUTTON);
		clickToElement(driver, CrmUserInforPageUI.INFOR_ADDRESS_DELETE_BUTTON);
	}

}
