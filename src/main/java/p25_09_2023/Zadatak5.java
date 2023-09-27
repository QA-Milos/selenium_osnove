package p25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadatak5 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        ArrayList<String>urls = new ArrayList<>();

        urls.add("https://google.com/");
        urls.add("https://youtube.com/");
        urls.add("https://www.ebay.com/");
        urls.add("https://www.kupujemprodajem.com/");

        for (int i = 0; i < urls.size(); i++) {
            driver.get(urls.get(i));
            System.out.println(driver.getTitle());
        }
    }
}
