package otcuda.zvuk.qaguru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class SelenideAllureTests {

    @Test
    void shouldFindIssueNumberTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");
        $("[placeholder='Search or jump to...']").click();
        $("#query-builder-test").setValue("eroshenkoam/allure-example").pressEnter();

        $(linkText("eroshenkoam/allure-example")).click();
        $("#issues-tab").click();

        $(withText("#87")).should(Condition.exist);
    }
}
