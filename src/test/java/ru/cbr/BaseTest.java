package ru.cbr;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import ru.cbr.blocks.HeaderBlock;
import ru.cbr.pages.MainPage;
import ru.cbr.pages.SiteMapPage;

public class BaseTest {
    SiteMapPage siteMapPage = new SiteMapPage();
    MainPage mainPage = new MainPage();
    HeaderBlock headerBlock = new HeaderBlock();


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://www.cbr.ru";
        Configuration.browserPosition = "0x0";
        Configuration.browserSize = "1920x1040";
//        Configuration.holdBrowserOpen = true;

        SelenideLogger.addListener("allure", new AllureSelenide());
    }
}
