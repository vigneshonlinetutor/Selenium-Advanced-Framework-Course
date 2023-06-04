package pages;

import constants.FrameworkConstants;
import driver.DriverManager;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reports.ExtentLogger;

import java.time.Duration;

public final class OrangeHRMLoginPage extends BasePage {

    private final By usernameBox = By.cssSelector("input[placeholder='Username']");

    private final By passwordBox = By.cssSelector("input[placeholder='Password']");

    private final By loginButton = By.cssSelector("button[type='submit']");

    private final By invalidCredsError = By.cssSelector("div[role='alert']");

    public OrangeHRMLoginPage enterUsername(String usernameValue){
        sendKeys(usernameBox,usernameValue, WaitStrategy.PRESENCE,"Username");
        return this;
    }

    public OrangeHRMLoginPage enterPassword(String passwordValue){
        sendKeys(passwordBox,passwordValue,WaitStrategy.PRESENCE,"Password");
        return this;
    }

    public OrangeHRMHomePage clickLoginButton(){
        click(loginButton,WaitStrategy.CLICKABLE,"Login Button");
        return new OrangeHRMHomePage();
    }

    public String invalidCredsErrorText() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getWaitTimeInSeconds());
        wait.until(ExpectedConditions.elementToBeClickable(invalidCredsError));
        return getText(invalidCredsError,WaitStrategy.PRESENCE);
    }

}
