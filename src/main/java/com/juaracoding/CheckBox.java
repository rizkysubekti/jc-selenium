package com.juaracoding;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

    public class CheckBox {
        public static void main(String[] args) {
            System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            driver.manage().window().maximize();
            driver.get("https://demoqa.com/checkbox");
            System.out.println("Open Browser URL");

            driver.findElement(By.cssSelector("#tree-node > ol > li > span > button > svg")).click();
            js.executeScript("window.scrollBy(0,300)");
            driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li:nth-child(3) > span > label > span.rct-checkbox > svg")).click();
            System.out.println("Checkbox clicked");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            driver.quit();
            System.out.println("Exit Browser");

        }

    }