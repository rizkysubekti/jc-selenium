package com.juaracoding;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HandlingList {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        String url = "https://demoqa.com/automation-practice-form";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Open Browser URL");

        // Web Scraping
        String txtTitle = driver.findElement(By.className("text-center")).getText();
        System.out.println(txtTitle);

        js.executeScript("window.scrollBy(0,50)");
        // Handling List
        List<WebElement> listGender = driver.findElements(By.xpath("//label[contains(@for,'gender-radio')]"));
        System.out.println(listGender.size());
        for (int i = 0; i < listGender.size(); i++) {
            System.out.println(listGender.get(i).getText());
            listGender.get(i).click();
            delay(1);
        }

        for(WebElement gender : listGender){
            System.out.println(gender.getText());
            gender.click();
            delay(1);
        }

        // lazy loading

        // upload gambar
        WebElement uploadPicture = driver.findElement(By.xpath("//input[@id='uploadPicture']"));
        uploadPicture.sendKeys("C://JuaraCoding//jc-selenium//src//main//java//com//juaracoding//asset//img4.jpg");

        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("info@email.com");
        delay(1);
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(Keys.CONTROL+"A");
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(Keys.DELETE);


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
