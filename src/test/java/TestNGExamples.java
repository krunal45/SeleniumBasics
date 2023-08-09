import org.testng.annotations.*;

public class TestNGExamples {

    @BeforeSuite
    void m1() {
        System.out.println("Before Suite");
    }

    @BeforeTest
    void m2() {
        System.out.println("Before Test");
    }

    @BeforeGroups
    void m3() {
        System.out.println("Before Groups");
    }

    @BeforeClass
    void m4() {
        System.out.println("Before Class");
    }

    @BeforeMethod
    void m5() {
        System.out.println("Before Method");
    }

    @AfterClass
    void m6() {
        System.out.println("After Class");
    }

    @AfterGroups
    void m7() {
        System.out.println("After Groups");
    }

    @AfterTest
    void m8() {
        System.out.println("After Test");
    }

    @AfterMethod
    void m9() {
        System.out.println("After Method");
    }

    @AfterSuite
    void m10() {
        System.out.println("After Suite");
    }

    @Test
    void m11() {
        System.out.println("Test");
    }
}
