package pages;

import constants.FrameworkConstants;
import driver.DriverManager;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reports.ExtentLogger;

import java.time.Duration;

public final class OrangeHRMHomePage extends BasePage {

    private final By welcomeLink = By.cssSelector(".oxd-userdropdown-tab");

    private final By logoutButton = By.linkText("Logout");

    public OrangeHRMHomePage clickWelcomeLink(){
        click(welcomeLink, WaitStrategy.CLICKABLE,"Welcome Link");
        return this;
    }

    public OrangeHRMLoginPage clickLogoutButton() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getWaitTimeInSeconds());
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        click(logoutButton,WaitStrategy.CLICKABLE,"Logout Button");
        return new OrangeHRMLoginPage();
    }

}
