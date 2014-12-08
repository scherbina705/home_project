package com.mycompany.app.seleniumTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    final WebDriver driver;
    final static String PAGEURL="http://gioia-profiterole.rhcloud.com/login";

    public LoginPage(WebDriver driver){
        driver.manage().window().maximize();
        driver.get(PAGEURL);
        this.driver=driver;
    }

    public WebElement getLoginField(){
        return driver.findElement(By.id("j_username"));
    }

    public WebElement getPasswordField(){
        return driver.findElement(By.id("j_password"));
    }

    public WebElement getEnterButton(){
        return driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/div/div/form/div/div[4]/div/button"));
    }

    public WebElement getGreetingsBlock(){
        return driver.findElement(By.className("recipe"));
    }
}
