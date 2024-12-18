import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ChromeOptionsExample {
    public static void main(String[] args) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.setPageLoadTimeout(Duration.ofSeconds(10));
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--disable-popup-blocking");
        ChromeDriver chromeDriver = new ChromeDriver(chromeOptions);
        chromeDriver.get("https://www.saucedemo.com/");//Opens url

        //Locating Web - Elements
        WebElement userName = chromeDriver.findElement(By.cssSelector("input#user-name"));
        WebElement password = chromeDriver.findElement(By.id("password"));
        WebElement loginButton = chromeDriver.findElement(By.name("login-button"));


        //Interacting with Web - Elements
        userName.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginButton.click();

        WebElement shoppingCartLink = chromeDriver.findElement(By.cssSelector("a.shopping_cart_link"));

        //Verifying if login > success
        boolean isShoppingCartLinkDisplayed = shoppingCartLink.isDisplayed();
        if (isShoppingCartLinkDisplayed)
            System.out.println("Login Success!");
        else
            System.out.println("Login Failed!");

        //Verify Item Name
        String expectedItemName = "Sauce Labs Backpack";
        WebElement itemName = chromeDriver.findElement(By.id("item_4_title_link"));
        String actualItemName = itemName.getText();
        Assert.assertEquals(actualItemName, expectedItemName, "Fail: itemName do not match!");

        //Verify Item Description
        String expectedItemDescription = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        WebElement itemDescription = chromeDriver.findElement(By.xpath("//a[@id='item_4_title_link']/following-sibling::div[@class='inventory_item_desc']"));
        String actualItemDescription = itemDescription.getText();
        Assert.assertEquals(actualItemDescription, expectedItemDescription, "Fail: Description mismatch");

        //Print all item Description
        List<WebElement> itemDescriptions = chromeDriver.findElements(By.cssSelector("div.inventory_item_desc"));
        itemDescriptions.forEach(webElement -> System.out.println(webElement.getText()));

        //Verify itemPrice


        //Add Item to the cart


        chromeDriver.quit();
    }
}
