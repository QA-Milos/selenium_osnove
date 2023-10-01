package p29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        driver.get("https://youtube.com");

        driver.manage().window().maximize();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));


        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input#search"))).sendKeys("Breskvica");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#search"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul.sbsb_b li:nth-child(4)"))).click();









        driver.quit();
    }
}
