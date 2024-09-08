package ru.cbr.pages;

import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    public MainPage openPage() {
        // По умолчанию в BeforeEach открывается главная страница
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        if(!currentUrl.equals(baseUrl + "/"))
            open("/");
        return this;
    }

    public MainPage verifySiteTitle(String title) {
        $("title").shouldHave(attribute("text", title));
        return this;
    }

    public MainPage verifyInflationTargetTitle(String title) {
        $(".main-indicator .main-indicator_info").shouldHave(text(title));
        return this;
    }
}
