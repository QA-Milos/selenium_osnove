package p02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

public class Zadatak4 {
    public static void main(String[] args) throws IOException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://google.com");

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        Files.copy(file.toPath(), new File
                ("C:\\Users\\josif\\OneDrive\\Desktop\\projektins\\selenium_osnove\\screenshots\\screenshot1.jpg")
                .toPath());

    }
}
