package d28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak5 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("http://seleniumdemo.com/?product=bdd-cucumber");


        driver.manage().window().maximize();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.woocart, cart-contents"))).click();

        driver.findElement(By.cssSelector("a.woocart, cart-contents")).click();

        wait.until(ExpectedConditions.titleIs("Cart – Selenium Demo Page"));

        WebElement cartStatus = driver.findElement(By.cssSelector("p.cart-empty"));
        String cartStatusText = cartStatus.getText();

        if (cartStatusText.equals("Your cart is currently empty.")) {
            System.out.println("Provera uspešna. Stanje korpe je prazno.");
        } else {
            System.out.println("Provera neuspešna. Stanje korpe nije prazno.");
        }

        driver.quit();

    }
}
