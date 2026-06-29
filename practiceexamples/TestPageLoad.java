import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TestPageLoad {

    @Test
    public void test() {
        // 1. Chrome driver setup & object/instance creation
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverHelper driverHelper = new WebDriverHelper(driver);

        try {
            // 2. Maximize window and set a wait time for elements to load
            driver.manage().window().maximize();

            // 3. Navigate to Google
            driver.get("https://www.google.com");
            driverHelper.waitImplicit();

            // 4. Find the search box by its name "q"
            WebElement searchBox = driver.findElement(By.name("q"));

            // 5. Enter the search query and press ENTER
            searchBox.sendKeys("Selenium Java Tutorial" + Keys.ENTER);

            // 6. Verify by printing the title of the results page
            System.out.println("Page title is: " + driver.getTitle());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 7. Close the browser
            driver.quit();
        }

    }
}
