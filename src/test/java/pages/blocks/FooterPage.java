package pages.blocks;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class FooterPage {

    private final ElementsCollection phones = $$(".footer_phone_val");

    @Step("Проверить телефон \"{phoneNumber}\"")
    public FooterPage verifyPhoneNumber(String phoneNumber) {
        phones.find(exactText(phoneNumber)).shouldBe(visible);
        return this;
    }
}
