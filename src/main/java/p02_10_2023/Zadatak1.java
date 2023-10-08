package p02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://tus.io/demo.html");

        driver.manage().window().maximize();

        new Actions(driver).scrollToElement(driver.findElement(By.id("P0-0"))).build()
                .perform();



        File uploadFile =new File("test_data/ljuti-lav.jpg");

        driver.findElement(By.id("P0-0"))
                .sendKeys(uploadFile.getAbsolutePath());



//        WebElement p = driver.findElement(By.cssSelector("p._heading_gq6c0_21")); // kad ga ovde uhvatis on nema ovaj text, kapiras?

        wait.withMessage("Fajl nije uploadovan.")
                .withTimeout(Duration.ofSeconds(20))
                .until(ExpectedConditions.textToBe((By.cssSelector("p._heading_gq6c0_21")),"The upload is complete!"));


        driver.quit();

    }
}
