package com.cybertek.test.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndUrl {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
        String title=driver.getTitle();
        System.out.println("titile:"+title);

        String cuurenturl=driver.getCurrentUrl();
        System.out.println("currenturl:"+cuurenturl);

        String pagesource=driver.getPageSource();
        System.out.println("pagesource:"+pagesource);
    }
}
