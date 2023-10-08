package p05_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class SwagLabsTests {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @BeforeMethod
    public void beforeMethod(){

        driver.manage().deleteAllCookies();
        driver.get("https://www.saucedemo.com/");

    }

    @Test (priority = 1)
    public void verifyErrorIsDisplayedWhenUsernameIsMissing(){
        driver.findElement(By.id("login-button")).click();
        WebElement error = driver.findElement(By.cssSelector("h3[data-test]"));
                wait.withMessage("Error message doesn't show")
                        .until(ExpectedConditions.textToBePresentInElement(error, "Epic sadface: Username is required"));

    }
    @Test (priority = 2)
    public void verifyErrorIsDisplayedWhenPasswordIsMissing(){
        String username = "standard_user";
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("login-button")).click();
        WebElement error = driver.findElement(By.cssSelector("h3[data-test]"));
        wait.withMessage("Error message doesn't show")
                .until(ExpectedConditions.textToBePresentInElement(error, "Epic sadface: Password is required"));

    }
    @Test (priority = 3)
    public void verifyErrorIsDisplayedWhenCredentialsAreWrong(){
        String username = "standard_user";
        String password = "invalidpassword";

        driver.findElement(By.id("user-name")).sendKeys(username);

        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("login-button")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("h3[data-test]")).getText(),
                "Epic sadface: Username and password do not match any user in this service",
                "Error message doesn't show.");

    }

    @Test (priority = 4)
    public void verifyErrorIsDisplayedWhenUserIsLocked(){
        String username = "locked_out_user";
        String password = "secret_sauce";

        driver.findElement(By.id("user-name")).sendKeys(username);

        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("login-button")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("h3[data-test]")).getText(),
                "Epic sadface: Sorry, this user has been locked out.",
                "Error message doesn't show.");

    }

    @Test (priority = 5)
    public void verifySuccessfulLogin(){
        String username = "standard_user";
        String password = "secret_sauce";

        driver.findElement(By.id("user-name")).sendKeys(username);

        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("login-button")).click();

        wait.withMessage("URL of the page does not contain '/inventory.html' .")
                .until(ExpectedConditions.urlContains("/inventory.html"));//check if url is valid

        driver.findElement(By.id("react-burger-menu-btn")).click();// click on menu button

        wait.withMessage("The left side menu doesn't seem to appear.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.bm-menu-wrap")));


        wait.withMessage("Log out button does not exist?")
                .until(ExpectedConditions.presenceOfElementLocated(By.id("logout_sidebar_link"))).click();//logout

        wait.withMessage("Log out form did not appear.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.login_container")));
    }

    @Test (priority = 6)
    public void addingProductsToCart(){
        String username = "standard_user";
        String password = "secret_sauce";

        driver.findElement(By.id("user-name")).sendKeys(username);

        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("login-button")).click();

        wait.withMessage("URL of the page does not contain '/inventory.html' .")
                .until(ExpectedConditions.urlContains("/inventory.html"));

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        wait.withMessage("Remove button did not appear")
                .until(ExpectedConditions.presenceOfElementLocated(By.id("remove-sauce-labs-backpack")));

        WebElement articles = driver.findElement(By.cssSelector("a.shopping_cart_link span"));
        Assert.assertEquals(articles.getText(), "1", "Number of articles in the cart should be 1. ");


    }
    @Test (priority = 7)
    public void viewingProductDetails(){
        String username = "standard_user";
        String password = "secret_sauce";

        driver.findElement(By.id("user-name")).sendKeys(username);

        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("login-button")).click();

        wait.withMessage("URL of the page does not contain '/inventory.html' .")
                .until(ExpectedConditions.urlContains("/inventory.html"));

        driver.findElement(By.id("item_4_title_link")).click();

        WebElement description = driver.findElement(By.cssSelector("div.inventory_details_desc"));

        Assert.assertEquals(description.getText(),
                "carry.allTheThings() with the sleek," +
                        " streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.",
                "Missing description.");
        WebElement price = driver.findElement(By.className("inventory_details_price"));

        Assert.assertEquals(price.getText(), "$29.99", "Price dont match");

        WebElement addToCart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));

        Assert.assertEquals(addToCart.getAttribute("id"), "add-to-cart-sauce-labs-backpack",
                "Element does not exist");


    }
    @Test (priority = 8)
    public void removingProductsFromCart(){
        addingProductsToCart();
        driver.findElement(By.cssSelector("a.shopping_cart_link")).click();
        wait.withMessage("The shopping cart menu didn't appear")
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.inventory_item_name")));
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();

        wait.withMessage("Item wasn't removed")
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.removed_cart_item")));



    }
    @Test (priority = 9)
    public void productCheckout(){
        String username = "standard_user";
        String password = "secret_sauce";
        String checkoutName = "Pera";
        String checkoutLastName = "Peric";
        String checkoutZip = "18000";

        driver.findElement(By.id("user-name")).sendKeys(username);

        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("login-button")).click();

        wait.withMessage("URL of the page does not contain '/inventory.html' .")
                .until(ExpectedConditions.urlContains("/inventory.html"));

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        wait.withMessage("Remove button did not appear")
                .until(ExpectedConditions.presenceOfElementLocated(By.id("remove-sauce-labs-backpack")));

        WebElement articles = driver.findElement(By.cssSelector("a.shopping_cart_link span"));
        Assert.assertEquals(articles.getText(), "1", "Number of articles in the cart should be 1. ");

        driver.findElement(By.cssSelector("a.shopping_cart_link")).click();

        driver.findElement(By.id("checkout")).click();

        driver.findElement(By.id("first-name")).sendKeys(checkoutName);
        driver.findElement(By.id("last-name")).sendKeys(checkoutLastName);
        driver.findElement(By.id("postal-code")).sendKeys(checkoutZip);

        driver.findElement(By.id("continue")).click();

        WebElement itemName = driver.findElement(By.cssSelector("div.inventory_item_name"));

        Assert.assertEquals(itemName.getText(),
                "Sauce Labs Backpack", "The item name doesn't match the entered item.");

        WebElement itemTotal = driver.findElement(By.cssSelector("div.summary_subtotal_label"));

        Assert.assertEquals(itemTotal.getText(), "Item total: $"+"29.99",
                "item total doesn't match");

        driver.findElement(By.id("finish")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector(".complete-header")).getText(),
                "Thank you for your order!", "Confirming order message doesn't appear!");
    }

    @Test
    public void validateSocialLinksInFooter() throws IOException, InterruptedException {


        String username = "standard_user";
        String password = "secret_sauce";

        driver.findElement(By.id("user-name")).sendKeys(username);

        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("login-button")).click();


        wait.withMessage("URL of the page does not contain '/inventory.html' .")
                .until(ExpectedConditions.urlContains("/inventory.html"));//check if url is valid

        new Actions(driver)
                .scrollToElement(driver.findElement(By.cssSelector("footer ul")))
                .build()
                .perform();

        List<WebElement> socials = driver.findElements(By.cssSelector("footer ul li"));
        for (int i = 0; i < socials.size() ; i++) {

            String originalHandle = driver.getWindowHandle();
            socials.get(i).click();
            URL url = new URL(driver.getCurrentUrl());
            HttpURLConnection http = (HttpURLConnection)url.openConnection();

            int status = http.getResponseCode();

            System.out.println(status);

            driver.switchTo().window(originalHandle);

            Thread.sleep(5000);


        }
    }

    @AfterMethod
    public void afterMethod(){
        driver.manage().deleteAllCookies();
        ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
