package pages.blocks;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;

public class HeaderBlock {

    SelenideElement logoLink = $$("header .header_logo").find(Condition.visible);
    SelenideElement searchFieldInput = $$(".home-header_search_field input").find(Condition.visible);
    SelenideElement searchFieldButton = $$(".home-header_search_field button").find(Condition.visible);

    @Step("Кликнуть на логотип в шапке")
    public void clickLogo() {
        logoLink.click();
    }

    public void searchOnSite(String findString) {
        searchFieldInput.setValue(findString);
        searchFieldButton.click();
    }
}
