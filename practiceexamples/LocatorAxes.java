import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class LocatorAxes {

    // (//div[@class='form-group'])[1]/input[1]

    @Test()
    public void LocateByXPathAxes() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("https://testautomationpractice.blogspot.com/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.findElement(By.xpath("//label[text()='Name:']/following-sibling::input[1]")).sendKeys("Test User");
            driver.findElement(By.xpath("//input[@id='phone']/preceding-sibling::input[1]")).sendKeys("testuser@gmail.com");
            driver.findElement(By.id("phone")).sendKeys("9876543210");
            driver.findElement(By.name("gender")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Blog")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Trainings")));
            driver.findElement(By.cssSelector(".start")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[name='stop']")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("date-picker-box")));

            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println("Locator Error: " + e.getMessage());
        } finally {
            driver.close();
        }
    }

    @Test(enabled = false)
    public void SelectBlogTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        new WebDriverHelper(driver).waitImplicit();

        driver.findElement(By.xpath("//div[@class='orangehrm-login-forgot']")).click();
        Thread.sleep(3000);

        driver.close();
    }
}
