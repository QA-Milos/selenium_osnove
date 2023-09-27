package d26_09_2023;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://s.bootsnipp.com/iframe/Dq2X");


        driver.manage().window().maximize();

        Thread.sleep(3000);


        boolean notifikacija = true;


        while (notifikacija) {

            WebElement closeButton = driver.findElement(By.cssSelector(".alert button.close"));


            closeButton.click();


            notifikacija = !driver.findElements(By.cssSelector(".alert")).isEmpty();

            if (!notifikacija) {
                System.out.println("Notifikacija zatvorena");
            } else {
                System.out.println("Nije zatvorena");
            }
        }

        driver.quit();
    }
}
