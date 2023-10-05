package d02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you");

        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("img.edit-image")).click();

        driver.findElement(By.id("image-option-remove")).click();

        driver.findElement(By.cssSelector("img.edit-image")).click();


        File uploadFile =new File("downloads/ljuti-lav.jpg");
        driver.findElement(By.cssSelector("input[type]")).sendKeys(uploadFile.getAbsolutePath());

        wait.withMessage("Image wasn't uploaded. ")
                        .until(ExpectedConditions.presenceOfElementLocated(By.id("image-option-0")));

        driver.findElement(By.cssSelector("div.sc-brKeYL")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[type]"))).click();

        Thread.sleep(2000);

        driver.findElement(By.cssSelector("img.edit-image")).click();


        File uploadFile2 =new File("downloads/ljuti-pas.jpg");
        driver.findElement(By.cssSelector("input[type]")).sendKeys(uploadFile2.getAbsolutePath());

        wait.withMessage("Image wasn't uploaded. ")
                .until(ExpectedConditions.numberOfElementsToBe(By.className("sc-gLDzan"), 2));

        driver.findElement(By.cssSelector("div.sc-brKeYL")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[type]"))).click();

        Thread.sleep(2000);

        driver.findElement(By.cssSelector("img.edit-image")).click();

        File uploadFile3 =new File("downloads/sad-pepe.jpg");
        driver.findElement(By.cssSelector("input[type]")).sendKeys(uploadFile3.getAbsolutePath());

        wait.withMessage("Image wasn't uploaded. ")
                .until(ExpectedConditions.numberOfElementsToBe(By.className("sc-gLDzan"), 3));



        driver.findElement(By.cssSelector("div.sc-brKeYL")).click();

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        Thread.sleep(2000);

        driver.findElement(By.cssSelector("img.edit-image")).click();

        File uploadFile4 =new File("downloads/think-meme.jpg");
        driver.findElement(By.cssSelector("input[type]")).sendKeys(uploadFile4.getAbsolutePath());

        wait.withMessage("Image wasn't uploaded. ")
                .until(ExpectedConditions.numberOfElementsToBe(By.className("sc-gLDzan"), 4));



        driver.findElement(By.cssSelector("div.sc-brKeYL")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[type]"))).click();

        Thread.sleep(2000);

        wait.withMessage("Next button isn't clickable.")
                        .until(ExpectedConditions.elementToBeClickable(By.id("next-button"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("textareaID"))).sendKeys("lmao");


        driver.findElement(By.id("next-button")).click();

        driver.findElement(By.id("next-button")).click();

        driver.findElement(By.id("next-button")).click();

        Thread.sleep(5000);


        driver.quit();

    }
}
