package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SiteMapPage {

    String titleText = "Карта сайта";
    SelenideElement mainTitle = $("h1");
    ElementsCollection mapBlockTitles = $$("h3.map_block_title");

    @Step("Открыть страницу \"Карта сайта\"")
    public SiteMapPage openPage() {
        open("/sitemap");
        mainTitle.shouldHave(text(titleText));
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
