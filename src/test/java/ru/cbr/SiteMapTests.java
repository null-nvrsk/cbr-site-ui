package ru.cbr;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.logevents.SelenideLogger.step;

@Feature("Вспомогательные статические страницы")
@Story("Карта сайта")
@DisplayName("Проверка страницы \"Карта сайта\"")
public class SiteMapTests extends BaseTest {
    private final int MAP_BLOCKS_COUNT = 24;

    @Test
    @DisplayName("Проверка заголовков верхнего уровня")
    @Owner("MaksimSkomorokhov")
    @Tag("CBR-15")
    void mainGroupsTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем страницу \"Карта сайта\"", () -> {
            siteMapPage.openPage();
        });

        step("Проверяем количество блоков вехнего уровня", () -> {
            siteMapPage.verifyMainBlocksCount(MAP_BLOCKS_COUNT);
        });

        // TODO: Сделать проверку через ValueSource или CsvRource
        step("Проверяем заголовок каждого блока", () -> {
            siteMapPage
                    .verifyMainBlockTitle("Денежно-кредитная политика")
                    .verifyMainBlockTitle("Финансовая стабильность")
                    .verifyMainBlockTitle("Национальная платежная система")
                    .verifyMainBlockTitle("Наличное денежное обращение")
                    .verifyMainBlockTitle("Развитие финансового рынка")
                    .verifyMainBlockTitle("Развитие финансовых технологий")
                    .verifyMainBlockTitle("Защита прав потребителей финансовых услуг")
                    .verifyMainBlockTitle("Информационная безопасность")
                    .verifyMainBlockTitle("Противодействие недобросовестным практикам")
                    .verifyMainBlockTitle("Противодействие отмыванию денег и валютный контроль")
                    .verifyMainBlockTitle("Допуск на финансовый рынок")
                    .verifyMainBlockTitle("Деловая репутация")
                    .verifyMainBlockTitle("Исследования")
                    .verifyMainBlockTitle("Операции Банка России")
                    .verifyMainBlockTitle("Банковский сектор")
                    .verifyMainBlockTitle("Пенсионные фонды и коллективные инвестиции")
                    .verifyMainBlockTitle("Страхование")
                    .verifyMainBlockTitle("Рынок ценных бумаг")
                    .verifyMainBlockTitle("Эмитенты и корпоративное управление")
                    .verifyMainBlockTitle("Микрофинансирование")
                    .verifyMainBlockTitle("Инфраструктура финансового рынка")
                    .verifyMainBlockTitle("Кредитные истории")
                    .verifyMainBlockTitle("О Банке России")
                    .verifyMainBlockTitle("Прочее");
        });
    }
}
