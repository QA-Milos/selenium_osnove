package p25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://cms.demo.katalon.com/");

//        div#content > aside > section > form > label > input

        driver.findElement(By.cssSelector("div#content > aside > section > form > label > input")).sendKeys("Flying Ninja");
        driver.findElement(By.cssSelector("div#content > aside > section > form > button")).click();

        Thread.sleep(5000);

        driver.quit();


    }
}
