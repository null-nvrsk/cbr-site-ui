package ru.cbr.pages;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage {

    String title = "Результаты поиска | Банк России";

    public SearchPage verifyPageTitle() {
        $("title").shouldHave(attribute("text", title));
        return this;
    }

    public SearchPage verifyFoundInformation(String searchString) {

        $$(".cross-result .date-number .number").first().shouldHave(text("1"));
        $(".cross-results").shouldHave(text(searchString));
        return this;
    }
}
