import org.testng.annotations.Test;

public class TestNGPriorityExample {

    @Test(priority = 1, groups = {"Sanity", "Regression", "Smoke", "windows.regression"})
    void Apple() {
        System.out.println(" In method A1");
    }

    @Test(priority = 0, groups = {"Smoke", "linux.regression"})
    void Banana() {
        System.out.println(" In method Banana ");
    }

    @Test(groups = {"Sanity"})
    void zebra() {
        System.out.println(" In method Cherry");
    }

    @Test(dependsOnGroups = {"Sanity"})
    void duck() {
        System.out.println("--duck--");
    }
}