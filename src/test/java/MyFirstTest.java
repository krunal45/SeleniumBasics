import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class MyFirstTest {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        WebElement searchBox = driver.findElement(By.cssSelector("[name='q']"));
//        searchBox.sendKeys("Selenium" + Keys.ENTER);
//        Thread.sleep(Duration.ofSeconds(2));
//        String window1 = driver.getWindowHandle();
//        System.out.println("Current URL :" + driver.getCurrentUrl());
//        System.out.println("Page Title :" + driver.getTitle());
//        driver.navigate().to("https://google.com");
//        Thread.sleep(Duration.ofSeconds(2));
//        driver.navigate().back();
//        Thread.sleep(Duration.ofSeconds(2));
//        driver.navigate().forward();
//        Thread.sleep(Duration.ofSeconds(2));
//        driver.navigate().refresh();
//        Thread.sleep(Duration.ofSeconds(2));
//        driver.switchTo().newWindow(WindowType.WINDOW);
//        driver.get("https://www.selenium.dev/documentation/");
//        driver.switchTo().window(window1);
//        Thread.sleep(Duration.ofSeconds(2));
//        driver.quit();
//        driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
//        driver.switchTo().frame(driver.findElement(By.cssSelector("[name=packageFrame]")));
//        driver.findElement(By.linkText("Alert")).click();
//        Thread.sleep(Duration.ofSeconds(2));

//        int windowWidth = driver.manage().window().getSize().getWidth();
//        int windowHight = driver.manage().window().getSize().getHeight();
//        System.out.println("Window Width :" + windowWidth);
//        System.out.println("Window Height :" + windowHight);
//
//        System.out.println("---Dimension---");
//        Dimension size = driver.manage().window().getSize();
//        int width1 = size.getWidth();
//        int height1 = size.getHeight();
//        System.out.println("Window Width :" + width1);
//        System.out.println("Window Height :" + height1);

//        driver.manage().window().setSize(new Dimension(240, 240));

        // Getting Windows Position
//        int X = driver.manage().window().getPosition().getX();
//        int Y = driver.manage().window().getPosition().getY();
//        System.out.println(" X : " + X);
//        System.out.println(" Y : " + Y);
//
//        Point position = driver.manage().window().getPosition();
//        int X1 = position.getX();
//        int Y1 = position.getY();
//        System.out.println(" X : " + X1);
//        System.out.println(" Y : " + Y1);

        // Setting Windows Position
//        driver.manage().window().setPosition(new Point(100, 120));

//     Maximizing Windows
        driver.manage().window().maximize();
//     Minimizing Windows
        driver.manage().window().minimize();
//     Fullscreen Windows
        driver.manage().window().fullscreen();

//        Taking page screenshot
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("src/test/java/img1.png"));
//        Taking element screenshot
        WebElement googleImg = driver.findElement(By.cssSelector("[class=lnXdpd]"));
        File src1 = googleImg.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src1, new File("src/test/java/img2.png"));

//        JavaScript Executer
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", searchBox);
        searchBox.sendKeys("Selenium" + Keys.ENTER);
    }
}