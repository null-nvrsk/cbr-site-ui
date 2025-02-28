package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private final SelenideElement inflationTarget = $(".main-indicator .main-indicator_info"),
            headerLanguageBlock = $(".home-header_top .header_lang"),
            activeLanguage = $(".home-header_top .header_lang_item._active"),
            logoRus = $(".home-header_top .header_logo"),
            logoEng = $(".home-header_top .header_logo_eng");

    @Step("Открыть главную страниц")
    public MainPage openPage() {
        open("/");
        return this;
    }

    public MainPage verifySiteTitle(String title) {
        $("title").shouldHave(attribute("text", title));
        return this;
    }

    public MainPage verifyInflationTargetTitle(String title) {
        inflationTarget.shouldHave(text(title));
        return this;
    }

    public MainPage switchLanguage(String language) {
        headerLanguageBlock.$(byText(language)).click();
        return this;
    }

    public void verifyLanguage(String language) {
        activeLanguage.shouldHave(text(language));
        if (language.equals("RU")) {
            logoRus.shouldBe(visible);
        } else if (language.equals("EN")) {
            logoEng.shouldBe(visible);
        }
    }
}
