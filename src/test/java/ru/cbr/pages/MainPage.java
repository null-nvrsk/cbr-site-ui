package ru.cbr.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private String HEAD_TITLE_TEXT = "Центральный банк Российской Федерации | Банк России";
    private String INFLATION_TARGET_TEXT = "Цель по инфляции";

    SelenideElement mainHeadTitle = $("head title");
    SelenideElement inflationTargetTitle = $(".main-indicator .main-indicator_info");


    public MainPage openPage() {
        open("/");
        // mainHeadTitle.shouldHave(text(HEAD_TITLE_TEXT));
        inflationTargetTitle.shouldHave(text(INFLATION_TARGET_TEXT));
        return this;
    }
}
