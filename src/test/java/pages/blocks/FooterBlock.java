package pages.blocks;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;

public class FooterBlock {

    @Step("Проверить телефон \"{phoneNumber}\"")
    public FooterBlock verifyPhoneNumber(String phoneNumber) {
        $$(".footer_phone_val").find(exactText(phoneNumber)).shouldBe(visible);
        return this;
    }
}
