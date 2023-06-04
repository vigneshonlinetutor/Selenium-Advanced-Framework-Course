package factories;

import constants.FrameworkConstants;
import enums.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.ReadPropertyFile;

import java.net.MalformedURLException;
import java.net.URL;

public final class DriverFactory {

    private DriverFactory() {
    }

    public static WebDriver getDriver() throws MalformedURLException {
        WebDriver driver = null;
        String runmode = ReadPropertyFile.getValue(ConfigProperties.RUNMODE);
        String browser = ReadPropertyFile.getValue(ConfigProperties.BROWSER);

        if (browser.equalsIgnoreCase("chrome")) {
            if (runmode.equalsIgnoreCase("remote")) {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setBrowserName(Browser.CHROME.browserName());
                driver = new RemoteWebDriver(new URL(FrameworkConstants.getSeleniumGridUrl()), cap);
            } else if (runmode.equalsIgnoreCase("local")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
        } else if (browser.equalsIgnoreCase("firefox")) {
            if (runmode.equalsIgnoreCase("remote")) {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setBrowserName(Browser.FIREFOX.browserName());
                driver = new RemoteWebDriver(new URL(FrameworkConstants.getSeleniumGridUrl()), cap);
            } else if (runmode.equalsIgnoreCase("local")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        }
        return driver;
    }
}
