package p25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/text-box");

        for (int i = 0; i < 3; i++) {
            driver.findElement(By.cssSelector("input#userName")).sendKeys("Neko Nesto");
            driver.findElement(By.cssSelector("input#userEmail")).sendKeys("dsadasdads@gmail.com");
            driver.findElement(By.xpath("//textarea[contains(@placeholder,'Current Address')]"))
                    .sendKeys("Bul Oslobodjenja 43");
            driver.findElement(By.xpath("//textarea[@id = 'permanentAddress']"))
                    .sendKeys("Bul Oslobodjenja 43");
            driver.findElement(By.cssSelector("button#submit")).click();
            Thread.sleep(2000);
            driver.navigate().refresh();
        }
        driver.quit();
    }
}
