package com.juaracoding;

import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSelenium {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        System.out.println("Open Browser URL");


        driver.findElement(By.name("q")).sendKeys("selenium");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

//        try {
//            Thread.sleep(3000);
//            Thread.sleep(3000);
//            Thread.sleep(3000);

//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        driver.quit();
//        System.out.println("Exit Browser");
    }
}
