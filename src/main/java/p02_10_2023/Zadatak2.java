package p02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        driver.manage().window().maximize();


        File uploadFile =new File("test_data/ljuti-lav.jpg");

        driver.findElement(By.name("files[]"))
                .sendKeys(uploadFile.getAbsolutePath());

        wait.withMessage("Fajl nije pripremljen")
                .withTimeout(Duration.ofSeconds(15))
                .until(ExpectedConditions.textToBe(By.cssSelector("p.name"),"ljuti-lav.jpg"));


        List<WebElement>uplaoaded = driver.findElements(By.cssSelector("tbody tr"));

        if (!uplaoaded.isEmpty()){

            driver.findElement(By.cssSelector("button[type='submit']")).click();

        }else {
            System.out.println("Nope.");
        }


//        driver.findElement(By.cssSelector("button[type='submit']")).click();





    }
}
