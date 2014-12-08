package com.mycompany.app.seleniumTest.pages;

import com.mycompany.app.seleniumTest.Cuisine;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 */
public class MenuPage {
    final WebDriver driver;
    final static String PAGEURL ="http://gioia-profiterole.rhcloud.com/menu";
    WebDriverWait wait;

    public MenuPage(WebDriver driver){
        driver.manage().window().maximize();
        driver.get(PAGEURL);
        this.driver=driver;
        wait= new WebDriverWait(driver, 300);
    }
    private void implicitWait(int seconds){
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public WebElement getBreakfastButton(){
        return driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[1]/button[1]"));
    }

    public WebElement getBackToCuisinesButton(){
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.id("back")));
    }

    public List<WebElement> getCuisines(){
        implicitWait(50);
        return driver.findElements(By.xpath("//div[@id='cuisine']/div[@class='btn']"));
    }

    public WebElement getCuisine(String cuisineName){
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), '"+cuisineName+"')]")));
    }

    public List<String> getSnacks(String cuisineName){
        List<String> snackNamesList= new ArrayList<>();
        implicitWait(25);
        getCuisine(cuisineName).click();
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='cuisine']/div[@class='btn draggable recepies_btn ui-draggable']")));
        if (elements.isEmpty()){
            getBackToCuisinesButton().click();
            return snackNamesList;
        }else{
            for (WebElement snackElement: elements){
                if (snackElement.isDisplayed()){
                    snackNamesList.add(snackElement.getText());
                }
            }
            implicitWait(25);
            getBackToCuisinesButton().click();
            return snackNamesList;
        }
    }
}
