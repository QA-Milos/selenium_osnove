package d22_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        // Postavljanje ChromeDriver koristeći WebDriverManager
        WebDriverManager.chromedriver().setup();
        // Kreiranje instance ChromeDriver-a


        ArrayList<String> stranice = new ArrayList<>();

        String google = "https://www.google.com/";
        String facebook = "https://facebook.com";
        String youtube = "https://www.youtube.com/";
        String ebay = "https://www.ebay.com/";
        String katalon = "https://www.katalon.com/";

        stranice.add(google);
        stranice.add(facebook);
        stranice.add(youtube);
        stranice.add(ebay);
        stranice.add(katalon);


        for (int i = 0; i < stranice.size() ; i++) {
            WebDriver driver = new ChromeDriver();
            driver.get(stranice.get(i));
            Thread.sleep(1000);
            driver.quit();
        }





    }
}
