import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class myFirstScript {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver(); //1. Open the chrome browser instance
        driver.get("https://google.com");// 2. Type in the browser url
        driver.manage().window().maximize(); // Maximize the browser window
        String pageTitle = driver.getTitle(); // 3. Fetch the page Title
        System.out.println("Page Title > "+pageTitle); // 4. Print the page Title
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));// Implicitly waits for 0.5 seconds!
        WebElement searchBox = driver.findElement(By.id("APjFqb"));
        WebElement searchButton = driver.findElement(By.tagName("input"));
        searchBox.sendKeys("Postman");
        Thread.sleep(3000);
        searchButton.click();
        Thread.sleep(3000);
        driver.quit(); // Close the browser windows
    }
}
