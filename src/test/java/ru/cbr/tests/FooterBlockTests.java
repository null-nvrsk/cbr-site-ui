package ru.cbr.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.logevents.SelenideLogger.step;

@DisplayName("Проверка футера сайта (нижний блок)")
public class FooterBlockTests extends BaseTest {

    String[] phoneNumbers = {
            "300",
            "8 800 300-30-00",
            "+7 499 300-30-00"
    };

    @Test
    @DisplayName("Проверка номеров телефонов в футере")
    @Tags({
            @Tag("regression"),
            @Tag("CBR-9")
    })
    void footerPhoneNumberTest() {
        step("Открываем главную страниц", () -> {
            mainPage.openPage();
            clearCookies();
        });
        for (String number : phoneNumbers) {
            step("Проверить телефон {{phoneNumber}}", () -> {
                footerBlock.verifyPhoneNumber(number);
            });
        }
    }
}
