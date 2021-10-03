package pages;

import driver.DriverManager;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reports.ExtentLogger;

public final class OrangeHRMHomePage extends BasePage {

    private final By welcomeLink = By.id("welcome");

    private final By logoutButton = By.linkText("Logout");

    public OrangeHRMHomePage clickWelcomeLink(){
        click(welcomeLink, WaitStrategy.CLICKABLE,"Welcome Link");
        return this;
    }

    public OrangeHRMLoginPage clickLogoutButton() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),10);
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        click(logoutButton,WaitStrategy.CLICKABLE,"Logout Button");
        return new OrangeHRMLoginPage();
    }

}
