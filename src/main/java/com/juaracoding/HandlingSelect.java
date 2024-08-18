package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.nio.channels.Selector;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static com.juaracoding.HandlingWindow.delay;

public class HandlingSelect {

    public static Object getDelay() {
        return delay;
    }

    static Object delay;
    private static Object detik;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\MyTools\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        ;
        driver.get("https://demoqa.com/select-menu");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Open Browser URL");

        // web scraping
        String txtTitle = driver.findElement(By.className("text-center")).getText();
        System.out.println(txtTitle);

        // Select Old Style
        WebElement selectColor = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(selectColor);
        select.selectByIndex(1); // Blue
        delay(1);
        select.selectByValue("8");
        delay(1);
        select.deselectByVisibleText("Aqua");

        // Select New Style
        WebElement optionGroup = driver.findElement(By.id("withOptGroup"));
        optionGroup.click();
        optionGroup.sendKeys(Keys.ARROW_DOWN);
        optionGroup.sendKeys(Keys.ENTER);


        delay(3);

        driver.quit();


    }

    private static void delay(Object detik) {
    }


}



