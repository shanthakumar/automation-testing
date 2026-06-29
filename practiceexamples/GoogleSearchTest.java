import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class GoogleSearchTest {

    @Test
    public void SearchText() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            driver.get("https://www.google.com/");
            //textarea[@title='Search']
            driver.findElement(By.name("q")).sendKeys("Hello Google" + Keys.RETURN);
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Search Error: " + e.getMessage());
        } finally {
            driver.close();
        }
    }
}
