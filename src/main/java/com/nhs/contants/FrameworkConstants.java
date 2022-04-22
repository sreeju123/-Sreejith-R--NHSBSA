package com.nhs.contants;

/**
 * @author Sreej
 */
public class FrameworkConstants {

    private FrameworkConstants() {

    }

    private static final String configFilePath = System.getProperty("user.dir") + "/src/test/resources/config/config.properties";

    private static final int EXPLICITWAIT = 30;

    public static String getConfigFilePath() {
        return configFilePath;
    }

    public static int getEXPLICITWAIT() {
        return EXPLICITWAIT;
    }

}
