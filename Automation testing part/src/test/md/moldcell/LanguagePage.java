package md.moldcell.selfservice;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class LanguagePage extends BasePage {

    private static final By LANGUAGE_SCREEN =
            By.id("md.moldcell.selfservice:id/activity_welcome");

    private static final By ENGLISH_RADIO =
            By.id("md.moldcell.selfservice:id/radio_btn_en");

    private static final By CONTINUE_BUTTON =
            By.id("md.moldcell.selfservice:id/btn_change_language");

    public LanguagePage(AppiumDriver driver) {
        super(driver);
    }

    public void waitUntilLoaded() {
        waitForVisible(LANGUAGE_SCREEN);
    }

    public void selectEnglish() {
        click(ENGLISH_RADIO);
    }

    public void continueToLogin() {
        click(CONTINUE_BUTTON);
    }
}