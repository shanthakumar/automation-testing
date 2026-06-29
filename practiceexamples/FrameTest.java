import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class FrameTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        /*  1. Navigate to https://ui.vision/demo/webtest/frames/
            2. Enter Sachin into input box element which is in frame1
            3. Enter Tendulkar into input box element which is in frame2
            4. Close the browser */
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://ui.vision/demo/webtest/frames/");
    }

    @Test
    public void testFrames() throws InterruptedException {
        WebDriver frame;
        WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
        frame = driver.switchTo().frame(frame1);
        frame.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Test 1");
        driver.switchTo().defaultContent();
        WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
        frame = driver.switchTo().frame(frame2);
        frame.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Test Two");
        Thread.sleep(3000);
    }

    @AfterClass void tearDown() {
        driver.quit();
    }
}
