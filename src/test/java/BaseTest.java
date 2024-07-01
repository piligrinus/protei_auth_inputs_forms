import org.junit.After;
import org.openqa.selenium.WebDriver;


public class BaseTest {

    WebDriver driver = WebDriverFactory.get();

    @After
    public void tearDown() {
        driver.quit();
    }
}