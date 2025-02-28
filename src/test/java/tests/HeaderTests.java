package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.blocks.HeaderPage;

import static com.codeborne.selenide.logevents.SelenideLogger.step;

@Tag("web")
@Owner("Maksim Skomorokhov")
@Epic("UI")
@Feature("Шапка")
@DisplayName("Проверка шапки сайта (верхний блок)")
public class HeaderTests extends BaseTest {

    private final String headTitleText = "Центральный банк Российской Федерации | Банк России";
    private final String inflationTargetText = "Цель по инфляции";
    private final String searchText = "цифровой рубль";

    private final HeaderPage headerPage = new HeaderPage();

    @Test
    @DisplayName("Проверить кликабельность логотипа")
    @Story("Проверить логотип")
    @Tag("smoke")
    void checkClickableLogoTest() {
        siteMapPage.openPage();
        headerPage.clickLogo();

        step("Проверить, что перешли на главную страницу", () -> {
            mainPage.verifySiteTitle(headTitleText);
            mainPage.verifyInflationTargetTitle(inflationTargetText);
        });
    }

    @Test
    @DisplayName("Быстрый поиск на главной странице")
    @Story("Поиск в поле быстрого поиска")
    @Tag("smoke")
    void quickSearchTest() {
        mainPage.openPage();
        headerPage.searchOnSite(searchText);

        searchPage.verifyPageTitle()
                .verifyFoundInformation(searchText);
    }

    @Test
    @DisplayName("Переключение языка (RU -> EN, EN -> RU)")
    @Story("Переключение языка")
    @Tag("smoke")
    void switchLocaleTest() {
        mainPage.openPage();

        step("Переключить язык на Английский", () -> {
            mainPage.switchLanguage("EN");
            mainPage.verifyLanguage("EN");
        });

        step("Переключить язык на Русский", () -> {
            mainPage.switchLanguage("RU");
            mainPage.verifyLanguage("RU");
        });
    }
}