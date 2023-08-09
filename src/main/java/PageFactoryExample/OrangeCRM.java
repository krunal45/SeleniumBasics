package PageFactoryExample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class OrangeCRM {
    WebDriver driver;

    public OrangeCRM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[name=username]")
    private WebElement userName;

    @FindBy(css = "input[name=password]")
    private WebElement password;

    @FindBy(how = How.CSS, using = "button[type=submit]")
    private WebElement loginButton;

    @FindBys({
            @FindBy(id = ""),
            @FindBy(name = "")
    })
    private WebElement element;

    @FindAll({
            @FindBy(id = ""),
            @FindBy(name = "")
    })
    private WebElement element1;

    public void enterUserName(String name) {
        userName.sendKeys(name);
    }

    public void enterPassword(String ppassword) {
        password.sendKeys(ppassword);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
