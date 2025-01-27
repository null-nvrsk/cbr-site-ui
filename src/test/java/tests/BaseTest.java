package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.FinOrgPage;
import pages.MainPage;
import pages.SearchPage;
import pages.SiteMapPage;
import pages.blocks.FooterBlock;
import pages.blocks.HeaderBlock;
import pages.components.CookiesComponent;
import pages.components.OffsetMenu;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static config.ConfigProvider.webDriverConfig;

public class BaseTest {

    SiteMapPage siteMapPage = new SiteMapPage();
    MainPage mainPage = new MainPage();
    HeaderBlock headerBlock = new HeaderBlock();
    FooterBlock footerBlock = new FooterBlock();
    SearchPage searchPage = new SearchPage();
    FinOrgPage finOrgPage = new FinOrgPage();
    OffsetMenu offsetMenu = new OffsetMenu();
    CookiesComponent cookiesComponent = new CookiesComponent();

    @BeforeAll
    static void beforeAll() {
        // RestAssured.baseURI = apiConfig.getBaseURI();

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

        Configuration.browser = webDriverConfig.getBrowser();
        Configuration.browserVersion = webDriverConfig.getBrowserVersion();
        Configuration.browserSize = webDriverConfig.getBrowserSize();
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
