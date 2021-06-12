package com.cybertek.test.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TagNameLocator {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getdriver("chrome");

        //make browser fullscreen
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");
        //proper way

        /*WebElement fullNameInput=driver.findElement(By.name("full_name"));
        fullNameInput.sendKeys("talipjan");

        WebElement emailButton=driver.findElement(By.name("email"));
        emailButton.sendKeys("talipjan0999@gmail.com"); */

        WebElement  fullaneminput=driver.findElement(By.tagName("input"));
        fullaneminput.sendKeys("talipjan osman");

        WebElement emailinput=driver.findElement(By.name("email"));
        emailinput.sendKeys("talipjan0999@gmail.com");
        driver.findElement(By.tagName("button")).click();
        Thread.sleep(3000);
        driver.quit();


    }
}
