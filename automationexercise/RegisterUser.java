import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterUser {

    WebDriver driver;
    WaitHelper waitHelper;

    @BeforeClass
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        //options.addExtensions(new File("./src/main/resources/AdBlock.crx"));
        options.addArguments("--load-extension=./src/main/resources/AdBlock.crx");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        waitHelper = new WaitHelper(driver);
        waitHelper.waitImplicit();
        waitHelper.waitPageLoad(60);
    }

    @Test
    public void RegisterUserTest() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd.HH.mm");

        driver.get("https://automationexercise.com/");

        Assert.assertEquals(driver.getTitle(), "Automation Exercise");
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
        //Verify 'New User Signup!' is visible
        Assert.assertTrue(isElementDisplayed(By.xpath("//*[text()='New User Signup!']")));
        driver.findElement(By.name("name")).sendKeys("Shan");
        String email = "sk" + dateFormat.format(new Date()) + "@gmail.com";
        driver.findElement(By.xpath("//*[@name='email' and @data-qa='signup-email']")).sendKeys(email);
        waitHelper.waitForClickable(By.xpath("//button[@data-qa='signup-button']")).click();
        //Verify 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertTrue(isElementDisplayed(By.xpath("//*[contains(text(), 'Enter Account Information')]")));
        waitHelper.waitForClickable(By.id("id_gender1")).click();

        WebElement name = driver.findElement(By.xpath("//input[@id='name']"));
        name.clear();
        name.sendKeys("Shanthakumar");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("_Java25_0");
        WebElement day = waitHelper.waitForClickable(By.xpath("//div[@id='uniform-days']/child::select"));
        select((day), "30");
        WebElement month = waitHelper.waitForClickable(By.xpath("//div[@id='uniform-months']/child::select"));
        select((month), "December");
        WebElement year = waitHelper.waitForClickable(By.xpath("//div[@id='uniform-years']/child::select"));
        select((year), "2000");
        waitHelper.waitForClickable(By.xpath("//input[@id='newsletter']")).click();
        waitHelper.waitForClickable(By.xpath("//input[@id='optin']")).click();
        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Shanthakumar");
        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Mv");
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Robosoft");
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("560040");
        driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("Mysore");
        WebElement country = waitHelper.waitForClickable(By.xpath("//select[@id='country']"));
        select((country), "India");
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Mysore");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Mysore");
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("Mysore");
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("1234567");
        driver.findElement(By.xpath("//button[text()='Create Account']")).click();
        Assert.assertTrue(isElementDisplayed(By.xpath("//*[text()='Account Created!']")));
        WebElement continue1 = waitHelper.waitForClickable(By.xpath("//*[text()='Continue']"));
        //continue1.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", continue1);

        WebElement user = driver.findElement(By.xpath("//*[contains(text(),'Logged in as')]"));
        Assert.assertEquals(user.getText(), "Logged in as Shanthakumar");
        waitHelper.waitForClickable(By.xpath("//*[contains(text(),'Delete Account')]")).click();
    }

    public void select(WebElement element, String text) {
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(text);
        //dropdown.getFirstSelectedOption().getText();
    }

    public boolean isElementDisplayed(By locator) {
        waitHelper.waitForVisibility(locator);
        return driver.findElement(locator).isDisplayed();
    }

    @AfterClass
    public void teardown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
