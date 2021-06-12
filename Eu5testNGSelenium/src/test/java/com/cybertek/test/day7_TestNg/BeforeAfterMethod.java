package com.cybertek.test.day7_TestNg;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class BeforeAfterMethod {
    @BeforeMethod
    public void setup(){
        System.out.println("webdriver,opening browser");
    }


    @AfterTest
    public void teardown0(){
        System.out.println("close the web browser");
    }
    @Test
    public void test0(){
        System.out.println("my threed test");

    }
    @Ignore
    @Test
    public void test1(){
        System.out.println("webdriver, opening browser");
        System.out.println("first test case");
        System.out.println("close browser");
    }



}
