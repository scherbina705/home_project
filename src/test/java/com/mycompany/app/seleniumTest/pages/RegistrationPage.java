package com.mycompany.app.seleniumTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
    final WebDriver driver;
    final static String PAGEURL ="http://gioia-profiterole.rhcloud.com/registration";

    public RegistrationPage(WebDriver driver){
        driver.manage().window().maximize();
        driver.get(PAGEURL);
        this.driver=driver;
    }

    public WebElement getConfirmButton(){
        return driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/form/div[9]/button"));
    }

    public WebElement getErrorLoginMessage(){
        return driver.findElement(By.id("loginError"));
    }

    public WebElement getErrorPasswordMessage(){
        return driver.findElement(By.id("passwordError"));
    }

    public WebElement getErrorEmailMessage(){
        return driver.findElement(By.id("emailError"));
    }

    public WebElement getErrorAgreementMessage(){
        return driver.findElement(By.id("iAmAgreeError"));
    }
}
