package com.qa.AutomatedCreation;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestAndReport {
	private static final String delete = null;
	public WebDriver driver = null; 
	//Setting up the report
	boolean replaceExisting = true;
	ExtentReports extent = new ExtentReports("C:\\Users\\Admin\\Documents\\AutomatedCreation\\Report.html",replaceExisting);
	ExtentTest test;
	//initialising the webDriver before we begin 
			@Before
			public void setUp() {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Admin\\Desktop\\spring-boot-vuejs\\frontend\\node_modules\\chromedriver\\lib\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			
			}
			
			@Test
			public void userCreation() throws InterruptedException {
			
			//initialising the test and logging it as well as logging in
				test = extent.startTest("Test Initialised");
				driver.get("http://localhost:8080/");
				test.log(LogStatus.INFO, "Jenkins website loaded");
				FirstLogin OP = PageFactory.initElements(driver, FirstLogin.class);
				OP.fLogin(driver);
				
				//navigating from the homepage to the user creator page
				JenkinsHomepage page1 = PageFactory.initElements(driver, JenkinsHomepage.class);
				page1.moveToUsers(driver);
				page1.goToCreate(driver);
				test.log(LogStatus.INFO, "Website moves to 'Manage Jenkins' and then 'Manage Users'");
				
				//inputting the info and submitting on the user creator
				CreateUsers page2 = PageFactory.initElements(driver, CreateUsers.class);
				page2.userCreation(driver);
				page2.userSubmit(driver);
				test.log(LogStatus.INFO, "Details have been input and submitted");
				
				//checking to see if the login has been successfull
				UsersPage page3 = PageFactory.initElements(driver, UsersPage.class);
				if(page3.isTheNameThere()==true) {
					test.log(LogStatus.PASS, "User has been successfully created");
				}
				else {
					test.log(LogStatus.FAIL, "User has not been successfully created");
				}
				extent.endTest(test);
				extent.flush();
				assertEquals("Name is not there", true, page3.isTheNameThere());
			}
			
			//This is similar to the other test above except it's just been split amongst the given, when and then 
			@Given("^that you are on the create UserScreen$")
			public void that_you_are_on_the_create_UserScreen() throws InterruptedException {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\Admin\\Desktop\\spring-boot-vuejs\\frontend\\node_modules\\chromedriver\\lib\\chromedriver\\chromedriver.exe");
				driver = new ChromeDriver();
				test = extent.startTest("Test Initialised");
			    driver.get("http://localhost:8080/");
			    test.log(LogStatus.INFO, "Jenkins website loaded");
			    FirstLogin OP = PageFactory.initElements(driver, FirstLogin.class);
				OP.fLogin(driver);
				JenkinsHomepage page1 = PageFactory.initElements(driver, JenkinsHomepage.class);
				page1.moveToUsers(driver);
				page1.goToCreate(driver);
				test.log(LogStatus.INFO, "Website moves to 'Manage Jenkins' and then 'Manage Users'");
			}

			@When("^the User details are entered on the Create UserScreen$")
			public void the_User_details_are_entered_on_the_Create_UserScreen() {
				CreateUsers page2 = PageFactory.initElements(driver, CreateUsers.class);
				page2.userCreation(driver);
				test.log(LogStatus.INFO, "Details have been input");
			}

			@When("^the details are submitted on the Create UserScreen$")
			public void the_details_are_submitted_on_the_Create_UserScreen() throws Throwable {
				CreateUsers page2 = PageFactory.initElements(driver, CreateUsers.class);
				page2.userSubmit(driver);
				test.log(LogStatus.INFO, "Details have been submitted");
			}

			@Then("^the Username should be visible on the UsersScreen$")
			public void the_Username_should_be_visible_on_the_UsersScreen(){
				UsersPage page3 = PageFactory.initElements(driver, UsersPage.class);
				if(page3.isTheNameThere()==true) {
					test.log(LogStatus.PASS, "User has been successfully created");
				}
				else {
					test.log(LogStatus.FAIL, "User has not been successfully created");
				}
				extent.endTest(test);
				extent.flush();
				assertEquals("Name is not there", true, page3.isTheNameThere());
			}
			//The arg1, arg2 etc are used to automate each section so are implied paramters throughout, using separate classes and calling these across
			@When("^the User details \"([^\"]*)\" username, \"([^\"]*)\" password, \"([^\"]*)\" confirm Password, and \"([^\"]*)\" Fullname are entered on the Create UserScreen$")
			public void the_User_details_username_password_confirm_Password_and_Fullname_are_entered_on_the_Create_UserScreen(String arg1, String arg2, String arg3, String arg4) throws Throwable {
				CreateUsers page2 = PageFactory.initElements(driver, CreateUsers.class);
				page2.featuresSubmit(driver, arg1, arg2, arg3, arg4);
			}

			@Then("^the \"([^\"]*)\" username should be visible on the UsersScreen$")
			public boolean the_username_should_be_visible_on_the_UsersScreen(String arg1) {
				try{
					driver.findElement(By.linkText("http://localhost:8080/securityRealm/user/"+ arg1 + "/"));
					test.log(LogStatus.PASS, "username "+ arg1 +"has been found");
					return true;
				}
				catch(NoSuchElementException e) {
					test.log(LogStatus.FAIL, "username "+ arg1 +"has not been found");
					return false;
				}
				
			    
			}

			@Given("^the \"([^\"]*)\" username is visible on the UsersScreen$")
			//The same as previous tests, just navigation to the users page instead of to creation of the site
			public void the_username_is_visible_on_the_UsersScreen(String arg1) throws InterruptedException {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\Admin\\Desktop\\spring-boot-vuejs\\frontend\\node_modules\\chromedriver\\lib\\chromedriver\\chromedriver.exe");
				driver = new ChromeDriver();
				test = extent.startTest("Test Initialised");
			    driver.get("http://localhost:8080/");
			    test.log(LogStatus.INFO, "Jenkins website loaded");
			    FirstLogin OP = PageFactory.initElements(driver, FirstLogin.class);
				OP.fLogin(driver);
				JenkinsHomepage page1 = PageFactory.initElements(driver, JenkinsHomepage.class);
				page1.moveToUsers(driver);
				test.log(LogStatus.INFO, "Website moves to 'Manage Jenkins' and then 'Manage Users'");
			}

			@When("^the \"([^\"]*)\" username is clicked on the UserScreen$")
			//Intention is to allow the site to load for a second, the find the element through the users class
			public void the_username_is_clicked_on_the_UserScreen(String arg1) throws InterruptedException {
				Thread.sleep(1000);
				UsersPage page3 = PageFactory.initElements(driver, UsersPage.class);
				page3.enterUsers(driver, arg1);
			}

			@Then("^the User Profile should display the \"([^\"]*)\" username on the ProfileScreen$")
			//This tests the method created in the configurations class and produces a boolean outcome to verify
			public void the_User_Profile_should_display_the_username_on_the_ProfileScreen(String arg1) {
				UserConfigurations page4 = PageFactory.initElements(driver, UserConfigurations.class);
				if(page4.isItMatt(arg1)==true) {
					test.log(LogStatus.PASS, "Test has found the right user");
				}
				else {
					test.log(LogStatus.FAIL, "Test has not found the right user");
				}
				assertEquals("It's not Matt", true, page4.isItMatt(arg1));
			}

			@Given("^the \"([^\"]*)\" Username's profile page has been loaded$")
			//Navigating to the users profile using all the previously created classes
			public void the_Username_s_profile_page_has_been_loaded(String arg1) throws Throwable {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\Admin\\Desktop\\spring-boot-vuejs\\frontend\\node_modules\\chromedriver\\lib\\chromedriver\\chromedriver.exe");
				driver = new ChromeDriver();
				test = extent.startTest("Test Initialised");
			    driver.get("http://localhost:8080/");
			    test.log(LogStatus.INFO, "Jenkins website loaded");
			    FirstLogin OP = PageFactory.initElements(driver, FirstLogin.class);
				OP.fLogin(driver);
				JenkinsHomepage page1 = PageFactory.initElements(driver, JenkinsHomepage.class);
				page1.moveToUsers(driver);
				test.log(LogStatus.INFO, "Website moves to 'Manage Jenkins' and then 'Manage Users'");
				Thread.sleep(1000);
				UsersPage page3 = PageFactory.initElements(driver, UsersPage.class);
				page3.enterUsers(driver, arg1); 
			}

			@Given("^the configure button has been clicked on the profile page$")
			//Using the configuration class to use the click method onto the configurations
			public void the_configure_button_has_been_clicked_on_the_profile_page() {
			    UserConfigurations page4 = PageFactory.initElements(driver, UserConfigurations.class);
			    page4.goToConfig(driver);
			}

			@When("^I change the old FullName on the Configure Page to a new FullName \"([^\"]*)\"$")
			//method for deleting the old name and inserting a new
			public void i_change_the_old_FullName_on_the_Configure_Page_to_a_new_FullName(String arg1) {
				 UserConfigurations page4 = PageFactory.initElements(driver, UserConfigurations.class);
				 page4.changeTheName(driver, arg1);
					
			}

			@When("^I save the changes to the Configure Page$")
			public void i_save_the_changes_to_the_Configure_Page() {
				//calling the save changes button method
				 UserConfigurations page4 = PageFactory.initElements(driver, UserConfigurations.class);
				 page4.savingChanges(driver);
			}

			@Then("^the Configure Page should show the NewFullName \"([^\"]*)\"$")
			public void the_Configure_Page_should_show_the_NewFullName(String arg1) {
				UserConfigurations page4 = PageFactory.initElements(driver, UserConfigurations.class);
				page4.hasTheNameChanged(driver, arg1);
				//if(abc.equalsIgnoreCase(arg1)== true) {
					
			}
			
			//Quitting the driver
			@After
			public void tearDown() {
				driver.quit();
			}
		
}
