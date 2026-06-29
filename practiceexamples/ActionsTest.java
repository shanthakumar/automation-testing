import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ActionsTest {

    private WebDriver driver;
    private Actions actions;
    private WaitHelper waitHelper;

    @BeforeClass
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        waitHelper = new WaitHelper(driver);
        waitHelper.waitImplicit(10);
        actions = new Actions(driver);
    }

    @Test(enabled = false)
    public void testHOver() throws InterruptedException {
        driver.get("https://testautomationpractice.blogspot.com/");
        WebElement pointMeBtn = driver.findElement(By.xpath("//button[normalize-space()='Point Me']"));
        actions.scrollToElement(pointMeBtn).perform(); // Scroll to that element but control will not be on that element
        Thread.sleep(1000);
        actions.moveToElement(pointMeBtn).perform(); // Control will be moved to that element
        Thread.sleep(1000);
        WebElement mobileLnk = waitHelper.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Mobiles']")));
        actions.click(mobileLnk).perform();
        Thread.sleep(2000);

    }

    @Test
    public void testSubItemSelect() throws InterruptedException {
        driver.get("https://www.ajio.com");
        String menButtonPath = "//button[@class='expand-nav-btn' and @aria-controls='ul-MEN']";
        WebElement menBtn = driver.findElement(By.xpath(menButtonPath));
        actions.moveToElement(menBtn).perform(); // Control will be moved to that element
        Thread.sleep(3000);
        String tracksuitPath = "//a[@aria-label='Tracksuits']";
        WebElement tracksuits = waitHelper.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tracksuitPath)));
        actions.click(tracksuits).perform();
        Thread.sleep(1000);
    }

    @Test
    public void testDraggable() throws InterruptedException {
        driver.get("https://jqueryui.com/droppable/");
        waitHelper.waitImplicit(10);

        WebElement draggable = driver.findElement(By.xpath("//*[@class='demo-frame']"));
        driver.switchTo().frame(draggable);

        WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement destination = driver.findElement(By.id("droppable"));

        //actions.dragAndDrop(source, destination).perform();
        actions.clickAndHold(source).moveToElement(destination).release().build().perform();
        Thread.sleep(3000);
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
