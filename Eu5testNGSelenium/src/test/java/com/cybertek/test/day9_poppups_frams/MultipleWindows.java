package com.cybertek.test.day9_poppups_frams;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {
    WebDriver driver ;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getdriver("chrome");

    }

    @AfterMethod
    public  void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();

    }


    @Test
    public void test1() {
        driver.get("http://practice.cybertekschool.com/windows");
        driver.findElement(By.linkText("Click Here")).click();
        System.out.println("Title after new window: " + driver.getTitle());
        String currentWindowhandle=driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles) {
            if (!handle.equals(currentWindowhandle)){
                driver.switchTo().window(handle);
            }

        }
        System.out.println("driver.getTitle() = " + driver.getTitle());

    }
    @Test
    public void morethen2windows(){
        driver.get("http://practice.cybertekschool.com/windows");
        driver.findElement(By.linkText("Click Here")).click();
        System.out.println("Title after new window: " + driver.getTitle());
        String currentWindowhandle=driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        //loop trhough each window
        for (String handle : windowHandles) {
            //one by one change it
            driver.switchTo().window(handle);
            //whenever your titile equales to your expected window titile
            if(driver.getTitle().equals("new window")){
                break;
            }

        }
        System.out.println("after switch" + driver.getTitle());


        








    }

}
