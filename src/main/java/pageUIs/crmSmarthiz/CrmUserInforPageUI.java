package pageUIs.crmSmarthiz;

public class CrmUserInforPageUI {
	public static final String INFOR_PANEL_TITLE = "xpath=//span[text()=' Thông tin CRM ']";
	public static final String INFOR_ADD_ADDRESS_BUTTON = "xpath=//button//span[text()='Thêm địa chỉ']";
	public static final String INFOR_ADDRESS_DELETE_BUTTON = "xpath=//td[text()=' Địa chỉ: ']/parent::tr//i[contains(@class,'fa-trash-o')]";

	public static final String FORM_ADDRESS_NAME = "xpath=//span[text()='Địa chỉ khách hàng']";
	public static final String FORM_CITY_DROPDOWN = "xpath//label[text()='Tỉnh/Thành phố ']/following-sibling::mat-form-field/div";
	public static final String FORM_DISTRICT = "xpath=//label[text()='Quận/Huyện ']/following-sibling::mat-form-field/div";
	public static final String FORM_SUB_DISTRICT = "xpath=//label[text()=' Phường/Xã ']/following-sibling::mat-form-field/div";

	public static final String HSKH_UPDATE_MESSAGE = "xpath=//span[text()='Hồ sơ khách hàng đã được cập nhật.']";
}
