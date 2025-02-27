package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.MainPage;
import pages.SearchPage;
import pages.SiteMapPage;
import pages.components.CookiesComponent;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static config.ConfigProvider.webDriverConfig;

public class BaseTest {

    protected final MainPage mainPage = new MainPage();
    protected final SiteMapPage siteMapPage = new SiteMapPage();
    protected final SearchPage searchPage = new SearchPage();
    protected final CookiesComponent cookiesComponent = new CookiesComponent();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = webDriverConfig.getBaseUrl();

        if (webDriverConfig.getRemoteUrl() != null) {
            Configuration.remote = webDriverConfig.getRemoteUrl();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        }

        Configuration.browser = System.getProperty("browser", webDriverConfig.getBrowser());
        Configuration.browserVersion = System.getProperty("browserVersion",  webDriverConfig.getBrowserVersion());
        Configuration.browserSize = System.getProperty("browserSize", webDriverConfig.getBrowserSize());
    }

    @BeforeEach
    void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        cookiesComponent.addAcceptCookies();
    }

    @AfterEach
    void addAttachment() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

        closeWebDriver();
    }
}
