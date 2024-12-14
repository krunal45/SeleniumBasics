import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateContactTest {

    @BeforeTest
    void logintoApplication(){
        System.out.println("Successfully Logged In");
    }

    @BeforeTest
    void openDBConnection(){
        System.out.println("DB connection opened");
    }

    @Test(priority = 1,groups = {"Sanity"})
    void verifyIfContactCreated(){
        System.out.println("Contact Created in UI");
    }

    @Test(priority = 2,groups = {"Regression"})
    void verifyIfContactSavedInDatabase(){
        System.out.println("Contact saved in DB");
    }

    @AfterTest
    void logoutOfApplication(){
        System.out.println("Successfully Logged out");
    }

    @AfterTest
    void closeDBConnection(){
        System.out.println("DB connection closed");
    }

}