package com.liveguru.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.liveguru.user.UserHomePageObjectGuru;
import pageObjects.liveguru.user.UserLoginPageObjectGuru;
import pageObjects.liveguru.user.UserMyDashboardPageObjectGuru;
import pageObjects.liveguru.user.UserRegisterPageObjectGuru;

public class LoginLiveGuru extends BaseTest {
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		fisrtName = "Automation";
		middleName = "and";
		lastName = "Testing";
		email = "abc" + genarateFakeNumber() + "@gmail.net";
		password = "123456";
		fullName = fisrtName + " " + middleName+ " " + lastName;
	}
	
	@Test
	public void TC_01_Register_success() {
		loginPage = homePage.openLoginPage(driver);
		
		registerPage = loginPage.clickToCreateAnAccount();
		myDashboardPage = registerPage.RegisterSuccess(fisrtName,middleName,lastName,email, password, password);
		Assert.assertTrue(myDashboardPage.getHelloMessage().contains(fullName));
		Assert.assertTrue(myDashboardPage.getFullNameMessage().contains(fullName));
		Assert.assertTrue(myDashboardPage.getFullNameMessage().contains(email));
		
		myDashboardPage.clickToAccount();
		homePage = myDashboardPage.clickToLogoutLink();
	}
	
	@Test
	public void TC_02_Login_success() {
		loginPage = homePage.openLoginPage(driver);

		myDashboardPage = loginPage.LoginSucess(email,password);
		Assert.assertTrue(myDashboardPage.getHelloMessage().contains(fullName));
	}
	public int genarateFakeNumber() {
		  Random rand = new Random();
		  return rand.nextInt();
	}
	  
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	private WebDriver driver;
	private UserHomePageObjectGuru homePage;
	private UserLoginPageObjectGuru loginPage;
	private UserRegisterPageObjectGuru registerPage;
	private UserMyDashboardPageObjectGuru myDashboardPage;
	private String fisrtName, middleName, lastName, email, password, fullName;
}
