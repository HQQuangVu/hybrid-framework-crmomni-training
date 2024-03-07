package pageUIs.facebook;

public class FacebookHomePageUI {

	public static final String LOGIN_EMAIL = "xpath=//form[@id='login_popup_cta_form']//input[@name='email']";
	public static final String LOGIN_PASSWORD = "xpath=//form[@id='login_popup_cta_form']//input[@name='pass']";
	public static final String LOGIN_BUTTON = "xpath=//form[@id='login_popup_cta_form']//div[@aria-label='Accessible login button']";
	public static final String MESSAGE_BUTTON = "xpath=//span[contains(text(),'Message')]";
	public static final String MESSAGE_TEXTBOX = "xpath=//div[@aria-label='Message']/p";
	public static final String MESSAGE_SEND_BUTTON = "xpath=//div[@aria-label='Press enter to send']";
	public static final String MESSAGE_SEND_TEXT = "xpath=//div[@role='presentation']//div[text()='Test Message']";
	public static final String DYNAMIC_MESSAGE_TEXT = "xpath=//div[@data-scope='messages_table']//div[contains(text(),'%s')]";
}
