package p28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.pool.TypePool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak3 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("file:///C:/Users/josif/Downloads/Zadatak4.html");

        driver.findElement(By.id("showInBtn")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.withMessage("SADSADsadsada")
                .until(ExpectedConditions.presenceOfElementLocated(By.id("id-0")));

        for (int i = 0; i < 5; i++) {
            driver.findElement(By.id("showInBtn")).click();
            wait.withMessage("SADSADsadsada")
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("id-" + i)));
        }




    }
}
