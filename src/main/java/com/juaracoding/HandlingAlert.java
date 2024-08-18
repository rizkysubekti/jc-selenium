package com.juaracoding;

import okio.Timeout;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HandlingAlert {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/alerts");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Open Browser URL");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");

        //web scrapping
        String textTitle = driver.findElement(By.className("text-center")).getText();
        System.out.println(textTitle);

        driver.findElement(By.id("alertButton")).click();
        delay(1);
        driver.switchTo().alert().accept();
        System.out.println("Alert Button");

        driver.findElement(By.id("timerAlertButton")).click();
        delay(7);
        driver.switchTo().alert().accept();
        System.out.println("Timer Alert Button");


        //confirmButton promptButton
        driver.findElement(By.id("confirmButton")).click();
        delay(1);
        driver.switchTo().alert().accept();
        System.out.println("Confirm Button");

        driver.findElement(By.id("promtButton")).click();
        delay(3);
//        driver.switchTo().alert().dismiss();
        driver.switchTo().alert().sendKeys("Indonesia");
        driver.switchTo().alert().accept();
        System.out.println("Promt Button");


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

