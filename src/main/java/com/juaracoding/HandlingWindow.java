package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class HandlingWindow {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Open Browser URL");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");

        //web scrapping
        String textTitle = driver.findElement(By.className("text-center")).getText();
        System.out.println(textTitle);

        WebElement btnNewTab = driver.findElement(By.id("tabButton"));
        btnNewTab.click();

        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
        String currentUrl = driver.getCurrentUrl(); //actual
        String expected = "https://demoqa.com//sample";
        System.out.println(currentUrl);

        //Assert IF
        customAssertEquals(currentUrl,expected);


        delay(3);
        driver.switchTo().window(newTab.get(0));
        String tabTitle = driver.getTitle();
        String expectedTitle = "DEMOQA";
        System.out.println(tabTitle);

        //Assert use IF
        customAssertEquals(currentUrl,expected);


        delay(3);
        driver.quit();
        System.out.println("Exit Browser");
    }

    public static void delay(long detik){
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void customAssertEquals(String actual, String expected){
    System.out.print("Test Result: ");
    if(actual.equals(expected)){
        System.out.println("Passed");
    } else {
        System.out.println("Failed");
    }
}
}


////Challengeeeeeeee Assert use IF pakai boolean condition
//        System.out.println("Test Result");
//boolean condition = currentUrl.contains("https://demoqa.com/sample");
//        if (condition){
//        System.out.println("Passed");
//        } else {
//                System.out.println("Failed");
//            assert condition : "Test Failed";
//        }