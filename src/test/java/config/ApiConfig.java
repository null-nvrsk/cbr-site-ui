package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/${env}.properties",
        "classpath:config/local-chrome.properties"
})
public interface ApiConfig extends Config {

    @Key("api.baseURI")
    String getBaseURI();
}
