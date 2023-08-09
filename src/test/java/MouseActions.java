import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://selenium08.blogspot.com/2020/01/drag-drop.html");

//        WebElement elementA = driver.findElement(By.cssSelector("li[name=A]"));
//        WebElement elementD = driver.findElement(By.cssSelector("li[name=D]"));

        Actions actions = new Actions(driver);
//        actions.moveToElement(elementA);
//        actions.clickAndHold();
//        actions.moveToElement(elementD);
//        actions.release(elementA).perform();

//        Mouse Right click
//        actions.contextClick(elementA);
//        actions.build().perform();

//        Drag and Drop
        WebElement element1 = driver.findElement(By.id("draggable"));
        WebElement element2 = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(element1, element2);
        actions.build().perform();

        Thread.sleep(4000);
        driver.quit();
    }
}