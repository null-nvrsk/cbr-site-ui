package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import models.CompanyInfo;
import models.Region;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.FinOrgPage;

@Tag("web")
@Owner("Maksim Skomorokhov")
@Epic("Блок \"Прочее\"")
@Feature("Проверить участника финансового рынка")
@DisplayName("Поиск организаций, участников финансового рынка")
public class FinOrgTests extends BaseTest {

    private final FinOrgPage finOrgPage = new FinOrgPage();

    @DisplayName("Поиск организаций по неполному названию")
    @CsvFileSource(resources = "/data/finOrg.csv", delimiter = '\t', numLinesToSkip = 1)
    @ParameterizedTest(name = "Запрос \"{0}\" должен найти компанию {1} (ИНН/ОГРН {2}/{3}). Статус - {4}")
    @Story("Поиск организаций по неполному названию")
    @Tag("smoke")
    void checkByPartialNameOfTheOrganizationTest(String requestString, String companyName, String INN,
                                                 String OGRN, String status) {
        finOrgPage.openPage()
                .inputSearchPhrase(requestString)
                .clickSearchButton();

        CompanyInfo expectedCompanyInfo = new CompanyInfo(companyName, INN, OGRN, status);
        finOrgPage.verifyCompanyInformation(expectedCompanyInfo);
    }

    @ValueSource(strings = {
            "Все", "Действует", "Не действует"
    })
    @DisplayName("Проверить фильтр поиска \"Статус УФР/вида деятельности\"")
    @ParameterizedTest(name = "\"{0}\" должен показать не пустой список")
    @Story("Проверить фильтр \"Статус УФР/вида деятельности\"")
    void searchFinOrgWithFilterByStatusTest(String status) {
        finOrgPage.openPage()
                .selectFilterTypeOrganisation("Бюро кредитных историй")
                .selectFilterActivityStatus(status)
                .clickSearchButton();

        finOrgPage.verifyResultNotEmpty();
    }

    @EnumSource(Region.class)
    @DisplayName("Проверить фильтр поиска по региону организаций")
    @ParameterizedTest(name = "по региону \"{0}\" должен показать не пустой список")
    @Story("Проверить фильтр по региону")
    void searchFinOrgWithFilterByRegionTest(Region region) {
        finOrgPage.openPage()
                .selectFilterTypeOrganisation("Микрофинансовые организации")
                .selectFilterActivityStatus("Действует")
                .selectFilterRegion(region.description)
                .clickSearchButton();

        finOrgPage.verifyResultNotEmpty();
    }
}
