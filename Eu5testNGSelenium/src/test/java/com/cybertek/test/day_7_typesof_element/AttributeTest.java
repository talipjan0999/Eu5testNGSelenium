package com.cybertek.test.day_7_typesof_element;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AttributeTest {

    @Test
    public void test1(){
        WebDriver driver= WebDriverFactory.getdriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();


        WebElement blueRadio_button=driver.findElement(By.cssSelector("#blue"));
        System.out.println(blueRadio_button.getAttribute("value"));
        System.out.println(blueRadio_button.getAttribute("name"));

        //since cheched does nt give any value, it will return true or false based on the value

        System.out.println(blueRadio_button.getAttribute("checked"));

        //when we use non exit attribute it will return to us null
        System.out.println(blueRadio_button.getAttribute("href"));

        System.out.println(blueRadio_button.getAttribute("outerHTML"));
        //it works in certain case
        System.out.println(blueRadio_button.getAttribute("innerHTML"));
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement BUTTON2=driver.findElement(By.name("button2"));
        System.out.println(BUTTON2.getAttribute("outerHTML"));

        String outerHTML=BUTTON2.getAttribute("outerHTML");
        Assert.assertTrue(outerHTML.contains("Button 2"));

        System.out.println(BUTTON2.getAttribute("innerHTML"));


        driver.quit();

    }
}
