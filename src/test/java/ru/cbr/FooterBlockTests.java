package ru.cbr;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Проверка футера сайта (нижний блок)")
public class FooterBlockTests extends BaseTest {

    @ParameterizedTest(name = "Телефон {0} есть")
    @DisplayName("Проверка номеров телефонов в футере")
    @Tag("CBR-9")
    @Owner("MaksimSkomorokhov")
    @ValueSource(strings = {
            "300",
            "8 800 300-30-00",
            "+7 499 300-30-00"
    })
    void footerPhoneNumberTest(String phoneNumber) {
        footerBlock.verifyPhoneNumber(phoneNumber);
    }
}
