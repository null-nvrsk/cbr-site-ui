package pages.blocks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlStartingWith;

public class OffsetMenuPage {

    private final SelenideElement offsetMenu = $(".offsetMenu .home-header_content .header_menu");
    private final ElementsCollection quickLinks = $$(".menu_quick_links .inner_links a");

    @Step("Вызывать боковое меню")
    public void openOffsetMenu() {
        offsetMenu.click();
    }

    @Step("Кликнуть в меню по ссылке на \"{menuItem}\"")
    public void clickQuickLinkByName(String menuItem) {
        quickLinks.find(exactText(menuItem)).click();
    }

    @Step("Проверить, что открылась страница \"menuItem\"")
    public void verifyOpenedByLinkPage(String menuItem, String pageUrl) {
        webdriver().shouldHave(urlStartingWith(Configuration.baseUrl + pageUrl));
        $("h1 span").shouldHave(text(menuItem));
    }
}
