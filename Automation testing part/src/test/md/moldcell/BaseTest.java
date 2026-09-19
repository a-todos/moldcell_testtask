package md.moldcell.selfservice;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.net.URI;

public abstract class BaseTest {

    protected AppiumDriver driver;

    @BeforeEach
    void setUp() throws Exception {

        clearApplicationData();

        UiAutomator2Options options =
                new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName(
                System.getProperty(
                        "device.name",
                        "Android"
                )
        );

        options.setAppPackage(
                TestConfig.APP_PACKAGE
        );

        options.setNoReset(true);

        options.setAutoGrantPermissions(false);

        driver = new AndroidDriver(
                URI.create(
                        TestConfig.APPIUM_SERVER
                ).toURL(),
                options
        );
    }

    private void clearApplicationData()
            throws Exception {

        Process process = new ProcessBuilder(
                "adb",
                "shell",
                "pm",
                "clear",
                TestConfig.APP_PACKAGE
        )
                .redirectErrorStream(true)
                .start();

        String output =
                new String(
                        process.getInputStream()
                                .readAllBytes()
                );

        int exitCode =
                process.waitFor();

        if (exitCode != 0 ||
                !output.toLowerCase().contains("success")) {

            throw new IllegalStateException(
                    "Failed to clear application data. " +
                    "adb output: " + output
            );
        }
    }

    @AfterEach
    void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}