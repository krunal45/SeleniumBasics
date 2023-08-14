import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class FindingBrokenLinksAndImages {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito", "--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("https://makemysushi.com/404?#");

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        allLinks.addAll(driver.findElements(By.tagName("img")));
        System.out.println("All Links Count : --> " + allLinks.size());

        allLinks.removeIf(element -> element.getAttribute("href") == null || !element.getAttribute("href").contains("https"));
        System.out.println("Valid Links Count : -->" + allLinks.size());

//        To check if the link isn't broken
        for (WebElement link : allLinks) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(link.getAttribute("href")).openConnection();
            httpURLConnection.connect();
            String message = httpURLConnection.getResponseMessage();
            System.out.println(link.getAttribute("href") + " :" + message);
            httpURLConnection.disconnect();
        }
        driver.quit();
    }
}
