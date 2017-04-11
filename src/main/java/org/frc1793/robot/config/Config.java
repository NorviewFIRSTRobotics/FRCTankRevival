package org.frc1793.robot.config;

import edu.wpi.first.wpilibj.Preferences;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 2/22/17
 */
@SuppressWarnings("unused")
public class Config {
    public static ConfigOption<String> autonomous;

    public static void init() {}

    public static void update() {}

    public static final Preferences p = Preferences.getInstance();

    public static ConfigOption<Boolean> config(String key, Boolean defaultVal) {
        return new ConfigOption<>(key, defaultVal, p::containsKey, p::putBoolean, p::getBoolean);
    }

    public static ConfigOption<Double> config(String key, Double defaultVal) {
        return new ConfigOption<>(key, defaultVal, p::containsKey, p::putDouble, p::getDouble);
    }

    public static ConfigOption<String> config(String key, String defaultVal) {
        return new ConfigOption<>(key, defaultVal, p::containsKey, p::putString, p::getString);
    }

}

