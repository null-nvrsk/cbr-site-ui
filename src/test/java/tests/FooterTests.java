package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.blocks.FooterPage;

@DisplayName("Проверка футера сайта (нижний блок)")
public class FooterTests extends BaseTest {

    private final String[] phoneNumbers = {
            "300",
            "8 800 300-30-00",
            "+7 499 300-30-00"
    };

    private final FooterPage footerPage = new FooterPage();

    @Test
    @DisplayName("Проверка номеров телефонов в футере")
    @Tag("CBR-9")
    void footerPhoneNumberTest() {
        mainPage.openPage();

        for (String number : phoneNumbers) {
            footerPage.verifyPhoneNumber(number);
        }
    }
}
