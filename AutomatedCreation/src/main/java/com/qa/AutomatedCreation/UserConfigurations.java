package com.qa.AutomatedCreation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.LogStatus;

public class UserConfigurations {
	//The user ID quotation 
	@FindBy(xpath = "//*[@id=\"main-panel\"]/div[2]")
	private WebElement iD;
	//The button that takes you from any user profile to their configurations section
	@FindBy(xpath = "//*[@id=\"tasks\"]/div[4]/a[2]")
	private WebElement configGo;
	//On the configurations page the full name section
	@FindBy(name = "_.fullName")
	private WebElement fName;
	//The save changes button on configurations page
	@FindBy(xpath = "//*[@id=\"yui-gen3-button\"]")
	private WebElement saveB;
	
	
	
	public boolean isItMatt(String arg1) {
		//The is checking the quotation inside is the same as expected
		if(iD.equals("Jenkins User ID: " +arg1 )) {
			return true;
		}
		else {
			return false;
		}
	}
	//click function onto the configurations website
	public void goToConfig(WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(configGo).click().perform();
	}
	//editing the name in the configurations
	public void changeTheName(WebDriver driver, String arg1) {
		Actions action = new Actions(driver);
		action.moveToElement(fName).click().perform();
		action.moveToElement(fName).doubleClick().perform();
		action.sendKeys(arg1);
	}
	//clicking the save button 
	public void savingChanges(WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(saveB).click().perform();
	}
	//checking the value inside the xpath point and seeing if the text equates to arg1
	public boolean hasTheNameChanged(WebDriver driver, String arg1) {
		String abc =driver.findElement(By.xpath("//*[@id=\"main-panel\"]/h1")).getText();
		if(abc.equalsIgnoreCase(arg1)) {
			return true;
		}
		else {
			return false;
		}
		
	}
}
