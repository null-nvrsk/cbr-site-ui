package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/${env}.properties",
        "classpath:config/local-chrome.properties"
})
public interface WebDriverConfig extends Config {

    @Key("webdriver.baseUrl")
    String getBaseUrl();

    @Key("webdriver.remoteUrl")
    String getRemoteUrl();

    @Key("webdriver.browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("webdriver.browserVersion")
    @DefaultValue("125.0")
    String getBrowserVersion();

    @Key("webdriver.browserSize")
    String getBrowserSize();
}
