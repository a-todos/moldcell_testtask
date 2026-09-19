package md.moldcell.selfservice;

import org.junit.jupiter.api.Test;

public class FirstLaunchTest extends BaseTest {

    @Test
    void firstLaunchShowsLoginScreen() {
        NotificationPermissionHandler.handleIfPresent(driver);
        LanguagePage languagePage =
                new LanguagePage(driver);

        languagePage.waitUntilLoaded();
        languagePage.selectEnglish();
        languagePage.continueToLogin();
        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.waitUntilLoaded();
        loginPage.assertLoginScreen();
    }
}