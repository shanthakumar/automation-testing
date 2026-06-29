import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ExplicitWaitTests {

    @Test()
    public void ExplicitWait_WithHelper_Example() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        WaitHelper waitHelper = new WaitHelper(driver);

        driver.get("https://testautomationpractice.blogspot.com/");
        waitHelper.waitImplicit();

        waitHelper.waitForVisibility(By.id("name"));
        driver.findElement(By.id("name")).sendKeys("Sachin");

        waitHelper.waitForVisibility(By.id("name"));
        driver.findElement(By.id("email")).sendKeys("Sachin@gmail.com");

        waitHelper.waitForClickable(By.id("female"));
        driver.findElement(By.id("female")).click();

        Thread.sleep(3000);

        driver.close();
    }
}
