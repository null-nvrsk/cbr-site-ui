package pages.components;

import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CookiesComponent {

    @Step("Подтвердить использование файлов cookie")
    public void addAcceptCookies() {
        open("/common/images/icons/arr_main.svg");
        getWebDriver().manage().addCookie(new Cookie("accept", "1"));
    }
}
