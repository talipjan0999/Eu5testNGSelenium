package com.cybertek.test.day1_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class openbrower {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://open.spotify.com/playlist/37i9dQZF1DX0yHwYvqyUJQ");
        //for the make lines code coomand ,hold on command bottom plus question mark in keyboadr
    }
}
