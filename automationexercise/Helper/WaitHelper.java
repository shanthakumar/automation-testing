import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/* * WaitHelper:
Subclass to handle methods specific to explicit wait operations
* */

public class WaitHelper extends WebDriverHelper {
    private final WebDriverWait wait;

    public WaitHelper(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void waitForVisibility(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void alertIsPresent() {
        wait.until(ExpectedConditions.alertIsPresent());
    }
}
