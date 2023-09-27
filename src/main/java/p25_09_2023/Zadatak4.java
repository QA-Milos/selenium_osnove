package p25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/webtables");

        driver.findElement(By.cssSelector("span#edit-record-1")).click();
        driver.findElement(By.cssSelector("input#firstName")).sendKeys("Milos");
        driver.findElement(By.cssSelector("input#lastName")).sendKeys("Josifovic");
        driver.findElement(By.cssSelector("input#userEmail")).sendKeys("jsoasfahfui@gmail.com");
        driver.findElement(By.cssSelector("input#age")).sendKeys("39");
        driver.findElement(By.cssSelector("input#salary")).sendKeys("100000");
        driver.findElement(By.cssSelector("input#department")).sendKeys("insurance");
        driver.findElement(By.cssSelector("button#submit")).click();

        Thread.sleep(2000);

        driver.quit();


    }
}
