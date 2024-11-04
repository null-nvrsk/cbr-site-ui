package ru.cbr.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.logevents.SelenideLogger.step;

@DisplayName("Проверка шапки сайта (верхний блок)")
public class HeaderBlockTests extends BaseTest {

    private final String HEAD_TITLE_TEXT = "Центральный банк Российской Федерации | Банк России";
    private final String INFLATION_TARGET_TEXT = "Цель по инфляции";

    @Test
    @DisplayName("Логотип кликабельный")
    @Tag("CBR-1")
    void checkClickableLogoTest() {
        step("Открываем не главную страниц", () -> {
            // TODO: переходим на случайную страницу из списка
            siteMapPage.openPage();
            clearCookies();
        });

        step("Кликаем на логотип в шапке", () -> {
            headerBlock.clickLogo();
        });

        step("Проверяем, что перешли на главную страницу", () -> {
            mainPage.verifySiteTitle(HEAD_TITLE_TEXT);
            mainPage.verifyInflationTargetTitle(INFLATION_TARGET_TEXT);
        });
    }

    @Test
    @DisplayName("Быстрый поиск на главной странице")
    @Tag("CBR-2")
    void quickSearchTest() {
        String searchText = "цифровой рубль";

        step("Открыть главную страниц", () -> {
            mainPage.openPage();
            clearCookies();
        });

        step("Ввести запрос в поле поиска и нажить кнопку \"Искать\"", () -> headerBlock.searchOnSite(searchText));

        step("Проверить результаты поиска", () -> {
            searchPage.verifyPageTitle();
            searchPage.verifyFoundInformation(searchText);
        });
    }

    @Test
    @DisplayName("Переключение языка (RU -> EN, EN -> RU)")
    @Tag("CBR-4")
    void switchLocaleTest() {
        step("Открыть главную страниц", () -> {
            mainPage.openPage();
            clearCookies();
        });

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