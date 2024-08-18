package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HandlingFrames {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/frames");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Open Browser URL");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");

        //web scrapping
        String textTitle = driver.findElement(By.className("text-center")).getText();
        System.out.println(textTitle);

        //switch to frames
        WebElement frame1 = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frame1);

        //sampleHeading
        String txtSampleHeading = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(txtSampleHeading);

        //default content
        driver.switchTo().defaultContent();

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
}
