package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Epic("Вспомогательные статические страницы")
@Feature("Карта сайта")
@DisplayName("Проверить страницу \"Карта сайта\"")
public class SiteMapTests extends BaseTest {

    int mapBlocksCount = 24;
    String[] blocks = {
            "Денежно-кредитная политика",
            "Финансовая стабильность",
            "Национальная платежная система",
            "Наличное денежное обращение",
            "Развитие финансового рынка",
            "Развитие финансовых технологий",
            "Защита прав потребителей финансовых услуг",
            "Информационная безопасность",
            "Противодействие недобросовестным практикам",
            "Противодействие отмыванию денег и валютный контроль",
            "Допуск на финансовый рынок",
            "Деловая репутация",
            "Исследования",
            "Операции Банка России",
            "Банковский сектор",
            "Пенсионные фонды и коллективные инвестиции",
            "Страхование",
            "Рынок ценных бумаг",
            "Эмитенты и корпоративное управление",
            "Микрофинансирование",
            "Инфраструктура финансового рынка",
            "Кредитные истории",
            "О Банке России",
            "Прочее"
    };

    @Test
    @DisplayName("Проверить заголовки верхнего уровня")
    @Story("Заголовки 1-го уровня")
    @Tag("smoke")
    void mainGroupsTest() {
        siteMapPage.openPage();

        siteMapPage.verifyMainBlocksCount(mapBlocksCount);
        for (String block : blocks) {
            siteMapPage.verifyMainBlockTitle(block);
        }
    }
}
