import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingJSAlertExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
//        WebElement btn1 = driver.findElement(By.cssSelector("button[onclick=\"jsAlert()\"]"));
//        btn1.click();
//        WebElement btn2 = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
//        Thread.sleep(3000);
        WebElement btn3 = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));


//        Alert jsAlert = driver.switchTo().alert();
//        String alertText = jsAlert.getText();
//        System.out.println("Alert Text : " + alertText);
//
//        if (alertText.equals("I am a JS Alert")) {
//            Thread.sleep(3000);
//            jsAlert.accept();
//            System.out.println("Accepted Javascript Alert.");
//        }

//        js pop up dismiss
//        btn2.click();
//        Thread.sleep(3000);
//        Alert jsAlert1 = driver.switchTo().alert();
//        String alertText1 = jsAlert1.getText();
//        System.out.println("Alert Text : " + alertText1);
//
//        if (alertText1.equals("I am a JS Confirm")) {
//            Thread.sleep(3000);
//            jsAlert1.dismiss();
//            if (driver.getPageSource().contains("You clicked: Cancel")) {
//                System.out.println("Success");
//            } else {
//                System.out.println("Fail");
//            }
//        }

//        js Pop up Box :
        btn3.click();
        Thread.sleep(3000);
        Alert jsAlert2 = driver.switchTo().alert();
        String alertText2 = jsAlert2.getText();
        System.out.println("Alert Text : " + alertText2);
        jsAlert2.sendKeys("Krunal");
        Thread.sleep(3000);
        if (alertText2.equals("I am a JS prompt")) {
            Thread.sleep(3000);
            jsAlert2.accept();
            if (driver.getPageSource().contains("You entered: Krunal")) {
                System.out.println("Success");
            } else {
                System.out.println("Fail");
            }
        }
        driver.quit();
    }
}