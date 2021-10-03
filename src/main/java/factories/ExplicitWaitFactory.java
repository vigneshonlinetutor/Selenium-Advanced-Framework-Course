package factories;

import constants.FrameworkConstants;
import driver.DriverManager;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class ExplicitWaitFactory {

    private ExplicitWaitFactory(){}

    public static WebElement performExplicitWait(By by, WaitStrategy waitStrategy){
        WebElement element = null;
        if(waitStrategy==WaitStrategy.CLICKABLE){
            element= new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getWaitTimeInSeconds())
                    .until(ExpectedConditions.elementToBeClickable(by));
        }
        else if(waitStrategy==WaitStrategy.PRESENCE){
           element= new WebDriverWait(DriverManager.getDriver(),FrameworkConstants.getWaitTimeInSeconds())
            .until(ExpectedConditions.presenceOfElementLocated(by));
        }
        else if(waitStrategy==WaitStrategy.VISIBLE){
            element = new WebDriverWait(DriverManager.getDriver(),FrameworkConstants.getWaitTimeInSeconds())
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        }
        return element;
    }

}

