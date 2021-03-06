package com.mycompany.app.seleniumTest.steps;

import com.mycompany.app.seleniumTest.Cuisine;
import com.mycompany.app.seleniumTest.pages.MenuPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.util.*;
import java.util.List;


/**
 */
public class MenuSteps {
    MenuPage page;

    public MenuSteps(WebDriver driver){
        page= new MenuPage(driver);
    }

    public Map<Cuisine,List<String>> findAllSnacks(){
        Map<Cuisine,List<String>> cuisineAndSnacks= new HashMap<>();
        for (Cuisine cuisine:findAllCuisines()){
            cuisineAndSnacks.put(cuisine,page.getSnacks(cuisine.getCuisineName()));
        }
        return cuisineAndSnacks;
    }

    public Set<Cuisine> findAllCuisines(){
        Set<Cuisine> cuisines= new HashSet<>();
        for(WebElement cuisineElement:page.getCuisines()){
            cuisines.add(new Cuisine(cuisineElement.getText()));
        }
        return cuisines;
    }

    public boolean menuShouldContainCuisines(Set<String> mandatoryCuisineNames, Set<Cuisine> currentCuisines){
        Set<String> currentCuisineNames= new HashSet<>();
        if (currentCuisines.isEmpty()){
            return Boolean.FALSE;
        }

        for(Cuisine cuisine:currentCuisines){
            currentCuisineNames.add(cuisine.getCuisineName());
        }

        if(currentCuisineNames.containsAll(mandatoryCuisineNames)){
            return Boolean.TRUE;
        }else {
            return Boolean.FALSE;
        }
    }

    public boolean cuisineShouldContainSnacks(String cuisineName, List<String> mandatorySnacks){
        Cuisine cuisine= new Cuisine(cuisineName);
        Map<Cuisine,List<String>> currentSnacks= findAllSnacks();
        if (currentSnacks.get(cuisine).isEmpty()){
            return Boolean.FALSE;
        }
        return currentSnacks.get(cuisine).containsAll(mandatorySnacks);
    }
}
