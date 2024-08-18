package com.juaracoding;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class HandlingModal {

    public static Object getDelay() {
        return delay;
    }

    static Object delay;
    private static Object detik;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\MyTools\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        String url = "http://demoqa.com/modal-dialog";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Open Browser URL");

        // web scraping
        String txtTitle = driver.findElement(By.className("text-center")).getText();
        System.out.println(txtTitle);

        js.executeScript("window.scrollBy(0,50)");
        // xpath = //
        WebElement showSmallModal = driver.findElement(By.xpath("//button@id='showSmallModal"));
        showSmallModal.click();
        String txtModalBody = driver.findElement(By.xpath("//div[@class='modal-body']")).getText();
        System.out.println(txtModalBody);
        // xpath contains = //
        WebElement closeSmallModal = driver.findElement(By.xpath("//button[contains(@id,'close')]"));
        closeSmallModal.click();

        delay(3);

        driver.quit();


    }

    private static void delay(Object detik) {
    }
}
