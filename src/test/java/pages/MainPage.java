package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

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
        $(".main-indicator .main-indicator_info").shouldHave(text(title));
        return this;
    }

    public MainPage switchLanguage(String language) {
        $(".home-header_top .header_lang").$(byText(language)).click();
        return this;
    }

    public void verifyLanguage(String language) {
        $(".home-header_top .header_lang_item._active").shouldHave(text(language));
        if (language.equals("RU")) {
            $(".home-header_top .header_logo").shouldBe(visible);
        } else if (language.equals("EN")) {
            $(".home-header_top .header_logo_eng").shouldBe(visible);
        }
    }
}
