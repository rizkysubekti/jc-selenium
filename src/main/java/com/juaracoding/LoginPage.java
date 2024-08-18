package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class LoginPage {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Open Browser URL");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");

        //web scrapping
        delay(3);
        WebElement companyBranding = driver.findElement(By.xpath("//img[@alt='company-branding']"));
        System.out.println(companyBranding.isDisplayed());

        //scenario Test Login Lakukan Assert
        delay(1);
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("login");

        String txtDashboard = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).getText();
        String expected    = "Dashboard";
        customAssertEquals(txtDashboard,expected);

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

