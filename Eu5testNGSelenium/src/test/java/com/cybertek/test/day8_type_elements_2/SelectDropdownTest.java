package com.cybertek.test.day8_type_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropdownTest {
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
        driver.get("http://practice.cybertekschool.com/dropdown");
        //1.locate your dropdown just like any other webelemnt with unique locator
        WebElement dropdownelmen=driver.findElement(By.id("state"));
        //2.create select object  by passing that elment as a constructor
        Select statedropdown=new Select(dropdownelmen);
        List<WebElement> options = statedropdown.getOptions();
        System.out.println("options.size() = " + options.size());
        //print options one by one
        for (WebElement option : options) {
            System.out.println(option.getText());

        }

    }
    @Test
    public void test3() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        //1.locate your dropdown just like any other webelemnt with unique locator
        WebElement dropdownelmen = driver.findElement(By.id("state"));
        //2.create select object  by passing that elment as a constructor
        Select statedropdown = new Select(dropdownelmen);
        //verify that first selection is select a state
        String expectedoption="Select a State";
        String actualoption=statedropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualoption,expectedoption,"verify first selection");


        //how to select something from dropdown?
        //1.select usinf visiable text
        Thread.sleep(3000);
        statedropdown.selectByVisibleText("Virginia");
        expectedoption="Virginia";
        actualoption=statedropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualoption,expectedoption);

        //2.select using index
        Thread.sleep(2000);
        statedropdown.selectByIndex(50);
        expectedoption="wyoming";
        actualoption=statedropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualoption,expectedoption);

        Thread.sleep(2000);
        statedropdown.selectByIndex(51);
        expectedoption="wyoming";
        actualoption=statedropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualoption,expectedoption);


    }


    @Test
    public  void test4(){
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        //1.locate your dropdown just like any other webelemnt with unique locator
        WebElement dropdownelment = driver.findElement(By.cssSelector("#dropdownMenuLink"));
        //click the dropdown to see avialabe options
        dropdownelment.click();
        List<WebElement> dropdownelements = driver.findElements(By.className("dropdown-item"));
        //print the size of them
        System.out.println("dropdownelements.size() = " + dropdownelements.size());
        //print them one by one
        for (WebElement dropdownelement : dropdownelements) {
            System.out.println(dropdownelement.getText());

        }

            //click yahoo
        dropdownelements.get(2).click();
    }
}
