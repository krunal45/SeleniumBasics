import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v85.indexeddb.model.Key;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("https://google.com");
        WebElement searchBox = driver.findElement(By.id("APjFqb"));
//        searchBox.sendKeys("Selenium" + Keys.ENTER);

        Actions actions = new Actions(driver);
//        Action action = actions.keyDown(Keys.COMMAND).sendKeys("a").build();
//        action.perform();
//        Thread.sleep(3000);

//        driver.navigate().refresh();
//        searchBox.clear();
        Action action2 = actions.keyDown(Keys.SHIFT).sendKeys(searchBox, "selenium in caps")
                .keyUp(Keys.SHIFT).sendKeys("selenium in lower case").build();
        action2.perform();
        Thread.sleep(3000);
    }
}
