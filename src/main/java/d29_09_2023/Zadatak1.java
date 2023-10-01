package d29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html");

        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));


        Select select = new Select(driver.findElement(By.name("delay-select")));

        select.selectByVisibleText("2000ms");

        Actions a = new Actions(driver);

        WebElement showmore = driver.findElement(By.id("infinite-scroll-button"));

        a.scrollToElement(driver.findElement(By.id("infinite-scroll-button"))).build().perform();

        wait.until(ExpectedConditions.elementToBeClickable(showmore)).click();

        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("div.item"), 8));

        wait.until(ExpectedConditions.elementSelectionStateToBe(showmore, false));




    }
}
