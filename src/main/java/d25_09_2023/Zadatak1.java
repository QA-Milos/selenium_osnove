package d25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.manage().window().maximize();


        List<WebElement> userpass = driver.findElements(By.cssSelector("input.oxd-input"));


        for (int i = 0; i < userpass.size(); i++) {
            if (i == 0){
                userpass.get(i).sendKeys("Admin");
            }else userpass.get(i).sendKeys("admin123");
        }
        
//        driver.findElement(By.cssSelector("input.oxd-input")).sendKeys("Admin");
//        driver.findElement(By.name("input[name='password']")).sendKeys("admin123");

        driver.findElement(By.tagName("button")).click();

        Thread.sleep(5000);

        driver.findElement(By.cssSelector("input.oxd-input")).sendKeys("Me");

        driver.findElement(By.cssSelector("a.oxd-main-menu-item")).click();

        Thread.sleep(1000);

        driver.findElement(By.cssSelector("span.oxd-userdropdown-tab")).click();

        driver.findElement(By.cssSelector("ul.oxd-dropdown-menu li:nth-child(4) a ")).click();









        driver.quit();
    }
}
