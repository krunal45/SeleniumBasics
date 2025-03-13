import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Objects;

public class ChromeOptionsExample2 {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        String browserName = options.getBrowserName();
        System.out.println("browserName > "+browserName);

        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.setPageLoadTimeout(Duration.ofSeconds(30));
        options.setImplicitWaitTimeout(Duration.ofSeconds(10));
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");

        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://nbrown.sandbox.mambu.com/");//open URL
//        Verifying Page Title > Login
        String expectedPageTitle = "N Brown Group";
        String actualPageTitle = Objects.requireNonNull(driver.getTitle()).trim();
        Assert.assertEquals(actualPageTitle, expectedPageTitle, "FAIL: Page Title Mismatch!");
        System.out.println("PASS: Page Title Matches!");

//        Locating Web Elements
        WebElement userNameTextBox = driver.findElement(By.id("gwt-debug-username"));
        WebElement passwordTextBox = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("button.GD3AEHSFAB"));
//        Interacting with Web Elements
        userNameTextBox.sendKeys("kbhatt");
        passwordTextBox.sendKeys("Test@43210");
        loginButton.click();

//        Logout
        WebElement logoutButton = driver.findElement(By.id("gwt-debug-lockIcon"));

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(d->logoutButton.isDisplayed());

        //        Verifying Page Title > After Login
        String expectedPageTitle1 = "Dashboard";
        String actualPageTitle1 = driver.getTitle().trim();
        Assert.assertEquals(actualPageTitle1, expectedPageTitle1, "FAIL: Unable to Login!");
        System.out.println("PASS: Logged IN!");

        logoutButton.click();
        Assert.assertEquals(actualPageTitle, expectedPageTitle, "FAIL: Unable to Logout!");
        System.out.println("PASS: Logged Out!");

//        Close Browser
        driver.quit();
    }
}
