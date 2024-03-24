package ru.cbr;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import ru.cbr.pages.SiteMapPage;

public class BaseTest {
    SiteMapPage siteMapPage = new SiteMapPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://www.cbr.ru";
        Configuration.browserPosition = "0x0";
        Configuration.browserSize = "1920x1040";
        // Configuration.holdBrowserOpen = true;
    }
}
