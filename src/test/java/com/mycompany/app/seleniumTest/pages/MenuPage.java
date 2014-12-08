package com.mycompany.app.seleniumTest.pages;

import com.mycompany.app.seleniumTest.Cuisine;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 */
public class MenuPage {
    final WebDriver driver;
    final static String PAGEURL ="http://gioia-profiterole.rhcloud.com/allOfRecipes";
    WebDriverWait wait;

    public MenuPage(WebDriver driver){
        driver.manage().window().maximize();
        driver.get(PAGEURL);
        this.driver=driver;
        wait= new WebDriverWait(driver, 10);
    }
    private void implicitWait(long seconds){
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public WebElement getSnacksButton(){
        return driver.findElement(By.xpath("//*[contains(text(), 'Закуски') and @class='accordion-toggle']"));
    }

    public WebElement getBackToCuisinesButton(){
        implicitWait(10);
        return driver.findElement(By.id("back"));
    }

    public List<WebElement> getCuisines(){
        implicitWait(10);
        return driver.findElements(By.xpath("//*[@id='cuisine']/div[@class='btn']"));
    }

    public WebElement getCuisine(String cuisineName){
        implicitWait(10);
        return driver.findElement(By.xpath("//*[contains(text(), '" + cuisineName + "')]"));
    }

    public List<String> getSnacks(String cuisine){
        List<WebElement> elements;
        List<String> snackNames = new ArrayList<>();
        getCuisine(cuisine).click();
        getSnacksButton().click();
        implicitWait(40L);
        elements = driver.findElements(By.xpath("//div[@id='collapseOne']/div[1]/div[@class='recipe_on_page btn-link']"));
        for (WebElement snackElement: elements){
            snackNames.add(snackElement.getText());
        }
        getBackToCuisinesButton().click();
        implicitWait(40L);
        return snackNames;
    }
}
