package ru.cbr.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SiteMapPage
{
    private final String TITLE_TEXT = "Карта сайта";
    SelenideElement mainTitle = $("h1");
    ElementsCollection mapBlockTitles = $$("h3.map_block_title");

    public SiteMapPage openPage() {
        open("/sitemap");
        mainTitle.shouldHave(text(TITLE_TEXT));
        return this;
    }

    public SiteMapPage verifyMainBlocksCount(int count) {
        mapBlockTitles.shouldBe(size(count));
        return this;
    }

    public SiteMapPage verifyMainBlockTitle(String title) {
        mapBlockTitles.findBy(text(title)).should(exist);
        return this;
    }
}
