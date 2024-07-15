package ru.cbr.blocks;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HeaderBlock {

    SelenideElement logoLink = $(".home-header_top .header_logo");

    public void clickLogo() {
        logoLink.click();
    }
}
