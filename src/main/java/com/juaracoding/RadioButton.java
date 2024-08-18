package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\MyTools\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/radio-button");
        System.out.println("Open Browser URL");

        driver.findElement(By.cssSelector("#app > div > div > div > div.col-12.mt-4.col-md-6 > div:nth-child(3) > div:nth-child(2) > label")).click();
        System.out.println("Radio Button clicked");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
        System.out.println("Exit Browser");

    }

}
