import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class WebDriverHelper {
    private final WebDriver driver;

    public WebDriverHelper(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void waitImplicit() {
        waitImplicit(20);
    }

    public void waitImplicit(int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    public void waitPageLoad(int forSeconds) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(forSeconds));
    }
}




