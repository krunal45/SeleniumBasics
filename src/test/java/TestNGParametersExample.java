import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParametersExample {

    @Parameters("Datasource")
    @Test
    void test(@Optional("DataTable") String dataSource) {
        System.out.println("--Data source-- : " + dataSource);
    }

    @Test(dependsOnMethods = {"test2", "test3"}, priority = 0)
    void test1() {
        System.out.println("--test 1--");
    }

    @Test(priority = 1)
    void test2() {
        System.out.println("--test 2--");
    }

    @Test(priority = 2)
    void test3() {
        System.out.println("--test 3--");
    }
}
