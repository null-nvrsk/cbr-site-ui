package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import models.CompanyInfo;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class FinOrgPage {

    private final SelenideElement searchInputField = $("#SearchPrase"),
            searchButton = $("#searchBtn"),
            typeOrganisationButton = $("#ui-id-1 button"),
            activityStatusButton = $("#ui-id-3 button"),
            regionButton = $("#ui-id-4 button");
    private final ElementsCollection dropdownFilterOptions = $$(".open .filter-select_options label"),
            resultTableRows = $$("#resultTable tbody tr");

    @Step("Открыть страницу \"Участники финансового рынка\"")
    public FinOrgPage openPage() {
        open("/finorg");
        return this;
    }

    @Step("Выбрать тип участника финансового рынка \"{type}\"")
    public FinOrgPage selectFilterTypeOrganisation(String type) {
        typeOrganisationButton.click();
        dropdownFilterOptions.find(text(type)).click();
        return this;
    }

    @Step("Выбрать статус участника финансового рынка \"{status}\"")
    public FinOrgPage selectFilterActivityStatus(String status) {
        activityStatusButton.click();
        dropdownFilterOptions.find(text(status)).click();
        return this;
    }

    @Step("Выбрать субъект РФ \"{regionString}\"")
    public FinOrgPage selectFilterRegion(String regionString) {
        regionButton.click();
        dropdownFilterOptions.find(text(regionString)).click();
        return this;
    }

    @Step("Ввести \"{requestString}\" в поисковый запрос")
    public FinOrgPage inputSearchPhrase(String requestString) {
        searchInputField.setValue(requestString);
        return this;
    }

    @Step("Нажать кнопку \"Искать\"")
    public void clickSearchButton() {
        searchButton.click();
    }

    @Step("Проверить, что в результатах есть хотя бы 1 организация")
    public FinOrgPage verifyResultNotEmpty() {
        resultTableRows.shouldBe(sizeGreaterThan(0));
        return this;
    }

    @Step("Проверить, что в списке найденных организаций есть искомая организация")
    public void verifyCompanyInformation(CompanyInfo expectedCompanyInfo) {
        SelenideElement foundINN = $(byTagAndText("td", expectedCompanyInfo.getINN()));
        SelenideElement foundRow = foundINN.closest("tr");
        SelenideElement foundCompanyName = foundRow.$$("td").get(0);
        SelenideElement foundOGRN = foundRow.$$("td").get(2);
        SelenideElement foundStatus = foundRow.$$("td").get(4);

        foundCompanyName.shouldHave(text(expectedCompanyInfo.getCompanyName()));
        foundOGRN.shouldHave(text(expectedCompanyInfo.getOGRN()));
        foundStatus.shouldHave(text(expectedCompanyInfo.getStatus()));
    }
}
