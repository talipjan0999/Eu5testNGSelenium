package com.cybertek.test.day_7_typesof_element;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DisplayedDemo {
    @Test
    public void test1(){
        WebDriver driver= WebDriverFactory.getdriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

       /* WebElement username=driver.findElement(By.id("username"));
        System.out.println("username.isDisplayed() = " + username.isDisplayed());*/
    }
}
