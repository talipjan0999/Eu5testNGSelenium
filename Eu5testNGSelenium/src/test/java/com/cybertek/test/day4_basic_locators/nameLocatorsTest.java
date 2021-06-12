package com.cybertek.test.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocatorsTest {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getdriver("chrome");

        //make browser fullscreen
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");
        //proper way

        /*WebElement fullNameInput=driver.findElement(By.name("full_name"));
        fullNameInput.sendKeys("talipjan");

        WebElement emailButton=driver.findElement(By.name("email"));
        emailButton.sendKeys("talipjan0999@gmail.com"); */



        //lazy way
        driver.findElement(By.name("full_name")).sendKeys("talipjan");
        driver.findElement(By.name("email")).sendKeys("talipjan0999@gmail.com");

        WebElement sign_upButton=driver.findElement(By.name("wooden_spoon"));
        sign_upButton.click();
    }
}
