import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class SwagLabsTest {
    static WebDriver driver = new ChromeDriver();
    //        WebElements Declaration
    static WebElement userNameTextBox;
    static WebElement passwordTextBox;
    static WebElement loginButton;
    static WebElement itemName;
    static WebElement itemPrice;
    static WebElement addToCartButton;
    static WebElement removeButton;
    static WebElement resetAppState;
    static WebElement logoutButton;
    static WebElement menuBar;
    static WebElement shoppingCartLink;
    static WebElement removeItemFromCartButton;
    static WebElement continueShoppingButton;
    Map<String, String> itemDetails = new HashMap<>();

    void openApplication() {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        System.out.println("Application Opened.");
    }

    void loginToApplication(String userName, String password) {
        userNameTextBox.sendKeys(userName);
        passwordTextBox.sendKeys(password);
        loginButton.click();
        System.out.println("Logged In.");
    }

    void fetchItemDetails() {
        String name = itemName.getText();
        String price = itemPrice.getText();
        itemDetails.put(name, price);
        System.out.println("Item Details Fetched");
        System.out.println(itemDetails);
    }

    void addItemToCart() {
        addToCartButton.click();
        System.out.println("Added " + itemDetails + " to Cart");
    }

    void verifyIfRemoveButtonDisplayed() {
        Assert.assertTrue(removeButton.isDisplayed(), "FAIL: Remove button not displayed!");
        System.out.println("Remove button displayed");
    }

    void verifyIfItemCountIncremented() {
        shoppingCartLink = driver.findElement(By.cssSelector("a.shopping_cart_link"));
        shoppingCartLink.click();
        String itemName = driver.findElement(By.cssSelector("div.inventory_item_name")).getText();
        int itemQuantity = Integer.parseInt(driver.findElement(By.cssSelector("div.cart_quantity")).getText());
//        Verify if correct item added to cart
        Assert.assertEquals(itemName, "Sauce Labs Backpack", "Fail: Item Name Mis-match!");
//        Verify if Item Quantity is correct in cart
        Assert.assertEquals(itemQuantity, 1, "Fail: Item Quanity Mismatch!");
        System.out.println("Item Count Incremented");
    }

    void removeItemFromCart() {
        removeItemFromCartButton = driver.findElement(By.cssSelector("button#remove-sauce-labs-backpack"));
        try {
            removeItemFromCartButton.click();
            System.out.println("Item Removed");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    void continueShopping(){
        continueShoppingButton = driver.findElement(By.cssSelector("button#continue-shopping"));
        continueShoppingButton.click();
        System.out.println("Back to Home Page!");
    }

    void resetAppState() {
        menuBar = driver.findElement(By.id("react-burger-menu-btn"));
        menuBar.click();
        resetAppState = driver.findElement(By.cssSelector("a#reset_sidebar_link"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        resetAppState.click();
        System.out.println("Application State Reset");
    }

    void logout() {
        logoutButton = driver.findElement(By.linkText("Logout"));
        logoutButton.click();
        System.out.println("Logged out of Application");
    }

    void closeBrowser() {
        driver.quit();
        System.out.println("Closed Browser");
    }

    public static void main(String[] args) {
        SwagLabsTest instance1 = new SwagLabsTest();
        instance1.openApplication();
        userNameTextBox = driver.findElement(By.id("user-name"));
        passwordTextBox = driver.findElement(By.id("password"));
        loginButton = driver.findElement(By.id("login-button"));
        instance1.loginToApplication("standard_user", "secret_sauce");
        itemName = driver.findElement(By.cssSelector("#item_4_title_link > div"));
        itemPrice = driver.findElement(By.xpath("//div[@class='pricebar']/div[@class='inventory_item_price'][following-sibling::button[@id='add-to-cart-sauce-labs-backpack']]"));
        instance1.fetchItemDetails();
        addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        instance1.addItemToCart();
        removeButton = driver.findElement(By.id("remove-sauce-labs-backpack"));
        instance1.verifyIfRemoveButtonDisplayed();
        instance1.verifyIfItemCountIncremented();
        instance1.removeItemFromCart();
        instance1.continueShopping();
        instance1.resetAppState();
        instance1.logout();
        instance1.closeBrowser();
    }
}
