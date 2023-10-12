package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.BootsnippDeleteDialogPage;
import pages.BootsnippTablePage;
import pages.BootsnippUpdateDialogPage;


import java.time.Duration;

public abstract class BasicTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl = "https://s.bootsnipp.com/iframe/K5yrx";

    protected BootsnippTablePage tablePage;
    protected BootsnippUpdateDialogPage updateDialogPage;
    protected BootsnippDeleteDialogPage deleteDialogPage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        tablePage = new BootsnippTablePage(driver,wait);
        updateDialogPage = new BootsnippUpdateDialogPage(driver,wait);
        deleteDialogPage = new BootsnippDeleteDialogPage(driver,wait);
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.get(baseUrl);
    }


    @AfterMethod
    private void afterMethod(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.localStorage.clear();");
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
