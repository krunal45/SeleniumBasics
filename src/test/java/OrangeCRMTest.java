import PageFactoryExample.OrangeCRM;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class OrangeCRMTest {

    WebDriver driver;
    OrangeCRM page;

    @BeforeSuite
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test
    public void validateUserLogin() {
        page = new OrangeCRM(driver);
        page.enterUserName("admin");
        page.enterPassword("admin123");
        page.clickLoginButton();
    }
}
