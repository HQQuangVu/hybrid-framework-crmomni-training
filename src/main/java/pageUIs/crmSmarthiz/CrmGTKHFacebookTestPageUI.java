package pageUIs.crmSmarthiz;

public class CrmGTKHFacebookTestPageUI {
	public static final String TESTPAGE_TEXT = "xpath=//span[contains(text(),'CRM Test Page')]";
	public static final String TESTPAGE_TINNHAN_TEXT = "xpath=//span[contains(text(),'Tin nhắn')]";
	public static final String UPLOAD_FILE = "css=input[type='file']";

	public static final String UPLOAD_FAILED_MESSAGE = "xpath=//div[text()='Không thể gửi file có dung lượng lớn hơn 25MB']";
	public static final String UPLOAD_FAILED_CLOSE_BUTTON = "xpath=//button[text()=' Đóng ']";
	public static final String UPLOAD_IMAGE_DISPLAY = "xpath=//img[contains(@src,'data:image/png;base64')]";

	public static final String INFOR_SEARCH_BUTTON = "xpath=//p[contains(text(),'Hồ sơ khách hàng')]/parent::div/following-sibling::button";
	public static final String INFOR_PHONE_FIELD = "xpath=//input[@data-placeholder='Nhập số điện thoại để tìm kiếm khách hàng']";
	public static final String INFOR_USERNAME = "xpath=//span[text()='%s']";
	public static final String INFOR_EDIT_BUTTON = "xpath=//span[text()='Thông tin liên hệ']/parent::div/button";

	public static final String EMOTICON_BUTTON = "xpath=//img[contains(@src,'emoji')]/parent::a";
	public static final String EMOTICON_LOVELY = "xpath=//div[@id='cdk-overlay-0']//p[2]";
	public static final String EMOTICON_LOVELY2 = "xpath=//div[@id='mat-menu-panel-3']//p[contains(text(),'🥰')]";
	public static final String EMOTICON_SENT_IN_CHAT = "xpath=//p[@class='message-time']/following-sibling::div[contains(text(),'🥰')]";

	public static final String TESTPAGE_SEARCH_FACEBOOK = "xpath=//input[@data-placeholder='Tìm kiếm']";
	public static final String TESTPAGE_SEARCH_USERNAME = "xpath=//div[@id='customerDIV']//p/strong";
	public static final String DYNAMIC_TESTPAGE_TIME_BY_USERNAME = "xpath=//strong[text()='%s']/parent::p/parent::div/following-sibling::div/p";
	public static final String DYNAMIC_TESTPAGE_FACEBOOK_MESSAGE = "xpath=//div[contains(@class,'message-hover')]//p[contains(text(),'%s')]";

	public static final String TESTPAGE_CRM_TEXTAREA = "xpath=//textarea[@data-placeholder='Nhập tin nhắn...']";
	public static final String TESTPAGE_CRM_TEXTAREA_SENDBUTTON = "xpath=//img[contains(@src,'ic_send_message')]/parent::a";
	public static final String TESTPAGE_CRM_TEXTAREA_SENDMESSAGE = "xpath=//div[contains(@class,'message-hover')]//p[contains(text(),'Test Message')]";
}
