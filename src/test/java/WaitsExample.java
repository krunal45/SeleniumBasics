import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitsExample {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//        implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement userName = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
//        explict wait
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(userName));
//        userName.sendKeys("Admin");
//        password.sendKeys("admin123");
//        Fluent wait
        Wait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2000)).ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.elementToBeClickable(userName));
        userName.sendKeys("Admin");
        password.sendKeys("admin123");
    }
}
