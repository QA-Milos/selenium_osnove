package p26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://s.bootsnipp.com/iframe/z80en");

        driver.manage().window().maximize();

        List<WebElement> redovi = driver.findElements(By.cssSelector("table > tbody > tr:nth-child(1) > td"));

        List<WebElement>kolone = driver.findElements(By.cssSelector("#lorem table > tbody > tr > td:nth-child(1)"));


        for (int i = 0; i < kolone.size() ; i++) {
            System.out.println(kolone.get(i).getText());
        }


        for (int i = 0; i < redovi.size(); i++) {
            System.out.println(redovi.get(i).getText());
        }
        Thread.sleep(5000);

        driver.quit();

//        driver.findElement(By.cssSelector("table > thead > tr > th")).getText();
//
//        driver.findElement(By.cssSelector("table > tbody > tr > td")).getText();
//
//        driver.findElement(By.cssSelector("table > tbody > tr:nth-child(2) > td")).getText();
//
//        driver.findElement(By.cssSelector("table > tbody > tr:nth-child(3) > td")).getText();


    }
}
