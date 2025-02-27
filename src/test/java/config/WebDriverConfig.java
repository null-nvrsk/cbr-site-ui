package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:${env}.properties"
})
public interface WebDriverConfig extends Config {

    @Key("webdriver.baseUrl")
    String getBaseUrl();

    @Key("webdriver.remoteUrl")
    String getRemoteUrl();

    @Key("webdriver.browser")
    String getBrowser();

    @Key("webdriver.browserVersion")
    String getBrowserVersion();

    @Key("webdriver.browserSize")
    String getBrowserSize();
}
