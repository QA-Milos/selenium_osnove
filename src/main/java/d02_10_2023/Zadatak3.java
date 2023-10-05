package d02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Zadatak3 {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demoqa.com/broken");

        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("a:nth-child(10)")).click();


        URL url = new URL(driver.getCurrentUrl());
        HttpURLConnection http = (HttpURLConnection)url.openConnection();

        int status = http.getResponseCode();

        System.out.println(status);

        driver.navigate().to("https://demoqa.com/broken");

        driver.findElement(By.cssSelector("a:nth-child(14)")).click();

        URL url2 = new URL(driver.getCurrentUrl());
        HttpURLConnection http2 = (HttpURLConnection)url2.openConnection();

        int status2 = http2.getResponseCode();

        System.out.println(status2);

        Assert.assertEquals(status,status>=200&&status<400, "nevalidan status");

        Assert.assertEquals(status2,status>=200&&status<400, "nevalidan status");

        driver.quit();


    }
}
