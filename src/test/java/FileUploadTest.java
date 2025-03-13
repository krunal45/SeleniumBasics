import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class FileUploadTest {
    WebDriver driver;
    String url = "https://the-internet.herokuapp.com/upload";

    @BeforeTest
    void openApplication() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.get(url);
    }

    @Test
    void fileUploadTest() {
        File uploadFile = new File("src/test/java/img1.png");
        WebElement fileInput = driver.findElement(By.id("file-upload"));
        fileInput.sendKeys(uploadFile.getAbsolutePath());

        WebElement fileUpload = driver.findElement(By.id("file-submit"));
        fileUpload.click();
    }

    @AfterTest
    void closeBrowser(){
        driver.quit();
    }
}