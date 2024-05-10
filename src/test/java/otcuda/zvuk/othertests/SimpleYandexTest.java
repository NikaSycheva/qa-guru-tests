package otcuda.zvuk.othertests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@DisplayName("Страница поиска яндекс")
public class SimpleYandexTest {

    @BeforeEach
    void setup(){
        Selenide.open("https://ya.ru");
    }

    @Test
    @DisplayName("Проверка числа результатов в поиске яндекса")
    void searchResultsShouldBeGreaterThan10(){
        $("#text").setValue("Selenide");
        $("button[type='submit']").click();
        $$("#search-result > li").shouldHave(sizeGreaterThanOrEqual(8));
    }

    @ValueSource(strings = {
            "Selenide", "Allure"
    })
    @ParameterizedTest(name = "В выдаче яндекса должно выдаваться не меньше 10 результатов по запросу {0}")
    @DisplayName("Поиск по тексту")
    void searchResultsShouldBeLessThan10(String testData){
        $("#text").setValue(testData);
        $("button[type='submit']").click();
        $$("#search-result > li").shouldHave(sizeGreaterThanOrEqual(10));
    }

    @CsvSource(value = {
            "selenide,          лаконичные и стабильные UI тесты на Java",
            "allure framework,  Open-source HTML test automation report tool"
    })
    //@CsvFileSource(resources = "/testdata/searchResultShoudBeContainText.csv")
    @ParameterizedTest(name = "В первом результате выдачи для {0} есть текст {1}")
    @DisplayName("Поиск по тексту")
    void firstSearchResultsShouldContainExpectedText(String testData, String expectedText){
        $("#text").setValue(testData);
        $("button[type='submit']").click();
        $$("#search-result > li").first().shouldHave(Condition.text(expectedText));
    }
}
