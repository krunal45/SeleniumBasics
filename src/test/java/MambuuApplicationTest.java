import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MambuuApplicationTest {
    WebDriver driver;
    WebElement userNameLocator, passwordLocator, loginButtonLocator;

    //    1. Will launch browser
    void launchChromeBrowser() {
        this.driver = new ChromeDriver();
    }

    //    2. Launch Application
    void openApplication(String url) {
        this.driver.get(url);
    }

    //    3.Login to Application
    void loginToApplication(String userName, String password) {
//        Locating Web Elements in page
        this.userNameLocator = this.driver.findElement(By.id("gwt-debug-username"));
        this.passwordLocator = this.driver.findElement(By.id("gwt-debug-password"));
        this.loginButtonLocator = this.driver.findElement(By.id("gwt-debug-loginButton"));

//        Enter userName
        this.userNameLocator.sendKeys(userName);
//        Enter password
        this.passwordLocator.sendKeys(password);
//        Click Login Button
        this.loginButtonLocator.click();
    }


    void verifyIfLoginIsSuccessful(){

    }

    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        MambuuApplicationTest instance1 = new MambuuApplicationTest();
        instance1.launchChromeBrowser();
        instance1.openApplication("https://nbrown.sandbox.mambu.com/");
        instance1.loginToApplication("kbhatt", "Test@43210");
    }
}
