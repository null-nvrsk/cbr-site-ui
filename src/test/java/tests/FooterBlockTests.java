package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Проверка футера сайта (нижний блок)")
public class FooterBlockTests extends BaseTest {

    String[] phoneNumbers = {
            "300",
            "8 800 300-30-00",
            "+7 499 300-30-00"
    };

    @Test
    @DisplayName("Проверка номеров телефонов в футере")
    @Tag("regression")
    @Tag("CBR-9")
    void footerPhoneNumberTest() {
        mainPage.openPage();

        for (String number : phoneNumbers) {
            footerBlock.verifyPhoneNumber(number);
        }
    }
}
