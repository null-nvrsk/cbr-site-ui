package ru.cbr;

import org.junit.jupiter.api.Test;

public class HeaderBlockTests extends BaseTest {

    @Test
    void clickLogoTest() {
        mainPage.openPage();
        headerBlock.clickLogo();
    }
}
