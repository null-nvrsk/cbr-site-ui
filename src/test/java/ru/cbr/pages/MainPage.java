package ru.cbr.pages;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    public MainPage openPage() {
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
