package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeftNavPage extends BasicPage{
    public LeftNavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getLeftMenuWindow(){
        return driver.findElement(By.className("bm-menu"));
    }

    public WebElement getLogoutButton(){
        return driver.findElement(By.id("logout_sidebar_link"));
    }

    public void clickOnLogoutButton(){
        getLogoutButton().click();
    }

    public void waitForLogoutButtonToBePresent() {
        wait
                .withMessage("Logout button did not show.")
                .until(ExpectedConditions
                        .visibilityOf(getLogoutButton()));
    }
}