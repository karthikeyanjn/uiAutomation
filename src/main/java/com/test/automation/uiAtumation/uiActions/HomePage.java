package com.test.automation.uiAtumation.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public static final Logger log = Logger.getLogger(HomePage.class.getName());
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement signIn;
	
	@FindBy(id="email")
	WebElement loginEmailAddress;
	
	@FindBy(id="passwd")
	WebElement loginPassword;
	
	@FindBy(id="SubmitLogin")
	WebElement submitButton;
	
	@FindBy(xpath="//*[@id='center_column']/div[1]/ol/li")
	WebElement authenticationFailed;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginToApplication(String emailAdress,String password) throws InterruptedException{
		log.info("Clicking on sign in and object is "+ signIn.toString());
		//signIn.click();
		log.info("Entering Email address of " + emailAdress +" and object is "+ loginEmailAddress.toString());
		loginEmailAddress.sendKeys(emailAdress);
		log.info("Entering password of " + password +" and object is "+ loginPassword.toString());
		loginPassword.sendKeys(password);
		log.info("clicked on submit button and object is "+ submitButton.toString());
		submitButton.click();
	}
	
	public String getInvalidLoginText(){
		log.info("error message is :-" + authenticationFailed.getText());
		return authenticationFailed.getText();
	}

}
