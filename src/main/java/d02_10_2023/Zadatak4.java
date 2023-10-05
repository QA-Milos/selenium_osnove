package d02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.time.Duration;
import java.util.List;

public class Zadatak4 {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://itbootcamp.rs/");

        driver.manage().window().maximize();

        new Actions(driver).scrollToElement(driver.findElement(By.cssSelector("div.owl-stage"))).build()
                .perform();

        List<WebElement>linkovi = driver.findElements(By.cssSelector("div.owl-stage img"));

        for (int i = 0; i < linkovi.size() ; i++) {
            String link = linkovi.get(i).getAttribute("src");
            System.out.println(link);
            URL url = new URL(link);
            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            int status = http.getResponseCode();
            if (status>=200 && status<300){
                try {
                    downloadUsingNIO(linkovi.get(i).getAttribute("src") ,"itbootcamp_slider/"+ i +".png");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }

        driver.quit();
    }
    public static void downloadUsingNIO(String urlStr, String file) throws IOException {
        URL url = new URL(urlStr);
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream(file);
        fos.getChannel().transferFrom(rbc,0, Long.MAX_VALUE);
        fos.close();
        rbc.close();
    }
}
