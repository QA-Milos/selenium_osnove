package d25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://artplayer.org/");

        driver.manage().window().maximize();

        Thread.sleep(3000);

        driver.findElement(By.cssSelector("i.art-icon")).click();
        driver.findElement(By.cssSelector("div.art-controls-left div:nth-child(2) i")).click();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("div.art-controls-right i")).click();

        driver.findElement(By.cssSelector("div.art-control-pip i")).click();

        Thread.sleep(1000);

        driver.findElement(By.cssSelector("div.art-control-pip i")).click();

        driver.findElement(By.cssSelector("div.art-control-fullscreenWeb i "));

        driver.findElement(By.cssSelector("div.art-control-fullscreenWeb i:nth-child(2)"));

        Thread.sleep(5000);


        driver.quit();


    }
}
