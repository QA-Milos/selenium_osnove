package d25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php");

        driver.manage().window().maximize();

        for (int i = 0; i < 5; i++) {
            driver.findElement(By.cssSelector("button.btn")).click();
            driver.findElement(By.cssSelector("input#name")).sendKeys("Neki Tamo");
            driver.findElement(By.cssSelector("input#department")).sendKeys("QA Analyst");
            driver.findElement(By.cssSelector("input#phone")).sendKeys("143413-4134");


            WebElement add = driver.findElement(By.cssSelector("table tbody tr:last-child a.add"));
            add.click();


        }
        Thread.sleep(500);

        driver.quit();
    }
}
