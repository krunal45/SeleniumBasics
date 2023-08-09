import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.util.List;

public class LocatorsStratergyExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//        driver.get("https://trytestingthis.netlify.app/");
//        WebElement firstName = driver.findElement(By.cssSelector("input#fname"));
//        firstName.click();
//        boolean isEnabled = firstName.isEnabled();
//        System.out.println("isEnabled: " + isEnabled);
//        firstName.sendKeys("Krunal");
//        System.out.println(" Passed Value: " + firstName.getText());

//        Radio Buttons ---
//        WebElement genderRadioBTN = driver.findElement(By.name("gender"));
//        boolean isSelected = genderRadioBTN.isSelected();
//        System.out.println("---before Click---");
//        System.out.println("genderRadioBTN isSelected ?" + isSelected);
//        genderRadioBTN.click();
//        isSelected = genderRadioBTN.isSelected();
//        System.out.println("---After Click---");
//        System.out.println("genderRadioBTN isSelected ?" + isSelected);
//        Thread.sleep(2000);

//        WebElements
//        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));

//        for (WebElement checkbox : checkboxes) {
//            boolean isCheckboxSelected = checkbox.isSelected();
//            System.out.println("--before--");
//            System.out.println("isCheckboxSelected : " + isCheckboxSelected);
//            if (!isCheckboxSelected) {
//                checkbox.click();
//            }
//            Thread.sleep(4000);
//            isCheckboxSelected = checkbox.isSelected();
//            System.out.println("--after--");
//            System.out.println("isCheckboxSelected : " + isCheckboxSelected);
//        }
//        driver.quit();

//        Relative locators
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement userName = driver.findElement(By.cssSelector("[name='username']"));
        WebElement password = driver.findElement(RelativeLocator.with(By.tagName("input")).below(userName));
        WebElement loginBTN = driver.findElement(RelativeLocator.with(By.tagName("button")).below(password));
        userName.sendKeys("Admin");
        password.sendKeys("admin123");
        loginBTN.click();
    }
}
