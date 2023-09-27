package d26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Scanner;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();

        Scanner s = new Scanner(System.in);


        WebElement firstName = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));

        System.out.println("Enter first name: ");
        String z;
        firstName.sendKeys(z = s.next());

        System.out.println("Enter last name: ");
        String lastName = s.next();
        driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys(lastName);

        System.out.println("Enter email: ");
        String email = s.next();
        driver.findElement(By.xpath("//*[@id=\"userEmail\"]")).sendKeys(email);


        driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label")).click();

        System.out.println("Enter Mobile: ");
        String mobile = s.next();
        driver.findElement(By.xpath("//*[@id=\"userNumber\"]")).sendKeys(mobile);

        System.out.println("Enter subjects: ");
        String subjects = s.next();
//        driver.findElement(By.xpath("//*[@id=\"subjectsContainer\"]/div/div[1]")).sendKeys(mobile);

        driver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label")).click();

        System.out.println("Unesite adresu: ");
        String adresa = s.next();
        driver.findElement(By.cssSelector("textarea.form-control")).sendKeys(adresa);



        Select drpdown = new Select(driver.findElement(By.xpath("//*[@id=\"state\"]/div/div[2]/span")));
        drpdown.selectByVisibleText("Uttar Pradesh");

        Thread.sleep(3000);

        Select cityDrp = new Select(driver.findElement(By.xpath("//*[@id=\"react-select-4-input\"]")));
        cityDrp.selectByVisibleText("Delhi");

        Thread.sleep(3000);



        driver.findElement(By.cssSelector("button#submit")).click();


        driver.quit();
    }
}
