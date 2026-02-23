package com.vehiclefuel.config;

public class AppConfig {

    // Fetch integer from env with default
    public static int getInt(String key, int defaultVal) {
        String val = System.getenv(key);
        if (val != null && !val.isEmpty()) {
            try {
                return Integer.parseInt(val);
            } catch (NumberFormatException e) {
                // ignore and return default
            }
        }
        return defaultVal;
    }

    // Fetch string from env with default
    public static String getString(String key, String defaultVal) {
        String val = System.getenv(key);
        return (val != null && !val.isEmpty()) ? val : defaultVal;
    }
}