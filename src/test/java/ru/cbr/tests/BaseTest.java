package ru.cbr.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.cbr.helpers.Attach;
import ru.cbr.pages.FinOrgPage;
import ru.cbr.pages.MainPage;
import ru.cbr.pages.SearchPage;
import ru.cbr.pages.SiteMapPage;
import ru.cbr.pages.blocks.FooterBlock;
import ru.cbr.pages.blocks.HeaderBlock;
import ru.cbr.pages.components.OffsetMenu;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {

    SiteMapPage siteMapPage = new SiteMapPage();
    MainPage mainPage = new MainPage();
    HeaderBlock headerBlock = new HeaderBlock();
    FooterBlock footerBlock = new FooterBlock();
    SearchPage searchPage = new SearchPage();
    FinOrgPage finOrgPage = new FinOrgPage();
    OffsetMenu offsetMenu = new OffsetMenu();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://www.cbr.ru";
        Configuration.browserPosition = "0x0";

        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "125");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        if (System.getProperty("selenoidUrl") != null) {
            Configuration.remote = "https://" +
                    System.getProperty("selenoidAuth") + "@"
                    + System.getProperty("selenoidUrl") + "/wd/hub";

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        }

        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachment() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

        closeWebDriver();
    }

    public void clearCookies() {
        SelenideElement popupCookies = $(".popup-cookies");
        SelenideElement popupCookiesConfirmButton = $(".popup-cookies .btn");

        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();

        if (popupCookies.exists() && popupCookies.isDisplayed())
            popupCookiesConfirmButton.click();

        actions().sendKeys(Keys.HOME).perform();
    }
}
