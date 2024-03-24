package ru.cbr;

import org.junit.jupiter.api.Test;

public class SiteMapTests extends BaseTest {
    private int MAP_BLOCKS_COUNT = 24;

    @Test
    void mainGroupsTest() {
        siteMapPage
                .openPage()
                .verifyMainBlocksCount(MAP_BLOCKS_COUNT)
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
    }
}
