package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "D:\\2AutomationCourseJava\\chromedriver.exe");

        ChromeOptions c = new ChromeOptions();
        c.addArguments("--lang=en-us");

        WebDriver w = new ChromeDriver(c);
        w.get("http://google.com");
        WebElement s = w.findElement(By.name("q"));
        s.sendKeys("java");
        WebElement b = w.findElement(By.name("btnG"));
        b.click();

        while (w.findElements(By.id("rso")).size() == 0);
        WebElement r = w.findElement(By.id("rso"));

        WebElement a = r.findElement(By.tagName("a"));

        String ah = a.getAttribute("href");

        if (ah.equals("https://www.java.com/ru/")) {
            System.out.println("Test 1 passed");
        } else {
            System.out.println("Test 1 failed");
        }

        a.click();

        String t = w.getTitle();

        if (t.equals("java.com: Java и вы")) {
            System.out.println("Test 2 passed");
        } else {
            System.out.println("Test 2 failed");
        }

        w.quit();
    }
}
