package config;

import constants.Config;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Hello world!
 */
public class ConfigProperties {
    Properties prop;
    FileInputStream fis;

    public ConfigProperties() throws IOException {
        prop = new Properties();
        fis = new FileInputStream(Config.CONFIGFILEPATH);
        prop.load(fis);
    }

    public String getURL() {
        return prop.getProperty(Config.URL);
    }

    public String getBrowser() {
        return prop.getProperty(Config.BROWSER);
    }
}



