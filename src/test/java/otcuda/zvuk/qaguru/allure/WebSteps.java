package otcuda.zvuk.qaguru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;


public class WebSteps {
    @Step("Открываем главную страницу GitHub")
    public void openMainPage(){
        open("https://github.com/");
    }

    @Step("Ищем репозиторий {repo}")
    public void searchRepository(String repo){
        $("[placeholder='Search or jump to...']").click();
        $("#query-builder-test").setValue(repo).pressEnter();
    }

    @Step("Переходим в репозиторий {repo}")
    public void clickOnRepositoryLink(String repo){
        $(linkText(repo)).click();
    }

    @Step("Открываем таб Issues")
    public void openTabIssue(){
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие Issue с номером {issueNumber}")
    public void checkIssueWithNumber(int issueNumber){
        $(withText("#" + issueNumber)).should(Condition.exist);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot(){
        return ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
