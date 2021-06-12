package com.cybertek.test.day2_webdriver_basics;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class CallWebDeriverFactory {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getdriver("chrome");
        driver.get("https://www.youtube.com");
        String titile=driver.getTitle();
        System.out.println("titile:"+titile);
    }
}
