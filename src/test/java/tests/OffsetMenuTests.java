package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.blocks.OffsetMenuPage;

@DisplayName("Проверка бокового меню")
public class OffsetMenuTests extends BaseTest {

    private final OffsetMenuPage offsetMenuPage = new OffsetMenuPage();

    @DisplayName("Проверить 6 общих ссылок в боковом меню")
    @Tag("CBR-13")
    @CsvSource({
            "Меры защиты финансового рынка, /support_measures",
            "Новости, /news",
            "Решения Банка России, /rbr",
            "Контактная информация, /contacts",
            "Карта сайта, /sitemap",
            "О сайте, /about"
    })
    @ParameterizedTest(name = "При клике на \"{0}\" переходит на cbr.ru{1}")
    void offsetMenuQuickLinksTest(String menuItem, String pageUrl) {
        mainPage.openPage();
        offsetMenuPage.openOffsetMenu();

        offsetMenuPage.clickQuickLinkByName(menuItem);
        offsetMenuPage.verifyOpenedByLinkPage(menuItem, pageUrl);
    }
}
