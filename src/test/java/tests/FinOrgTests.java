package tests;

import models.CompanyInfo;
import models.Region;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.FinOrgPage;

import static io.qameta.allure.Allure.step;

@DisplayName("Поиск организаций, участников финансового рынка")
public class FinOrgTests extends BaseTest {

    private final FinOrgPage finOrgPage = new FinOrgPage();

    @DisplayName("Поиск организаций по неполному названию")
    @CsvFileSource(resources = "/data/finOrg.csv", delimiter = '\t', numLinesToSkip = 1)
    @ParameterizedTest(name = "Запрос \"{0}\" должен найти компанию {1} (ИНН/ОГРН {2}/{3}). Статус - {4}")
    @Tag("smoke")
    @Tag("CBR-19")
    void checkByPartialNameOfTheOrganizationTest(String requestString, String companyName, String INN,
                                                 String OGRN, String status) {
        finOrgPage.openPage();

        step("Ищет по неполному названию организации", () -> {
            finOrgPage
                    .inputSearchPrase(requestString)
                    .clickSearchButton();
        });

        CompanyInfo expectedCompanyInfo = new CompanyInfo(companyName, INN, OGRN, status);
        finOrgPage.verifyCompanyInformation(expectedCompanyInfo);
    }

    @ValueSource(strings = {
            "Все", "Действует", "Не действует"
    })
    @DisplayName("Проверить фильтр поиска \"Статус вида деятельности\"")
    @ParameterizedTest(name = "\"{0}\" должен показать не пустой список")
    @Tag("CBR-20")
    void searchFinOrgWithFilterByStatusTest(String status) {
        finOrgPage.openPage();

        step("Выбираем статус среди \"Бюро кредитных историй\"", () -> {
            finOrgPage
                    .selectFilterTypeOrganisation("Бюро кредитных историй")
                    .selectFilterActivityStatus(status)
                    .clickSearchButton();
        });

        finOrgPage.verifyResultNotEmpty();
    }

    @EnumSource(Region.class)
    @DisplayName("Проверить фильтр поиска по региону организаций")
    @ParameterizedTest(name = "по региону \"{0}\" должен показать не пустой список")
    @Tag("CBR-21")
    void searchFinOrgWithFilterByRegionTest(Region region) {
        finOrgPage.openPage();

        step("Выбираем регион среди \"Микрофинансовые организации\"", () -> {
            finOrgPage
                    .selectFilterTypeOrganisation("Микрофинансовые организации")
                    .selectFilterActivityStatus("Действует")
                    .selectFilterRegion(region.description)
                    .clickSearchButton();
        });

        finOrgPage.verifyResultNotEmpty();
    }
}
