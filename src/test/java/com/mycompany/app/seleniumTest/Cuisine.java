package com.mycompany.app.seleniumTest;

import org.openqa.selenium.WebElement;

/**
 */
public class Cuisine {
    private String name;

    public Cuisine(String name){
        this.name=name;
    }

    @Override
    public boolean equals(Object anObject){
        if(!(anObject instanceof Cuisine)){
            return false;
        }
        if(anObject==this){
            return true;
        }
        Cuisine other = (Cuisine)anObject;
        if (this.name==null? other.name!=null : !this.name.equals(other.name)){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode(){
        int prime=83;
        int hash=5;
        hash= prime*hash + (this.name==null ? 0 : name.hashCode());
        return hash;
    }

    public String getCuisineName(){
        return name;
    }
}