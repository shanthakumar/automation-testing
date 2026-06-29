import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Locators {

    @Test()
    public void LocateByXPath() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        new WebDriverHelper(driver).waitImplicit();

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.findElement(By.xpath("//input[@placeholder='Enter EMail']")).sendKeys("test@email.com");

        //Thread.sleep(3000);
        driver.close();
    }

    @Test()
    public void LocateByLinkText() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WaitHelper waitHelper = new WaitHelper(driver);

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.findElement(By.linkText("PlaywrightPractice"));
        waitHelper.waitForVisibility(By.xpath("//p[@class='description']"));

        //Thread.sleep(3000);
        driver.close();
    }

    @Test()
    public void LocateUsingText() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        WebDriverHelper driverHelper = new WebDriverHelper(driver);
        WaitHelper waitHelper = new WaitHelper(driver);

        try {
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            driverHelper.waitImplicit();
            driver.findElement(By.xpath("//p[text()='Forgot your password? ']")).click();
            waitHelper.waitForVisibility(By.xpath("//*[text()='Reset Password']"));

        } catch (Exception e) {
            System.out.println("Error Message: " + e.getMessage());
        } finally {
            driver.close();
        }
    }

    @Test()
    public void LocateUsingCSS() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        WebDriverHelper driverHelper = new WebDriverHelper(driver);
        driverHelper.waitImplicit();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("testuser");

        Thread.sleep(3000);
        driver.close();
    }
}
