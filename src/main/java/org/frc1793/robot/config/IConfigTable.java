package org.frc1793.robot.config;

/**
 * Created by tyler on 4/12/17.
 */
public interface IConfigTable {
    boolean containsKey(String key);
    void putBoolean(String key, Boolean value);
    void putString(String key, String value);
    void putDouble(String key, Double value);
    void putInteger(String key, Integer value);

    boolean getBoolean(String key, boolean defaultVal);
    String getString(String key, String defaultVal);
    Double getDouble(String key, Double defaultVal);
    Integer getInteger(String key, Integer defaultVal);
}
