package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.liveguru.user.UserHomePageObjectGuru;
import pageObjects.liveguru.user.UserLoginPageObjectGuru;
import pageObjects.liveguru.user.UserMyDashboardPageObjectGuru;
import pageObjects.liveguru.user.UserRegisterPageObjectGuru;

public class PageGeneratorManager {
	private WebDriver driver;
	
	public static UserHomePageObjectGuru getHomePage(WebDriver driver) {
		return new UserHomePageObjectGuru(driver);
	}
	
	public static UserLoginPageObjectGuru getLoginPage(WebDriver driver) {
		return new UserLoginPageObjectGuru(driver);
	}
	
	public static UserRegisterPageObjectGuru getRegisterPage(WebDriver driver) {
		return new UserRegisterPageObjectGuru(driver);
	}

	public static UserMyDashboardPageObjectGuru getMyDashboardPage(WebDriver driver) {
		return new UserMyDashboardPageObjectGuru(driver);
	}
}
