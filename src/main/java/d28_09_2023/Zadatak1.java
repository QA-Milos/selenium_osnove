package d28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://github.com/orgs/embedly/repositories?q=&type=all&language=&sort=");

        driver.manage().window().maximize();


        driver.findElement(By.className("dropdown-caret")).click();

        driver.findElement(By.cssSelector("label.SelectMenu-item:nth-child(2)")).click();


        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#org-repositories a"))).click();
//        driver.findElement(By.linkText("https://github.com/orgs/embedly/repositories")).click();

        driver.quit();


    }
}
