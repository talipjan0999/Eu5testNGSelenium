package com.cybertek.test.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class xpathLocator {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getdriver("chrome");
         driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement button2=driver.findElement(By.xpath("//*[@name='button2']"));
        button2.click();

        Thread.sleep(1000);
        driver.quit();
    }
}
