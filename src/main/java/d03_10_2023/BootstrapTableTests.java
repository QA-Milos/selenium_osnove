package d03_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.List;

public class BootstrapTableTests {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @BeforeMethod
    public void beforeMethod(){
        driver.get("https://s.bootsnipp.com/iframe/K5yrx");
    }

    @Test
    public void editRow(){
        Assert.assertEquals(driver.getTitle(),"Table with Edit and Update Data - Bootsnipp.com",
                "Title doesn't match");
        driver.findElement(By.cssSelector("button[type]")).click();

        wait.withMessage("Modal not visible.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#edit")));

        driver.findElement(By.id("fn")).clear();
        driver.findElement(By.id("fn")).sendKeys("Legenda");

        driver.findElement(By.id("ln")).clear();
        driver.findElement(By.id("ln")).sendKeys("Nad");

        driver.findElement(By.id("mn")).clear();
        driver.findElement(By.id("mn")).sendKeys("Legendama");

        driver.findElement(By.id("up")).click();

        wait.withMessage("Modal is still visible.")
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#edit")));

        String firstName = driver.findElement(By.id("f1")).getText();
        String lastName = driver.findElement(By.id("l1")).getText();
        String middleName = driver.findElement(By.id("m1")).getText();

        Assert.assertEquals(firstName, "Legenda", "First name shouldn't be " + firstName);
        Assert.assertEquals(lastName, "Nad", "Last name shouldn't be " + lastName);
        Assert.assertEquals(middleName, "Legendama", "Middle name shouldn't be " + middleName);

    }
    @Test
    public void deleteRow(){
        Assert.assertEquals(driver.getTitle(),"Table with Edit and Update Data - Bootsnipp.com",
                "invalid title");
        driver.findElement(By.cssSelector("button.delete")).click();
        wait.withMessage("Modal didn't appear")
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#delete")));
        driver.findElement(By.cssSelector("button#del")).click();

        List<WebElement>rows = driver.findElements(By.cssSelector("tbody tr td"));
        Assert.assertEquals(rows, 6, "Number of divs didnt match");
    }
    @Test
    public void takeAScreenshot() throws IOException {
        Assert.assertEquals(driver.getTitle(),"Table with Edit and Update Data - Bootsnipp.com",
                "invalid title");
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        Files.copy(file.toPath(), new File
                ("C:\\Users\\josif\\OneDrive\\Desktop\\projektins\\selenium_osnove\\screenshots\\screenshot2.jpg")
                .toPath());
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
