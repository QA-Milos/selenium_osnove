package p03_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Zadatak1 {

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
        driver.get("https://cms.demo.katalon.com");
    }
    @Test
    public void visitLoginPageFromNavBar(){
        driver.findElement(By.cssSelector("ul li:nth-child(3) a"))
                .click();
        Assert.assertEquals
                (driver.getTitle(), "My account – Katalon Shop", "Title should be 'My account – Katalon Shop'");

        Assert.assertEquals
                (driver.getCurrentUrl(), "https://cms.demo.katalon.com/my-account/",
                        "url should be 'https://cms.demo.katalon.com/my-account/'");



    }
    @Test
    public void checkInputTypes(){
        visitLoginPageFromNavBar();

        Assert.assertEquals(driver.findElement(By.cssSelector("input[type='text']")).getAttribute("type"),
                "text", "input doesnt have type 'text'");

        Assert.assertEquals(driver.findElement(By.cssSelector("input[type='password']")).getAttribute("type"),
                "password", "input doesnt have type 'password'");

        Assert.assertEquals(driver.findElement(By.cssSelector("input[type='checkbox']")).getAttribute("type"),
                "checkbox", "input doesnt have type 'checkbox'");

        Assert.assertTrue(!driver.findElement(By.cssSelector("input[type='checkbox']")).isSelected(),
                "Checkbox is selected.");

    }
    @Test
    public void displayError(){
        visitLoginPageFromNavBar();
        String email = "invalidemail@gmail.com";
        String password = "invalid123";

        driver.findElement(By.cssSelector("input[type='text']")).sendKeys(email);

        driver.findElement(By.cssSelector("input[type='password']")).sendKeys(password);

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        wait
                .withMessage("Invalid email address message doesn't exist")
                .until(ExpectedConditions.textToBePresentInElementValue(By.cssSelector("strong"),
                        "Invalid email address"));

        Assert.assertEquals(driver.getCurrentUrl(), "https://cms.demo.katalon.com/my-account/",
                "URL's dont't match");

    }
    @Test
    public void loginSuccess(){
        String username = "customer";
        String password = "crz7mrb.KNG3yxv1fbn";

        visitLoginPageFromNavBar();

        driver.findElement(By.cssSelector("input[type='text']")).sendKeys(username);
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("button[type='submit']")).click();

    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }





}
