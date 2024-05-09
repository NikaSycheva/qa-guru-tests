package otcuda.zvuk.qaguru;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class SelenideGitHubTests {
    @Test
    void shouldFindSelenideRepositoryAtTheTopTest() {
        open("https://github.com/");
        $("[placeholder='Search or jump to...']").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        $$("[data-testid=results-list]").first().$("a").click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
    }

    @Test
    void andreiSolntsevShouldBeTheFirstContributorTest(){
        open("https://github.com/selenide/selenide");
        //подвести мышку к первой иконке контребьютеров
        $("div.Layout-sidebar").$(byText("Contributors")).closest("h2")
                .sibling(0).$$("li").first().hover();
        //проверить что это андрей солнцев
        $(".Popover-message").shouldHave(text("Andrei Solntsev"));
    }

    @Test
    void wikiPageShouldHaveSoftAssertionsPageWithJUnit5Test(){
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $(".filterable-active").shouldHave(text("SoftAssertions"));
        $(byText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
    }

    @Test
    void checkEnterprisePageTitleTest(){
        open("https://github.com/");

        $(withText("Solutions")).hover();
        $(withTagAndText("a", "Enterprise")).click();

        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform"));
    }

    @Test
    void dragAndDropTest(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").shouldHave(exactText("A"));
        $("#column-b").shouldHave(exactText("B"));

        $("#column-a").dragAndDrop(to("#column-b"));

        $("#column-a").shouldHave(exactText("B"));
        $("#column-b").shouldHave(exactText("A"));
    }
}
