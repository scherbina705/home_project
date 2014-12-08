package com.mycompany.app.seleniumTest.tests;

import com.mycompany.app.seleniumTest.steps.LoginSteps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class TestLogin {
    WebDriver driver;
    LoginSteps step;
    String pass="123aaa456bbb789ccc";
    String login="testprofitrole";
    String greetingsText="Добро пожаловать на сайт";

    @Before
    public void setStartPage(){
        driver=new ChromeDriver();
        step = new LoginSteps(driver);
    }

    @After
    public void refreshPage(){
        driver.close();
    }

    @Test
    public void Should_Show_Greetings_When_Click_Enter_With_Valid_Login_And_Pass(){
        step.enterLogin(login);
        step.enterPassword(pass);
        step.clickOnEnterButton();
        assertTrue("No greetings:"+greetingsText,step.blockContainGreetings(greetingsText));
    }
}
