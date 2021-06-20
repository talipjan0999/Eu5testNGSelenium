package com.cybertek.test.day_7_typesof_element;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Checkboxes {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver= WebDriverFactory.getdriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement checkboxe_1=driver.findElement(By.cssSelector("#checkboxes>input:nth-of-type(1)"));
        WebElement checkboxe_2=driver.findElement(By.cssSelector("#checkboxes>input:nth-of-type(2)"));
        System.out.println("checkboxe_1.isSelected() = " + checkboxe_1.isSelected());
        System.out.println("checkboxe_2.isSelected() = " + checkboxe_2.isSelected());
        //verify chechbox1 is not selected


        Assert.assertFalse(checkboxe_1.isSelected(),"checkbox_1 is not selected");
        Assert.assertTrue(checkboxe_2.isSelected(),"checkbox2 is selected");

        checkboxe_1.click();

        Assert.assertTrue(checkboxe_1.isSelected(),"checkbox_1 is  selected");
        Assert.assertTrue(checkboxe_2.isSelected(),"checkbox2 is selected");

        System.out.println("checkboxe_1.isSelected() = " + checkboxe_1.isSelected());
        System.out.println("checkboxe_2.isSelected() = " + checkboxe_2.isSelected());
        Thread.sleep(30000);
        driver.quit();


    }
}
