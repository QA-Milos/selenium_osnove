package p02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Zadatak5 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demoqa.com/broken");

        driver.findElement(By.cssSelector("div:nth-child(2) > a:nth-child(10)")).click();
        String url1 = driver.getCurrentUrl();

        driver.navigate().to("https://demoqa.com/broken");

        driver.findElement(By.cssSelector("div:nth-child(2) > a:nth-child(14)"));
        String url2 = driver.getCurrentUrl();
    }


    public static int getHTTPResponseStatusCode(String u) throws IOException, IOException {

        URL url = new URL(u);
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        return http.getResponseCode();
    }
}
