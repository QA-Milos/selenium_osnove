package d25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        List<String>todo = new ArrayList<>();

        todo.add("Visit Paris");
        todo.add("Visit Prague");
        todo.add("Visit London");
        todo.add("Visit New York");
        todo.add("Visit Belgrade");

        driver.get("https://example.cypress.io/todo");
        driver.manage().window().maximize();

        WebElement textbox = driver.findElement(By.cssSelector("input.new-todo"));




        for (int i = 0; i < todo.size(); i++) {
            textbox.sendKeys(todo.get(i));
            textbox.sendKeys(Keys.ENTER);
        }



        List<WebElement>elements = driver.findElements(By.cssSelector("ul.todo-list li"));



        for (int i = 0; i < elements.size(); i++) {

            WebElement checkbox = elements.get(i).findElement(By.cssSelector("input"));
            if (!checkbox.isSelected()) {
                checkbox.click();
            }

        }

        Thread.sleep(5000);


        driver.quit();
    }
}
