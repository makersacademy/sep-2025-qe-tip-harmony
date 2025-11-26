//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.TakesScreenshot;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;

public class Giga_Chrome_Test {
    private static ChromeDriver driver;

    @BeforeAll
    static void launchBrowser() {
        driver = new ChromeDriver();

    }

    @AfterAll
    static void closeBrowser() {
        driver.quit();
    }

    @Test
     void attemptLoginWithoutPassword() throws Exception {
        driver.get("http://127.0.0.1:5001/login");
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).sendKeys("username");
        driver.findElement(By.cssSelector(".col-lg-10 > input")).click();
        Thread.sleep(2000);
    }

}
