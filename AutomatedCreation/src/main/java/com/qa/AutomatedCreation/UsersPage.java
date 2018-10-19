package com.qa.AutomatedCreation;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsersPage {
		//The location of the first user I create
		@FindBy(xpath = "//*[@id=\"people\"]/tbody/tr[3]/td[2]/a")
		private WebElement user;
		
		//Boolean method to determine if the location of my first user exists on that website
		public boolean isTheNameThere() {
			try {
				user.getLocation();
				return true;
			}
			catch(NoSuchElementException e) {
				return false;
			}
		}
		
		//Method to wait until the automated user finds his name then clicks to see their profile
		public void enterUsers(WebDriver driver, String arg1) {
			WebElement entUser = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(By.linkText("http://localhost:8080/securityRealm/user/"+ arg1 + "/")));
			Actions action = new Actions(driver);
			action.moveToElement(entUser).click().perform();
		}
}

