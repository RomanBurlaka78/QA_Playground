package playground.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public abstract class BaseTest {
    protected WebDriver driver;
    private String browser;


    protected WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    @Parameters("browser")
    protected void beforeClass() {
        this.browser = "chrome";
        Arrays.stream(this.getClass().getMethods())
                .filter(m -> m.getAnnotation(Test.class) != null && m.getAnnotation(Ignore.class) == null)
                .collect(Collectors.toList());

    }

    @BeforeMethod
    public WebDriver setUp() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--window-size=1920,1080");
        chromeOptions.addArguments("--headless=new");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(chromeOptions);


        driver.get("https://qaplayground.dev/");
        return driver;
    }


    @AfterMethod
    public void tearDown(ITestResult testResult) {
        if (testResult.isSuccess()) {
            driver.quit();
        } else {
            System.out.println("Failed: " + testResult.getTestClass());
        }
    }
}
