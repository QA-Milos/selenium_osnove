package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.SwagLabsRetry;

public class SwagLabsTests extends BasicTestSwag {

    @Test (priority = 1, retryAnalyzer = SwagLabsRetry.class)
    public void verifyErrorIsDisplayedWhenUsernameIsMissing() {
        String errorMessage = "Epic sadface: Username is required";
        loginPage.clickOnLoginButton();

        loginPage.waitForMessageToBePresent(errorMessage);
    }

    @Test (priority = 2, retryAnalyzer = SwagLabsRetry.class)
    public void verifyErrorIsDisplayedWhenPasswordIsMissing() {
        String username = "standard_user";
        String errorMessage = "Epic sadface: Password is required";

        loginPage.clearAndTypeUsername(username);
        loginPage.clickOnLoginButton();
        loginPage.waitForMessageToBePresent(errorMessage);
    }

    @Test (priority = 3, retryAnalyzer = SwagLabsRetry.class)
    public void verifyErrorIsDisplayedWhenCredentialsAreWrong() {
        String username = "standard_user";
        String password = "invalidpassword";
        String errorMessage = "Epic sadface: Username and password do not match any user in this service";

        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        loginPage.waitForMessageToBePresent(errorMessage);
    }

    @Test (priority = 4, retryAnalyzer = SwagLabsRetry.class)
    public void verifyErrorIsDisplayedWhenUserIsLocked() {
        String username = "locked_out_user";
        String password = "secret_sauce";
        String errorMessage = "Epic sadface: Sorry, this user has been locked out.";

        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        loginPage.waitForMessageToBePresent(errorMessage);
    }

    @Test (priority = 5, retryAnalyzer = SwagLabsRetry.class)
    public void verifySuccessfulLogin() {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();

        topNavPage.clickOnMenuButton();

        Assert.assertTrue(leftNavPage.getLeftMenuWindow()
                        .isDisplayed(),
                "Menu did not show after click on menu button.");

        leftNavPage.waitForLogoutButtonToBePresent();

        leftNavPage.clickOnLogoutButton();

        Assert.assertTrue(loginPage.getLoginForm()
                        .isDisplayed(),
                "Successful logout did not show login form.");

    }

    @Test (priority = 6, retryAnalyzer = SwagLabsRetry.class)
    public void addingProductsToCart() {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();

        inventoryPage.scrollToProductName("Sauce Labs Backpack");

        inventoryPage.clickOnAddToCartButtonByProductName("Sauce Labs Backpack");

        Assert.assertTrue(inventoryPage
                        .getRemoveButtonByProductNameText("Sauce Labs Backpack")
                        .isDisplayed(),
                "Remove button did not show after Add to cart click.");

        Assert.assertEquals(topNavPage
                        .getShoppingCartBadgeText(),
                "1",
                "Number of products in the cart has not increased by one after Add to cart.");
    }

}
