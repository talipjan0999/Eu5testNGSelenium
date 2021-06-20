package com.cybertek.test.day8_type_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListofElements {

    WebDriver driver ;

    @BeforeMethod
    public void setUp() {
          driver = WebDriverFactory.getdriver("chrome");

     }

    @AfterMethod
    public  void teardown(){
         driver.quit();

    }


    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        //save our web elements inside the
        //option(or commant) + enter show list of wets
        List<WebElement> elements = driver.findElements(By.tagName("button"));
        System.out.println("element.size() = " + elements.size());
        Assert.assertEquals(elements.size(),6,"verify button size");
        //iter + enter to get each loop with shortcut
        for (WebElement buttons : elements) {
            //System.out.println(buttons.getText());

            System.out.println("buttons.isDisplayed() = " + buttons.isDisplayed());
            Assert.assertTrue(buttons.isDisplayed(),"verify button are displayed");


            //click second button
            elements.get(1).click();


        }





    }
    @Test
    public  void test2(){
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
         //driver.findElement(By.tagName("buttonhklppkl"));
        List<WebElement> buttons = driver.findElements(By.tagName("buttonhklppkl"));
        //pasing locator with does not exit. it will not throw nosuchelement
        System.out.println("buttons.size() = " + buttons.size());


    }

}
