package com.cybertek.test.day_7_typesof_element;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisableElements {
    @Test
    public void test2(){
        WebDriver driver= WebDriverFactory.getdriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");


        WebElement greenbutton=driver.findElement(By.cssSelector("#green"));

        //how to check any web element is enable to or not?

        greenbutton.click();
        System.out.println("greenbutton.isEnabled() = " + greenbutton.isEnabled());

        Assert.assertFalse(greenbutton.isEnabled(),"greem button is not  enable");

    }


    @Test
    public void test3(){
        WebDriver driver= WebDriverFactory.getdriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement inputbox=driver.findElement(By.cssSelector("#input-example>input"));
        inputbox.sendKeys("some kesys");
    }
}
