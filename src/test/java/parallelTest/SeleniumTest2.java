package parallelTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumTest2 {

    WebDriver driver;

    @BeforeTest
    @Parameters("browserType")
    public void setUp(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if(browser.equalsIgnoreCase("firefox")){
            capabilities.setBrowserName("firefox");
        }
        if(browser.equalsIgnoreCase("chrome")){
            capabilities.setBrowserName("chrome");
        }
        if(browser.equalsIgnoreCase("Edge")){
            capabilities.setBrowserName("MicrosoftEdge");
        }

        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
    }

    @Test
    public void seleniumTest1() throws InterruptedException {
        driver.navigate().to("https://www.google.com");
        driver.navigate().to("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[normalize-space()='Sign In Portal']")).click();
    }

    @AfterTest
    public void tearDown(){
        //driver.close();
    }
}
