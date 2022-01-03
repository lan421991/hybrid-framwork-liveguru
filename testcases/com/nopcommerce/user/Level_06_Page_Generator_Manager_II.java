package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageObject;
import pageObjects.nopcommerce.MyAccountPageObject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.RegisterPageObject;

public class Level_06_Page_Generator_Manager_II extends BaseTest{

	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
	  driver = getBrowserDriver(browserName,url);
	  homePage = PageGeneratorManager.getHomePage(driver);
	  
	  firstName = "Automation";
	  lastName = "FC";
	  invalidEmail = "afc@afc@1w@w";
	  notFoundEmail = "afccaaa@gmail.net";
	  exitingEmail = "fc" + genarateFakeNumber() + "@gmail.com";
	  validPassword = "123456";
	  inValidPassword = "654321";
	  
	  System.out.println("PreCondition - Step 01 : Click register link"); 
	  registerPage = homePage.clickToRegisterLink();

	  System.out.println("PreCondition - Step 02: Input to required fields"); 
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox(exitingEmail);
	  registerPage.inputToPasswordTextbox(validPassword);
	  registerPage.inputToConfirmPasswordTextbox(validPassword);
	  
	  System.out.println("PreCondition - Step 03 : Click register button"); 
	  registerPage.clickToRegisterButton();
	  
	  
	  System.out.println("PreCondition - Step 04: Verify success message displayed"); 
	  Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");

	  System.out.println("PreCondition - Step 05 : Click to logout link"); 
	  homePage = registerPage.clickToLogoutLink();

  	}

  @Test
  public void Login_01_Empty_Data() {
	  loginPage = homePage.clicktoLoginLink();
	  loginPage.clickToLoginButton();
	  Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email"); 
  	}
  
  @Test
  public void Login_02_Invalid_Email() {
	  loginPage = homePage.clicktoLoginLink();
	  loginPage.inputEmailTextbox(invalidEmail);
	  loginPage.clickToLoginButton();
	  Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email"); 
  	}
  
  @Test
  public void Login_03_Email_Not_Found() {
	  loginPage = homePage.clicktoLoginLink();
	  loginPage.inputEmailTextbox(notFoundEmail);
	  loginPage.clickToLoginButton();
	  Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found"); 
  	}
  	
  @Test
  public void Login_04_Exiting_Email_Empty_Password() {
	  loginPage = homePage.clicktoLoginLink();
	  loginPage.inputEmailTextbox(exitingEmail);
	  loginPage.inputToPasswordTextbox("");
	  loginPage.clickToLoginButton();
	  Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect"); 
  	}
  
  @Test
  public void Login_05_Exiting_Email_Incorrect_Password() {
	  loginPage = homePage.clicktoLoginLink();
	  loginPage.inputEmailTextbox(exitingEmail);
	  loginPage.inputToPasswordTextbox(inValidPassword);
	  loginPage.clickToLoginButton();
	  Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect"); 
  	}
  
  @Test
  public void Login_06_Valid_Email_Password() {
	  loginPage = homePage.clicktoLoginLink();
	  loginPage.inputEmailTextbox(exitingEmail);
	  loginPage.inputToPasswordTextbox(validPassword);
	  homePage = loginPage.clickToLoginButton();
	  Assert.assertTrue(homePage.isMyAccountLimkDisplayed());
	  myAccountPage = homePage.clickToMyAccount();
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
	private String firstName, lastName, invalidEmail, notFoundEmail, exitingEmail, validPassword,inValidPassword;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private MyAccountPageObject myAccountPage;
}
