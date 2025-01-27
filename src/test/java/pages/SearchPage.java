package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage {

    String title = "Результаты поиска | Банк России";

    @Step("Проверить, что открылась страница результатов поиска")
    public SearchPage verifyPageTitle() {
        $("title").shouldHave(attribute("text", title));
        return this;
    }

    @Step("Проверить, что в результатах поиска есть записи с текстом \"{searchString}\"")
    public SearchPage verifyFoundInformation(String searchString) {
        $$(".cross-result .date-number .number").first().shouldHave(text("1"));
        $(".cross-results").shouldHave(text(searchString));
        return this;
    }
}
