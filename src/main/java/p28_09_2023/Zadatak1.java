package p28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/modal-dialogs");

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.id("showLargeModal")).click();

        WebElement largeModal = null;

        boolean sePojavio = true;

        try {
            largeModal = driver.findElement(By.cssSelector("div.modal-content"));

        }catch (Exception e){

            sePojavio = false;

        }


        if (sePojavio){
            System.out.println("Large modal se prikazao");
        }else System.out.println("Nije se prikazao");




        driver.quit();
    }
}
