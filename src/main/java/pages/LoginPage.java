package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage{
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getLoginForm(){
        return driver.findElement(By.id("login_button_container"));
    }

    public WebElement getLoginButton(){
        return driver.findElement(By.id("login-button"));
    }
    public void clickOnLoginButton(){
        getLoginButton().click();
    }

    public WebElement getErrorMessageContainer(){
        return driver.findElement(By.cssSelector(".error-message-container >h3"));
    }

    public String getErrorMessageText(){
        return getErrorMessageContainer().getText();
    }

    public void waitForMessageToBePresent(String errorMessage) {
        wait
                .withMessage("Message '" + errorMessage + "' did not show.")
                .until(ExpectedConditions
                        .textToBePresentInElement(getErrorMessageContainer(),
                                errorMessage));
    }

    public WebElement getUsernameInput(){
        return driver.findElement(By.id("user-name"));
    }

    public void clearAndTypeUsername(String username){
        getUsernameInput().clear();
        getUsernameInput().sendKeys(username);
    }

    public WebElement getPasswordInput(){
        return driver.findElement(By.id("password"));
    }

    public void clearAndTypePassword(String password){
        getPasswordInput().clear();
        getPasswordInput().sendKeys(password);
    }


}
