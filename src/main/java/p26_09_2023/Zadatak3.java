package p26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak3 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://s.bootsnipp.com/iframe/z80en");

        driver.manage().window().maximize();

        List<WebElement> elementi = driver.findElements(By.cssSelector("#lorem table > tbody > tr > td"));

        for (int i = 0; i < elementi.size(); i++) {
            if (i % 3 == 0){
                System.out.println();
            }
            System.out.print(elementi.get(i).getText() + " ");

        }

        driver.quit();
    }
}
