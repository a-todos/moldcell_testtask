package md.moldcell.selfservice;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public final class NotificationPermissionHandler {

    private NotificationPermissionHandler() {
    }

    private static final By ALLOW_BUTTON =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"Allow\")"
            );

    private static final By DENY_BUTTON =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"Don't allow\")"
            );

    private static final By DENY_BUTTON_CURLY =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"Don’t allow\")"
            );

    private static final By LANGUAGE_SCREEN =
            By.id("md.moldcell.selfservice:id/activity_welcome");

    public static void handleIfPresent(AppiumDriver driver) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(d -> {

            if (clickIfVisible(d, ALLOW_BUTTON)) {
                return true;
            }

            if (clickIfVisible(d, DENY_BUTTON)) {
                return true;
            }

            if (clickIfVisible(d, DENY_BUTTON_CURLY)) {
                return true;
            }
            return !d.findElements(LANGUAGE_SCREEN).isEmpty();
        });
    }

    private static boolean clickIfVisible(
            AppiumDriver driver,
            By locator) {

        List<WebElement> elements =
                driver.findElements(locator);

        if (!elements.isEmpty() && elements.get(0).isDisplayed()) {
            elements.get(0).click();
            return true;
        }

        return false;
    }
}