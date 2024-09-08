package ru.cbr.blocks;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;

public class HeaderBlock {

    SelenideElement logoLink = $$("header .header_logo").find(Condition.visible);

    public void clickLogo() {
        logoLink.click();
    }
}
