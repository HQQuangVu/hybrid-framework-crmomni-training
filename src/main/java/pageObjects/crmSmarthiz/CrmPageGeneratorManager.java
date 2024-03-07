package pageObjects.crmSmarthiz;

import org.openqa.selenium.WebDriver;

public class CrmPageGeneratorManager {

	public static CrmLoginPageObject getLoginPage(WebDriver driver) {
		return new CrmLoginPageObject(driver);
	}

	public static CrmHomePageObject getHomePage(WebDriver driver) {
		return new CrmHomePageObject(driver);
	}

	public static CrmGTKHPageObject getGTKHPage(WebDriver driver) {
		return new CrmGTKHPageObject(driver);
	}

	public static CrmGTKHFacebookPageObject getGTKHFacebookPage(WebDriver driver) {
		return new CrmGTKHFacebookPageObject(driver);
	}

	public static CrmGTKHFacebookTestPageObject getGTKHTestPage(WebDriver driver) {
		return new CrmGTKHFacebookTestPageObject(driver);
	}

	public static CrmUserInforPageObject getUserInforPage(WebDriver driver) {
		return new CrmUserInforPageObject(driver);
	}

}
