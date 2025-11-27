//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.TakesScreenshot;
import com.sun.source.tree.AssertTree;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

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

    @DisplayName("Adding items to Todo list: React")
    @ParameterizedTest(name = "Adding item {0} and {1}, which tests {3}")
    @CsvFileSource(resources = "/NewAccountItems.csv")
     void attemptLoginTest(String username, String password, Boolean validity, String testPoint) throws Exception {
        GigaPageObectModels giga = new GigaPageObectModels(driver);
        giga.navigate("http://127.0.0.1:5001/login");
        giga.SignUp();
        giga.addUsername(username);
        giga.addPassword(password);
        giga.confirmPassword(password);
//        Thread.sleep(1000);
        if (validity) {
            assertEquals("http://127.0.0.1:5001/login?signup_message=True", driver.getCurrentUrl());
        } else {
            assertEquals("http://127.0.0.1:5001/signup", driver.getCurrentUrl());
        }
    }

    @DisplayName("A COMPLETELY VALID TITLE FOR THIS")
    @ParameterizedTest(name = "Play solder text")
    @CsvFileSource(resources = "/TicketNumbers.csv")
    void bookTicketsTest(String amount, Boolean validness, String testPoint) throws Exception {
        GigaPageObectModels giga = new GigaPageObectModels(driver);
        giga.navigate("http://127.0.0.1:5001/login");
        giga.logIn();
        Thread.sleep(1000);
        giga.navigate("http://127.0.0.1:5001/gigs/1");
        Thread.sleep(1000);
        giga.bookTickets(amount);
        Thread.sleep(1000);
        if (validness) {
            giga.navigate("http://127.0.0.1:5001/account");
            giga.cancelBooking();
            assertEquals("http://127.0.0.1:5001/account", driver.getCurrentUrl());
        } else {
            assertEquals("http://127.0.0.1:5001/book_gig/1", driver.getCurrentUrl());
        }
    }
}
