package commons;

import java.io.File;

public class GlobalConstants {
	public static final String CRM_PAGE_PORTAL_URL = "https://stg-crm.smarthiz.vn/";
	public static final String CRM_ACCOUNT_NAME = "cskhQA1@smarthizvn.com";
	public static final String CRM_ACCOUNT_PASSWORD = "123456";

	public static final String FACEBOOK_TEST_PAGE_URL = "https://www.facebook.com/profile.php?id=61554805572087";
	public static final String FACEBOOK_USER_EMAIL = "harfrvie001@gmail.com";
	public static final String FACEBOOK_USER_PASSWORD = "imhar@2512";
	public static final String FACEBOOK_USER_NAME = "Vũ Quang";

	public static final String CRM_USERNAME = "Vũ Quang";
	public static final String CRM_PHONE_NUMBER = "0345778899";

	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String JAVA_VERSION = System.getProperty("java.version");

	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles" + File.separator;
	public static final String REPORTNG_SCREENSHOT = PROJECT_PATH + File.separator + "ReportNGScreenShots" + File.separator;

	public static final int SHORT_TIMEOUT = 5;
	public static final int LONG_TIMEOUT = 30;
	public static final long RETRY_TESTFAIL = 3;

}
