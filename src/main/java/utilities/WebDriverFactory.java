package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory
{
    public static WebDriver initializeWebDriver(String browserType)
    {
        String browser = System.getProperty("browser");
        WebDriver webDriver = null;
        if (browser != null)
        {
            switch (browser)
            {
                case "chrome":
                    WebDriverManager.chromedriver().driverVersion("109.0.5414.74").setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setBinary(System.getenv("CHROME_BIN"));
                    chromeOptions.addArguments("--no-sandbox", "--headless", "--disable-gpu", "--start-maximized",
                            "--ignore-certificate-errors", "--disable-extensions", "--disable-dev-shm-usage");
                    webDriver = new ChromeDriver(chromeOptions);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setBinary(System.getenv("FIREFOX_BIN"));
                    firefoxOptions.addArguments("--headless", "--start-maximized");
                    webDriver = new FirefoxDriver(firefoxOptions);
                    break;
                default:
                    throw new WebDriverException();
            }
        }
        else if (browserType != null)
        {
            switch (browserType)
            {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    webDriver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    webDriver = new FirefoxDriver();
                    break;
                default:
                    throw new WebDriverException();
            }
        }
        return webDriver;
    }
}
