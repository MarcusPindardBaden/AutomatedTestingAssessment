package com.qa.AutomatedCreation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class JenkinsHomepage {
	//The manage jenkins button
	@FindBy(xpath = "//*[@id=\"tasks\"]/div[4]/a[2]")
	private WebElement manageJenkins;
	//The manage users button
	@FindBy(xpath = "//*[@id=\"main-panel\"]/div[17]/a/dl/dt")
	private WebElement manageUsers;
	//The creat users button
	@FindBy(xpath = "//*[@id=\"tasks\"]/div[3]/a[2]")
	private WebElement createUsers;
	
	
	//sends the homepage to the users page
	public void moveToUsers(WebDriver driver) throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(manageJenkins).click().perform();
		Thread.sleep(1000);
		action.moveToElement(manageUsers).click().perform();
	}
	//sets up the create users page
	public void goToCreate(WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(createUsers).click().perform();
	}
}
