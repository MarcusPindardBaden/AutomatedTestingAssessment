package com.qa.AutomatedCreation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class FirstLogin {
	//admin username section
	@FindBy(id ="j_username")
	private WebElement fuser;
	//admin password section
	@FindBy(name="j_password")
	private WebElement fPass;
	//admin  page submit button
	@FindBy(xpath = "/html/body/div/div/form/div[3]/input")
	private WebElement submit1;
	
	//Performing the initial login at the start of every test before other methods can be performed
	public void fLogin(WebDriver driver) throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(fuser).click().perform();
		action.sendKeys("admin").perform();
		action.moveToElement(fPass).click().perform();
		action.sendKeys("3686118fa4d849739f3e6bb63910f58c");
		action.moveToElement(submit1).click().perform();
		Thread.sleep(1000);
	}

}
