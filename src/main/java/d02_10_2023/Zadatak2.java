package d02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://itbootcamp.rs/");

        driver.manage().window().maximize();

        new Actions(driver).moveToElement(driver.findElement(By.id("menu-item-6408")))
                .build()
                .perform();

        wait.withMessage("Dropdown menu didnt show.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.dropdown-menu")));


        new Actions(driver).moveToElement(driver.findElement(By.id("menu-item-5362")))
                .build()
                .perform();

        wait.withMessage("Dropdown menu didnt show.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#menu-item-5362 > ul")));

        new Actions(driver).moveToElement(driver.findElement(By.id("menu-item-5453")))
                .build()
                .perform();

        wait.withMessage("Dropdown menu didnt show.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#menu-item-5453 > ul")));




    }
}
