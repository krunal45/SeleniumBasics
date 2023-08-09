import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Dropdown {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://trytestingthis.netlify.app/");

        WebElement dropdown = driver.findElement(By.id("option"));
        Select selectDropdown = new Select(dropdown);
//        selectDropdown.selectByIndex(3);
//        Thread.sleep(3000);
//        selectDropdown.selectByValue("option 2");
//        Thread.sleep(3000);
//        selectDropdown.selectByVisibleText("Option");
//        Thread.sleep(3000);

//        Storing dropdown Option list
//        List<WebElement> dropdownOptions = selectDropdown.getOptions();
//        List<WebElement> dropdownOptions1 = driver.findElements(By.id("option"));

//        for (WebElement option : dropdownOptions) {
//            System.out.println(option.getText());
//            if (option.getText().equals("Option 2")) {
//                option.click();
//                Thread.sleep(3000);
//            }
//        }

        //    Deselecting options
        WebElement dropdown1 = driver.findElement(By.id("owc"));
        Select selectDropdown1 = new Select(dropdown1);
        selectDropdown1.selectByValue("option 1");
        Thread.sleep(2000);
        selectDropdown1.deselectByIndex(1);
        Thread.sleep(2000);
        List<WebElement> options1 = selectDropdown1.getOptions();

        for (WebElement option1 : options1) {
            option1.click();
            Thread.sleep(2000);
        }
        selectDropdown1.deselectAll();
        Thread.sleep(2000);
        driver.quit();
    }


}