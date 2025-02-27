package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.blocks.FooterPage;

@Tag("web")
@Owner("Maksim Skomorokhov")
@Epic("UI")
@Feature("Футер")
@DisplayName("Проверка футера сайта (нижний блок)")
public class FooterTests extends BaseTest {

    private final String[] phoneNumbers = {
            "300",
            "8 800 300-30-00",
            "+7 499 300-30-00"
    };

    private final FooterPage footerPage = new FooterPage();

    @Test
    @Story("Проверить номера телефонов")
    @DisplayName("Проверить номера телефонов в футере")
    void footerPhoneNumberTest() {
        mainPage.openPage();

        for (String number : phoneNumbers) {
            footerPage.verifyPhoneNumber(number);
        }
    }
}
