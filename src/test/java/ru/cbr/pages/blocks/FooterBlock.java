package ru.cbr.pages.blocks;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;

public class FooterBlock {

    public FooterBlock verifyPhoneNumber(String phoneNumber) {
        $$(".footer_phone_val").find(exactText(phoneNumber)).shouldBe(visible);
        return this;
    }
}
