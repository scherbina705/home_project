package com.mycompany.app.seleniumTest.steps;

import com.mycompany.app.seleniumTest.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    LoginPage page;

    public LoginSteps(WebDriver driver){
        page= new LoginPage(driver);
    }

    public void enterLogin(String login){
        page.getLoginField().clear();
        page.getLoginField().sendKeys(login);
    }

    public void enterPassword(String password){
        page.getPasswordField().clear();
        page.getPasswordField().sendKeys(password);
    }

    public void clickOnEnterButton(){
        page.getEnterButton().click();
    }

    public boolean blockContainGreetings(String text){
        return page.getGreetingsBlock().getText().contains(text);
    }
}
