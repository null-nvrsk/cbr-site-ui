package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.logevents.SelenideLogger.step;

@Epic("Вспомогательные статические страницы")
@Feature("Карта сайта")
@DisplayName("Проверка страницы \"Карта сайта\"")
public class SiteMapTests extends BaseTest {

    int mapBlocksCount = 24;

    @Test
    @DisplayName("Проверить заголовки верхнего уровня")
    @Story("Заголовки 1-го уровня")
    @Tag("smoke")
    void mainGroupsTest() {
        siteMapPage.openPage();

        step("Проверяем количество блоков верхнего уровня", () -> {
            siteMapPage.verifyMainBlocksCount(mapBlocksCount);
        });

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
