package com.qa.AutomatedCreation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CreateUsers {
	//elements on the create users section
	@FindBy(id = "username")
	private WebElement username;
	@FindBy(name = "password1")
	private WebElement password;
	@FindBy(name = "password2")
	private WebElement confPass;
	@FindBy(name = "fullname")
	private WebElement names;
	@FindBy(name = "email")
	private WebElement email;
	@FindBy(xpath = "//*[@id=\"yui-gen2\"]")
	private WebElement submit;
		
	//,ethod for the first user to input their values to be seen
	public void userCreation(WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(username).click().perform();
		action.sendKeys("Marcus").perform();
		action.moveToElement(password).click().perform();
		action.sendKeys("eeee").perform();
		action.moveToElement(confPass).click().perform();
		action.sendKeys("eeee").perform();
		action.moveToElement(names).click().perform();
		action.sendKeys("Marcus Pindard-Baden").perform();
		action.moveToElement(email).click().perform();
		action.sendKeys("mpb@gm.com").perform();
	}
	
	//submits the user inputs
	public void userSubmit(WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(submit).click().perform();
	}
	
	//automated input method for the features
	public void featuresSubmit(WebDriver driver, String arg1, String arg2, String arg3, String arg4) {
		Actions action = new Actions(driver);
		action.moveToElement(username).click().perform();
		action.sendKeys(arg1).perform();
		action.moveToElement(password).click().perform();
		action.sendKeys(arg2).perform();
		action.moveToElement(confPass).click().perform();
		action.sendKeys(arg3).perform();
		action.moveToElement(names).click().perform();
		action.sendKeys(arg4).perform();
		action.moveToElement(email).click().perform();
		action.sendKeys("abcdef@g.com").perform();
	}
	

}
