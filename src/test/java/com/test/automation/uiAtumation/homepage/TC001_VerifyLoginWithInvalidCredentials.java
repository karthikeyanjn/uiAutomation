package com.test.automation.uiAtumation.homepage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.uiAtumation.testbase.TestBase;
import com.test.automation.uiAtumation.uiActions.HomePage;

public class TC001_VerifyLoginWithInvalidCredentials extends TestBase{
	
	public static final Logger log = Logger.getLogger(TC001_VerifyLoginWithInvalidCredentials.class.getName());
		HomePage homePage;
		
	@BeforeTest
	public void setUp() throws InterruptedException{
			initialization();
		}

	@Test
	public void verifyLoginWithInvalidCredentials() throws InterruptedException{
		log.info("==========Starting verifyLoginWithInvalidCredentials test=======" );
		homePage = new HomePage(driver);
		homePage.loginToApplication("jnkarthi@gmail.com", "password");
		Assert.assertEquals(homePage.getInvalidLoginText(), "Authentication failed.");
		log.info("==========Ending verifyLoginWithInvalidCredentials test=======" );
		
	}
	
	@AfterClass
	public void endTest(){
		driver.close();
	}
}
