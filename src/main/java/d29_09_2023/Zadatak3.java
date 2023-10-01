package d29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak3 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://docs.katalon.com/");

        driver.manage().window().maximize();

        WebElement atribut = driver.findElement(By.cssSelector("html[data-theme = 'light']"));


        System.out.println(atribut.getAttribute("data-theme"));

        if (atribut.getAttribute("data-theme").contains("light")){
            System.out.println("Atribut je light");
        }

        driver.findElement(By.cssSelector("button[title]")).click();

        System.out.println(atribut.getAttribute("data-theme"));


        new Actions(driver)
                .keyDown(Keys.CONTROL).sendKeys("k").keyUp(Keys.CONTROL).build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("docsearch-input")));

        WebElement search = driver.findElement(By.id("docsearch-input"));

        System.out.println(search.getAttribute("type"));










        driver.quit();
    }
}
