package com.juaracoding;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextBox {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
        System.out.println("Open Browser URL");

        //scroll 300px
        js.executeScript("window.scrollBy(0,300)");
        driver.findElement(By.id("userName")).sendKeys("JuaraCoding");
        driver.findElement(By.id("userEmail")).sendKeys("juaracoding@gmail.com");
        driver.findElement(By.id("currentAddress")).sendKeys("Jakarta");
        driver.findElement(By.id("permanentAddress")).sendKeys("Tangerang Selatan");
        driver.findElement(By.id("submit")).click();
        System.out.println("Input Data");


//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//          throw new   printStackTrace(e);
//        }
//        driver.quit();
//        System.out.println("Exit Browser");
    }
}
