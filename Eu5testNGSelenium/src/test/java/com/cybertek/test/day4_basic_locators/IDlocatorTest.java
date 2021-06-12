package com.cybertek.test.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IDlocatorTest {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getdriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement dontClickButton=driver.findElement(By.id("disappearing_button"));
        dontClickButton.click();
        driver.quit();

       /* WebElement  button_2=driver.findElement(By.id("button_old"));
        button_2.click();   in this elment locators are dynamic  */

    }
}
