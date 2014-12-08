package com.mycompany.app.seleniumTest.tests;

import com.mycompany.app.seleniumTest.steps.RegistrationSteps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class TestRegistrationMandatoryFields {
    WebDriver driver;
    RegistrationSteps step;

    @Before
    public void setStartPage(){
        driver=new ChromeDriver();
        step = new RegistrationSteps(driver);
    }

    @After
    public void refreshPage(){
        driver.close();
    }

    @Test
    public void Should_Show_Error_Message_When_Empty_Login_Field(){
        step.clickConfirm();
        assertTrue("no error message about empty login field", step.isErrorLoginMessageShown());
        assertTrue("no error message about empty password field",step.isErrorPasswordMessageShown());
        assertTrue("no error message about empty email field",step.isErrorEmailMessageShown());
        assertTrue("no error message about unchecked agreement box",step.isErrorAgreementMessageShown());
    }
}
