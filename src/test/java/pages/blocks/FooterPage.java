package pages.blocks;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class FooterPage {

    @Step("Проверить телефон \"{phoneNumber}\"")
    public FooterPage verifyPhoneNumber(String phoneNumber) {
        $$(".footer_phone_val").find(exactText(phoneNumber)).shouldBe(visible);
        return this;
    }
}
