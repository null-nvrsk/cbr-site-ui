package ru.cbr.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.cbr.models.CompanyInfo;
import ru.cbr.models.Region;

import static com.codeborne.selenide.logevents.SelenideLogger.step;

@DisplayName("Поиск организаций, участников финансового рынка")
public class FinOrgTests extends BaseTest {

    @BeforeEach
    void setUp() {
        step("Открываем страницу \"Участники финансового рынка\"", () -> {
            finOrgPage.openPage();
        });
    }

    @ValueSource(strings = {
            "Все", "Действует", "Не действует"
    })
    @DisplayName("Поиск организаций типа \"Бюро кредитных историй\" со статусом вида деятельности")
    @ParameterizedTest(name = "\"{0}\" должен показать не пустой список")
    @Tags({
            @Tag("regression"),
            @Tag("CBR-20")
    })
    void searchFinOrgWithFilterByStatusTest(String status) {
        step("Выбираем статус среди \"Бюро кредитных историй\"", () -> {
            finOrgPage
                    .selectFilterTypeOrganisation("Бюро кредитных историй")
                    .selectFilterActivityStatus(status)
                    .clickSearchButton();
        });

        step("Проверяем, что в результатах есть хотя бы 1 организация", () -> {
            finOrgPage.verifyResultNotEmpty();
        });
    }

    @DisplayName("Поиск организаций по неполному названию")
    @CsvFileSource(resources = "/data/finOrg.csv", delimiter = '\t', numLinesToSkip = 1)
    @ParameterizedTest(name = "Запрос \"{0}\" должен найти компанию {1} (ИНН/ОГРН {2}/{3}). Статус - {4}")
    @Tags({
            @Tag("smoke"),
            @Tag("regression"),
            @Tag("CBR-19")
    })
    void checkByPartialNameOfTheOrganizationTest(String requestString, String companyName, String INN,
                                                 String OGRN, String status)
    {
        step("Ищет по неполному названию организации", () -> {
            finOrgPage
                    .inputSearchPrase(requestString)
                    .clickSearchButton();
        });

        step("Проверяем, что в списке найденных организаций есть искомая организация", () -> {
            CompanyInfo expectedCompanyInfo = new CompanyInfo(companyName, INN, OGRN, status);
            finOrgPage.verifyCompanyInformation(expectedCompanyInfo);
        });
    }

    @EnumSource(Region.class)
    @DisplayName("Поиск по региону организаций типа \"Микрофинансовые организации\" со статусом \"Действует\"")
    @ParameterizedTest(name = ", по региону \"{0}\" должен показать не пустой список")
    @Tags({
            @Tag("regression"),
            @Tag("CBR-21")
    })
    void searchFinOrgWithFilterByRegionTest(Region region) {
        step("Выбираем регион среди \"Микрофинансовые организации\"", () -> {
            finOrgPage
                    .selectFilterTypeOrganisation("Микрофинансовые организации")
                    .selectFilterActivityStatus("Действует")
                    .selectFilterRegion(region.description)
                    .clickSearchButton();
        });

        step("Проверяем, что в результатах есть хотя бы 1 организация", () -> {
            finOrgPage.verifyResultNotEmpty();
        });
    }
}