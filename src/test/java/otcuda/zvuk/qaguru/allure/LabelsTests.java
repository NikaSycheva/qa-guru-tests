package otcuda.zvuk.qaguru.allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTests {
    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("sychevavm")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://testing.github.com")
    @DisplayName("Создание Issue для авотризованного пользователя")
    void staticLabelsTest() {
    }

    @Test
    public void dynamicLabelsTest() {
        Allure.getLifecycle().updateTestCase(
                t -> t.setName("Создание Issue для авотризованного пользователя")
        );
        Allure.feature("Issue в репозитории");
        Allure.story("Создание Issue");
        Allure.label("owner", "sychevavm");
        Allure.label("severity", SeverityLevel.CRITICAL.value());
        Allure.link("Testing", "https://testing.github.com");
    }
}
