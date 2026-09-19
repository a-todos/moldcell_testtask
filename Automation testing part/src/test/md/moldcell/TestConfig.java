package md.moldcell.selfservice;

import java.time.Duration;

public final class TestConfig {

    private TestConfig() {
    }

    public static final String APP_PACKAGE =
            "md.moldcell.selfservice";

    public static final String APPIUM_SERVER =
            System.getProperty(
                    "appium.server",
                    "http://127.0.0.1:4723"
            );

    public static final Duration EXPLICIT_WAIT =
            Duration.ofSeconds(15);

    public static String getIncompleteLogin() {

        String value =
                System.getProperty("testData.incompleteLogin");

        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(
                    "Test data is missing. " +
                    "Run tests with: " +
                    "-DtestData.incompleteLogin=79"
            );
        }

        return value;
    }
}