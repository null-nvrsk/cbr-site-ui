package ru.cbr.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final String HEAD_TITLE_TEXT = "Центральный банк Российской Федерации | Банк России";
    private final  String INFLATION_TARGET_TEXT = "Цель по инфляции";

    SelenideElement popupCookies = $(".popup-cookies");
    SelenideElement popupCookiesConfirmButton = $(".popup-cookies .btn");



    SelenideElement inflationTargetTitle = $(".main-indicator .main-indicator_info");


    public MainPage openPage() {
        open("/");

        // popup-cookies
        if (popupCookies.exists())
            popupCookiesConfirmButton.click();


        inflationTargetTitle.shouldHave(text(INFLATION_TARGET_TEXT));
        return this;
    }

    public MainPage verifyMainPage() {

        // popup-cookies
        if (popupCookies.exists())
            popupCookiesConfirmButton.click();

        $("title").shouldHave(attribute("text", HEAD_TITLE_TEXT));
        inflationTargetTitle.shouldHave(text(INFLATION_TARGET_TEXT));
        return this;
    }
}
