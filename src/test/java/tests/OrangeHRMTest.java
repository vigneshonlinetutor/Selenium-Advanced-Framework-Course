package tests;

import annotations.FrameworkAnnotation;
import enums.CategoryTypes;
import org.testng.annotations.Test;
import pages.OrangeHRMLoginPage;

import java.util.Map;

public final class OrangeHRMTest extends BaseTest {

    private OrangeHRMTest(){}

    @FrameworkAnnotation(category = {CategoryTypes.SMOKE})
    @Test()
    public void loginTest(Map<String,String> map) {
        OrangeHRMLoginPage lp = new OrangeHRMLoginPage();
        lp.enterUsername(map.get("username"))
                .enterPassword(map.get("password"))
                .clickLoginButton()
                .clickWelcomeLink()
                .clickLogoutButton();
    }

    @FrameworkAnnotation(category = {CategoryTypes.REGRESSION})
    @Test()
    public void loginTest2(Map<String,String> map){
        OrangeHRMLoginPage lp = new OrangeHRMLoginPage();
        lp.enterUsername(map.get("username"))
                .enterPassword(map.get("password"))
                .clickLoginButton()
                .clickWelcomeLink()
                .clickLogoutButton();
    }

    @FrameworkAnnotation(category = {CategoryTypes.SANITY})
    @Test()
    public void loginTest3(Map<String,String> map){
        OrangeHRMLoginPage lp = new OrangeHRMLoginPage();
        lp.enterUsername(map.get("username"))
                .enterPassword(map.get("password"))
                .clickLoginButton()
                .clickWelcomeLink()
                .clickLogoutButton();
    }
}
