package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.logevents.SelenideLogger.step;

@DisplayName("Проверка шапки сайта (верхний блок)")
public class HeaderBlockTests extends BaseTest {

    private final String headTitleText = "Центральный банк Российской Федерации | Банк России";
    private final String inflationTargetText = "Цель по инфляции";
    private final String searchText = "цифровой рубль";

    @Test
    @DisplayName("Логотип кликабельный")
    @Tag("smoke")
    @Tag("regression")
    @Tag("CBR-1")
    void checkClickableLogoTest() {
        siteMapPage.openPage();
        headerBlock.clickLogo();

        step("Проверяем, что перешли на главную страницу", () -> {
            mainPage.verifySiteTitle(headTitleText);
            mainPage.verifyInflationTargetTitle(inflationTargetText);
        });
    }

    @Test
    @DisplayName("Быстрый поиск на главной странице")
    @Tag("smoke")
    @Tag("regression")
    @Tag("CBR-2")
    void quickSearchTest() {
        mainPage.openPage();

        step("Ввести запрос в поле поиска и нажить кнопку \"Искать\"", () -> headerBlock.searchOnSite(searchText));

        step("Проверить результаты поиска", () -> {
            searchPage.verifyPageTitle();
            searchPage.verifyFoundInformation(searchText);
        });
    }

    @Test
    @DisplayName("Переключение языка (RU -> EN, EN -> RU)")
    @Tag("smoke")
    @Tag("regression")
    @Tag("CBR-4")
    void switchLocaleTest() {
        mainPage.openPage();

        step("Переключаемся на EN", () -> {
            mainPage.switchLanguage("EN");
            mainPage.verifyLanguage("EN");
        });

        step("Переключаемся на RU", () -> {
            mainPage.switchLanguage("RU");
            mainPage.verifyLanguage("RU");
        });
    }
}