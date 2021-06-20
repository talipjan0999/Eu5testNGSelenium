package com.cybertek.test.day9_poppups_frams;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class popusAndAlrts {
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
        driver.get("http://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//span[@class='ui-button-icon-left ui-icon ui-c pi pi-check']")).click();
        driver.findElement(By.xpath("//button[.='No'")).click();
    }
   @Test
    public void test2() throws InterruptedException {
       driver.get("http://practice.cybertekschool.com/javascript_alerts");
       driver.findElement(By.xpath("//button[1]")).click();
       //switch to js alert pop up
       Alert alert=driver.switchTo().alert();
       Thread.sleep(2000);
       alert.accept();


       driver.findElement(By.xpath("//button[2]")).click();
       Thread.sleep(2000);
       alert.dismiss();

       //click for js promt
       driver.findElement(By.xpath("//button[3]")).click();
       alert.sendKeys("murat");
       alert.accept();
   }

}
