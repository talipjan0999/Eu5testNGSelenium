package com.cybertek.test.day6_css;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class css_Locator {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getdriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
         WebElement dontclikc= driver.findElement(By.cssSelector("button#disappearing_button"));
        System.out.println("dontclikc.getText() = " + dontclikc.getText());

        Thread.sleep(1000);
        driver.quit();
    }
}
