import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static java.sql.DriverManager.getDriver;

public class SeleniumTestDocker {
    public static ChromeOptions options;
    public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    public static String remoteURL = "http://localhost:4444";

    @Test
    public void testSteps() throws InterruptedException {
        WebDriver driver = getDriver();
        driver.navigate().to("https://www.google.com");
        driver.navigate().to("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[normalize-space()='Sign In Portal']")).click();

    }

    private WebDriver getDriver() {
        return this.driver.get();
    }

    @BeforeTest
    public static void setup() throws MalformedURLException {
        options = new ChromeOptions();
        driver.set(new RemoteWebDriver(new URL(remoteURL), options));
    }

    @AfterTest
    public static void afterTest(){
        driver.get().close();
    }
}


