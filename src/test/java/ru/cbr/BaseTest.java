package ru.cbr;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.cbr.pages.SearchPage;
import ru.cbr.pages.blocks.FooterBlock;
import ru.cbr.pages.blocks.HeaderBlock;
import ru.cbr.pages.MainPage;
import ru.cbr.pages.SiteMapPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    SiteMapPage siteMapPage = new SiteMapPage();
    MainPage mainPage = new MainPage();
    HeaderBlock headerBlock = new HeaderBlock();
    FooterBlock footerBlock = new FooterBlock();
    SearchPage searchPage = new SearchPage();

    SelenideElement popupCookies = $(".popup-cookies");
    SelenideElement popupCookiesConfirmButton = $(".popup-cookies .btn");

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://www.cbr.ru";
        Configuration.browserPosition = "0x0";
        Configuration.browserSize = "1920x1080";

        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    void beforeEach() {
        open("/");
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();

        // popup-cookies
        if (popupCookies.exists() && popupCookies.isDisplayed())
            popupCookiesConfirmButton.click();
    }
}
