package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigProvider {

    public static final WebDriverConfig webDriverConfig = ConfigFactory
            .create(WebDriverConfig.class, System.getProperties());
}
