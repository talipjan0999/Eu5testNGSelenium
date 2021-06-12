package com.cybertek.test.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getdriver("chrome");
        driver.get("https://www.Amazon.com");
        driver.manage().window().maximize();

        WebElement searchbutton=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchbutton.click();
        searchbutton.sendKeys("selenium");

        driver.findElement(By.xpath("//input[@type='submit'] [@class='nav-input nav-progressive-attribute']")).click();
       WebElement results=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
       String resultText=results.getText();
        System.out.println("resultsText=: "+resultText);

        String expectedresult="resultsText=: 1-48 of 183 results for \"selenium\"";
        if(expectedresult.equals(resultText)){
            System.out.println("pass");
        }else{
            System.out.println("fall");
            System.out.println("expectedresult= "+expectedresult);
            System.out.println("realresults= "+resultText);
        }

        driver.quit();

    }
}
