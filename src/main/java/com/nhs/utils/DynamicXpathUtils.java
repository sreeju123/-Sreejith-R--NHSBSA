package com.nhs.utils;

/**
 * @author Sreej
 */
public class DynamicXpathUtils {

    private DynamicXpathUtils() {

    }

    public static String getXpath(String xpath, String value) {
        return String.format(xpath, value);
    }

    public static String getXpath1(String xpath, String value, String value1) {
        return String.format(xpath, value, value1);
    }

}
