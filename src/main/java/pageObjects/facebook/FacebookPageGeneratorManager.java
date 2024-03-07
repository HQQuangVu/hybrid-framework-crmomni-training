package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

public class FacebookPageGeneratorManager {

	public static FacebookHomePageObject getHomePage(WebDriver driver) {
		return new FacebookHomePageObject(driver);
	}

}
