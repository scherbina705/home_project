package com.mycompany.app.seleniumTest.tests;

import com.mycompany.app.seleniumTest.Cuisine;
import com.mycompany.app.seleniumTest.steps.MenuSteps;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by gatto on 12/7/14.
 */
public class TestCuisines {
    WebDriver driver;
    MenuSteps step;
    Set<String> mandatoryCuisineNames = new HashSet<String>(Arrays.asList("Украинская",
            "Русская",
            "Японская",
            "Китайская",
            "Тайская",
            "Итальянская",
            "Мексиканская",
            "Французская",
            "Армянская",
            "Индийская",
            "Греческая",
            "Грузинская"));
    List<String> mandatoryFrenchSnacks = new ArrayList<>(Arrays.asList("Сырные палочки из пармезана",
            "Классический грибной жульен",
            "Шампиньоны по-гречески",
            "Шампиньоны по-гречески"));

    @Before
    public void setStartPage(){
        driver=new ChromeDriver();
        step = new MenuSteps(driver);
    }

    @After
    public void refreshPage(){
        driver.close();
    }

    @Test
    public void menuShouldContainCuisines(){
        step.clickOnBreakfastButton();
        Set<Cuisine> currentCuisineNames = step.findAllCuisines();
        assertTrue(step.menuShouldContainCuisines(mandatoryCuisineNames, currentCuisineNames));
    }

    @Test
    public void frenchMenuShouldContainSnacks(){
        step.clickOnBreakfastButton();
        Map<Cuisine,List<String>> currentSnacks = step.findAllSnacks();
        assertTrue(step.cuisineShouldContainSnacks("Французская",mandatoryFrenchSnacks));
    }
}
