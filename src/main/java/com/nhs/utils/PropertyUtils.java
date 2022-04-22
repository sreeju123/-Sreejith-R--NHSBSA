package com.nhs.utils;

import com.nhs.contants.FrameworkConstants;
import com.nhs.enums.ConfigProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author Sreej
 */
public class PropertyUtils {

    private PropertyUtils() {

    }

    private static final Properties properties = new Properties();
    private static final Map<String, String> MAP = new HashMap<>();


    static {
        try (FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.getConfigFilePath())) {

            properties.load(fileInputStream);

            for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                String key = String.valueOf(entry.getKey());
                String value = String.valueOf(entry.getValue());
                MAP.put(key, value);
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);

        }
    }

    public static String getValue(ConfigProperties key) {
        return MAP.get(key.name().toLowerCase());
    }


}
