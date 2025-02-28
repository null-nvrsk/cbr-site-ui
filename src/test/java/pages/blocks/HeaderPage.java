package pages.blocks;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;

public class HeaderPage {

    private final SelenideElement logoLink = $$("header .header_logo").find(Condition.visible),
            searchFieldInput = $$(".home-header_search_field input").find(Condition.visible),
            searchFieldButton = $$(".home-header_search_field button").find(Condition.visible);

    @Step("Кликнуть на логотип в шапке")
    public void clickLogo() {
        logoLink.click();
    }

    @Step("Ввести \"{findString}\" в поле поиска и нажить кнопку \"Искать\"")
    public void searchOnSite(String findString) {
        searchFieldInput.setValue(findString);
        searchFieldButton.click();
    }
}
