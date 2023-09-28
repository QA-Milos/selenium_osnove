package p28_09_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class TestHelper {
    private WebDriver driver;

    public TestHelper(WebDriver driver) {

        this.driver = driver;
    }

    public boolean elementExists(By metodTrazenja){

        boolean postoji = true;
        try {
            WebElement element = this.driver.findElement(metodTrazenja);

        }catch (Exception e){
            postoji = false;
        }
        return postoji;

    }

    public boolean elementExistsByList(By metodTrazenja){
        boolean postoji = true;
        try {
            List<WebElement> listaElemenata = this.driver.findElements(metodTrazenja);
        }catch (Exception e){
            postoji = false;
        }

        return postoji;

    }
    public void setDefaultImplicitlyWait(){
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void setImplicitWait(int n){
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(n));
    }
}
