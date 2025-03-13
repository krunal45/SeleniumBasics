import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocatorsExample {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com/challenging_dom");

        By baz = RelativeLocator.with(By.className("button")).above(By.className("button alert"));
        WebElement bazLink = driver.findElement(baz);
        bazLink.click();
    }
}
