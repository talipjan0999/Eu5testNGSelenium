package com.cybertek.test.homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class testcase1 {


    @Test
    public void testcase1(){
        WebDriver driver= WebDriverFactory.getdriver("chrome");
        driver.get("https://www.ebay.it/");
        driver.manage().window().maximize();

        WebElement serachbutton=driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']"));
        serachbutton.click();

        WebElement acceptcookies=driver.findElement(By.xpath("//button[@id='gdpr-banner-accept']"));
        acceptcookies.click();

        serachbutton.sendKeys("uyghur");
        WebElement cercobutton=driver.findElement(By.xpath("//*[@class='btn btn-prim gh-spr']"));
        cercobutton.click();

         WebElement results=driver.findElement(By.xpath("//*[@*='srp-controls__count-heading']"));


          String resultsText=results.getText();
        System.out.println("resultsText = " + resultsText);

        String expectedresults="resultsText = 569 risultati per uyghur";
        if(expectedresults.equals(resultsText)){
            System.out.println("pass");
        }else {
            System.out.println("fail");
            System.out.println("expectedresults = " + expectedresults);
            System.out.println("resultsText = " + resultsText);
        }



       driver.close();
    }


    @Test
    public void test2(){
        WebDriver driver= WebDriverFactory.getdriver("chrome");
        driver.get("https://www.ebay.it/");
        driver.manage().window().maximize();

        WebElement serachbutton=driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']"));
        serachbutton.click();

        WebElement acceptcookies=driver.findElement(By.xpath("//button[@id='gdpr-banner-accept']"));
        acceptcookies.click();

        serachbutton.sendKeys("selenium");
        WebElement cercobutton=driver.findElement(By.xpath("//*[@class='btn btn-prim gh-spr']"));
        cercobutton.click();

        WebElement results=driver.findElement(By.xpath("//*[@*='srp-controls__count-heading']"));


        String resultsText=results.getText();
        System.out.println("resultsText = " + resultsText);

        String expectedresults="resultsText = 569 risultati per uyghur";
        if(expectedresults.equals(resultsText)){
            System.out.println("pass");
        }else {
            System.out.println("fail");
            System.out.println("expectedresults = " + expectedresults);
            System.out.println("resultsText = " + resultsText);
        }



        driver.close();
    }

    @Test

    public void testcase3() throws InterruptedException {
          WebDriver driver = WebDriverFactory.getdriver("chrome");
          driver.get("https://www.wikipedia.org/");
          driver.manage().window().maximize();

          WebElement searchbuttom = driver.findElement(By.xpath("//input[@*='searchInput']"));
          searchbuttom.click();

          searchbuttom.sendKeys("seleinum(webdriver)");

          WebElement cercoButton = driver.findElement(By.xpath("//button[@type='submit']"));
          cercoButton.click();


          Thread.sleep(2000);

          WebElement cleanmark = driver.findElement(By.xpath("//span[@class='oo-ui-indicatorElement-indicator oo-ui-indicator-clear']"));
          cleanmark.click();

          WebElement secondsearchbutton = driver.findElement(By.xpath("//input[@type='search']"));
          secondsearchbutton.click();

          secondsearchbutton.sendKeys("selenium(software)");
          driver.findElement(By.xpath("//button[@type='submit']/span[2]")).click();


        /*String results=driver.findElement(By.xpath("//p[@class='mw-search-exists']/b")).getText();
        System.out.println("results = " + results); */


         }


         @Test
    public void  test4(){


            WebDriver driver=WebDriverFactory.getdriver("chrome");
            driver.get(" http://practice.cybertekschool.com/forgot_password");
            driver.manage().window().fullscreen();


            WebElement homebuttom=driver.findElement(By.xpath("//a[@class='nav-link']"));
            WebElement  forgot_password=driver.findElement(By.xpath("//div[@class='example']/h2"));
            WebElement  E_mailtext=driver.findElement(By.xpath("//label[@for='email']"));
            WebElement E_mailTextbox=driver.findElement(By.xpath("//input[@type='text']"));
             WebElement retrivepassword=driver.findElement(By.xpath("//i[@class='icon-2x icon-signin']"));


         }

    }

