package com.cybertek.test.day_7_typesof_element;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Radio_Button_Test {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getdriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();


        WebElement blueRadio_button=driver.findElement(By.cssSelector("#blue"));
        WebElement redRadio_button=driver.findElement(By.cssSelector("#red"));

        System.out.println("blueRadio_button.isSelected() = " + blueRadio_button.isSelected());
        System.out.println("redRadio_button.isSelected() = " + redRadio_button.isSelected());

        Assert.assertTrue(blueRadio_button.isSelected(),"verify that blue is selected");
        Assert.assertFalse(redRadio_button.isSelected(),"verify red button is not selected");


        redRadio_button.click();


        Assert.assertFalse(blueRadio_button.isSelected(),"verify that blue is not selected");
        Assert.assertTrue(redRadio_button.isSelected(),"verify red button is  selected");

        Thread.sleep(2000);
        driver.quit();


    }

}
