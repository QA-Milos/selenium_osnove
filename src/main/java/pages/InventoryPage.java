package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage extends BasicPage{
    public InventoryPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getProductByProductNameText(String productName) {
        String selector = "//*[text()='" + productName + "']";
        return driver.findElement(By.xpath(selector));
    }

    public void scrollToProductName(String productName)  {
        new Actions(driver)
                .scrollToElement(getProductByProductNameText(productName))
                .perform();
    }

    public WebElement getAddToCartButtonByProductNameText(String productName) {
        String selector = "//*[text()='" + productName + "']/../../following-sibling::div[1]//button[1]";
        return driver.findElement(By.xpath(selector));
    }

    public void clickOnAddToCartButtonByProductName(String productName) {
        getAddToCartButtonByProductNameText(productName).click();
    }

    public WebElement getRemoveButtonByProductNameText(String productName) {
        String idContains = productName.toLowerCase().replace(" ", "-");
        String selector = "//button[contains(@id, 'remove-" + idContains + "')]";
        return driver.findElement(By.xpath(selector));
    }

}