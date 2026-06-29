import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NavigateExample {
    @Test
    public void testPageNavigation() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverHelper driverHelper = new WebDriverHelper(driver);
        driverHelper.waitPageLoad(30);

        try {

            driver.get("https://www.amazon.com/");
            driverHelper.waitImplicit();

            System.out.println("Amaz url: " + driver.getCurrentUrl());
            System.out.println("Amaz title: " + driver.getTitle());

            driver.get("https://www.flipkart.com/");

            System.out.println("Flip title: " + driver.getTitle());
            driver.navigate().back();
            System.out.println("Amaz title: " + driver.getTitle());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            driver.close();
        }
    }
}
