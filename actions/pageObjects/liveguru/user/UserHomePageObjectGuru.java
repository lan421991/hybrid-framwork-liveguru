package pageObjects.liveguru.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveguru.HomePageUI;

public class UserHomePageObjectGuru extends BasePage{
	private WebDriver driver;

	public UserHomePageObjectGuru(WebDriver driver) {
		this.driver = driver;
	}
//
//	public UserLoginPageObjectGuru clickToMyAccountLink() {
//		waitForElementClickEnable(driver, HomePageUI.ACCOUNT_LINK);
//		clickToElement(driver, HomePageUI.ACCOUNT_LINK);
//		waitForElementClickEnable(driver, HomePageUI.MY_ACCOUNT_LINK);
//		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
//		return UserPageGeneratorManagerGuru.getLoginPage(driver);
//	}

}
