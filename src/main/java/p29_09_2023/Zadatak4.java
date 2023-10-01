package p29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak4 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");

        driver.findElement(By.id("basic-primary-trigger")).click();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait
                .withMessage("Element se pojavio")
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("basic-primary-example")));

        wait
                .withMessage("Element se izgubio")
                .until(ExpectedConditions.invisibilityOfElementLocated(By.id("basic-primary-example")));

        driver.findElement(By.id("basic-primary-trigger")).click();

        wait
                .withMessage("Element se pojavio")
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("basic-primary-example")));

        driver.findElement(By.cssSelector("div#basic-primary-example button")).click();

        wait
                .withMessage("Element se izgubio")
                .until(ExpectedConditions.invisibilityOfElementLocated(By.id("basic-primary-example")));

    }
}
