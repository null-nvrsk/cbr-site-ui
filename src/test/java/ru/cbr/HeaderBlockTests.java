package ru.cbr;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.logevents.SelenideLogger.step;

@DisplayName("Проверка шапки сайта (верхний блок)")
public class HeaderBlockTests extends BaseTest {

    // TODO: Убрать popup-окно про Cookies (когда оно открывается, из любого окна)

    @Test
    @DisplayName("Логотип кликабельный")
    @Owner("MaksimSkomorokhov")
    @Tag("CBR-1")
    void checkClickableLogoTest() {
        step("Открываем не главную страниц", () -> {
            // TODO: переходим на случайную страницу из списка
            siteMapPage.openPage();
        });

        step("Кликаем на логотип в шапке", () -> {
            headerBlock.clickLogo();
        });

        step("Проверяем, что перешли на главную страницу", () -> {
            mainPage.verifyMainPage();
        });
    }
}
