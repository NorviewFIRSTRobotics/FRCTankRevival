package org.frc1793.robot.config;

import edu.wpi.first.wpilibj.Preferences;

/**
 * Created by tyler on 4/12/17.
 */
public class PreferencesWrapper implements IConfigTable {
    private static final Preferences preferences = Preferences.getInstance();

    @Override
    public boolean containsKey(String key) {
        return preferences.containsKey(key);
    }

    @Override
    public void putBoolean(String key, Boolean value) {
        preferences.putBoolean(key, value);
    }

    @Override
    public void putString(String key, String value) {
        preferences.putString(key, value);
    }

    @Override
    public void putDouble(String key, Double value) {
        preferences.putDouble(key, value);
    }

    @Override
    public void putInteger(String key, Integer value) {
        preferences.putInt(key, value);
    }

    @Override
    public boolean getBoolean(String key, boolean defaultVal) {
        return preferences.getBoolean(key, defaultVal);
    }

    @Override
    public String getString(String key, String defaultVal) {
        return preferences.getString(key, defaultVal);
    }

    @Override
    public Double getDouble(String key, Double defaultVal) {
        return preferences.getDouble(key, defaultVal);
    }

    @Override
    public Integer getInteger(String key, Integer defaultVal) {
        return preferences.getInt(key, defaultVal);
    }
}
