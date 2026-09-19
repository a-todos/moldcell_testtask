package md.moldcell.selfservice;

import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private static final By LOGIN_SCREEN =
            By.id("login_screen");

    private static final By TITLE_FIRST =
            By.id("login_title_first");

    private static final By TITLE_SECOND =
            By.id("login_title_second");

    private static final By DESCRIPTION =
            By.id("login_description");

    private static final By LOGIN_INPUT =
            By.id("login_input");

    private static final By PASSWORD_INPUT =
            By.id("password_input");

    private static final By LOGIN_BUTTON =
            By.id("login_button");

    private static final By LOGIN_BUTTON_TEXT =
            By.id("login_button_text");

    private static final By LOGIN_INPUT_ERROR =
            By.id("login_input_error_message");

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    public void waitUntilLoaded() {
        waitForVisible(LOGIN_SCREEN);
    }

    public void assertLoginScreen() {

        waitForVisible(TITLE_FIRST);
        waitForVisible(TITLE_SECOND);
        waitForVisible(DESCRIPTION);

        waitForVisible(LOGIN_INPUT);
        waitForVisible(PASSWORD_INPUT);

        waitForVisible(LOGIN_BUTTON);
        waitForVisible(LOGIN_BUTTON_TEXT);

        Assertions.assertEquals(
                "welcome to",
                driver.findElement(TITLE_FIRST).getText()
        );

        Assertions.assertEquals(
                "my moldcell!",
                driver.findElement(TITLE_SECOND).getText()
        );

        Assertions.assertEquals(
                "Login",
                driver.findElement(LOGIN_BUTTON_TEXT).getText()
        );
    }

    public void enterIncompleteLogin(String value) {
        type(LOGIN_INPUT, value);
    }

    public void moveToPasswordField() {
        click(PASSWORD_INPUT);
    }

    public void assertIncompleteLoginError() {

        String expected =
                "Your username must be a phone number " +
                "(without leading 0) or an email address.";

        waitForVisible(LOGIN_INPUT_ERROR);

        Assertions.assertEquals(
                expected,
                driver.findElement(LOGIN_INPUT_ERROR).getText()
        );
    }
}