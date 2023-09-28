package p28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        TestHelper helper = new TestHelper(driver);

        helper.setDefaultImplicitlyWait();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://demoqa.com/modal-dialogs");



        if (helper.elementExists((By.id("showLargeModal")))){

            driver.findElement(By.id("showLargeModal")).click();

        }

        if (!helper.elementExists((By.cssSelector("div.modal-content")))){
            System.out.println("Nije se pojavio");
        }else System.out.println("Pojavio se");

        driver.quit();

    }
}
