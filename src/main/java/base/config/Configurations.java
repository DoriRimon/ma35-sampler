package base.config;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * The Configurations class handles fetches from the config file
 */
public class Configurations {
    private Properties properties;

    /**
     * Initialize properties file to the config file's path
     * @throws IOException - If path is invalid or properties loading failed
     */
    public Configurations() throws IOException {
        this.properties = new Properties();
        properties.load(new FileReader("src/main/resources/config.properties"));
    }

    /**
     * Gets a property value of given key
     * @param key - The property's key
     * @return The related value
     */
    public String get(String key) {
        return this.properties.getProperty(key);
    }
}
