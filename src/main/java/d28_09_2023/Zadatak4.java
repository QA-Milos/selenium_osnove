package d28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak4 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://seleniumdemo.com/?post_type=product");


        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li.nav__search"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("s-651536d633c09"))).sendKeys("BDD Cucumber");



        driver.findElement(By.id("s-651536d633c09")).sendKeys(Keys.ENTER);


        wait.until(ExpectedConditions.attributeContains(By.cssSelector("a.czr-title"), "title", "BDD Cucumber"));













        driver.quit();
    }
}
