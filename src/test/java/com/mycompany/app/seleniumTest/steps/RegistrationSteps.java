package com.mycompany.app.seleniumTest.steps;


import com.mycompany.app.seleniumTest.pages.RegistrationPage;
import org.openqa.selenium.WebDriver;

public class RegistrationSteps {
    RegistrationPage elements;

    public RegistrationSteps(WebDriver driver){
        elements = new RegistrationPage(driver);
    }

    public void clickConfirm(){
        elements.getConfirmButton().click();
    }

    public boolean isErrorLoginMessageShown(){
        return elements.getErrorLoginMessage().isDisplayed();
    }

    public boolean isErrorPasswordMessageShown(){
        return elements.getErrorPasswordMessage().isDisplayed();
    }

    public boolean isErrorEmailMessageShown(){
        return elements.getErrorEmailMessage().isDisplayed();
    }

    public boolean isErrorAgreementMessageShown(){
        return elements.getErrorAgreementMessage().isDisplayed();
    }
}
