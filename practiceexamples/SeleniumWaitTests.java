import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumWaitTests {

    @Test()
    public void ImplicitWait_Example() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        WebDriverHelper driverHelper = new WebDriverHelper(driver);

        driver.get("https://testautomationpractice.blogspot.com/");
        driverHelper.waitImplicit();

        driver.close();
    }
}
