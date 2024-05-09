package otcuda.zvuk.qaguru;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests {

    @BeforeAll
    static void beforeAll() {
        open("http://85.192.34.140:8081");
    }

    @Test
    void textBoxFormTest() {
        $x("//h5[text()='Elements']").click();
        $x("//span[text()='Text Box']").click();
        $("#userName").setValue("Alex Egorov");
        $("#userEmail").setValue("alex@egorov.com");
        $("#currentAddress").setValue("I am happy");
        $("#permanentAddress").setValue("I am happy auto qa");
        $("#submit").click();

        $("#output").shouldHave(text("Alex Egorov"), text("alex@egorov.com"),
                text("I am happy"), text("I am happy auto qa"));
    }

    @Test
    void practiceFormTest() {
        $x("//h5[text()='Forms']").click();
        $x("//span[text()='Practice Form']").click();
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Egorov");
        $("#userEmail").setValue("alex@egorov.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("7563241789");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("2009");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();//best
        $("#uploadPicture").uploadFromClasspath("img/testImage.png");
        $("#currentAddress").setValue("I am happy");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Gurgaon")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Alex Egorov"), text("alex@egorov.com"),
                text("Female"), text("7563241789"), text("Maths"), text("Sports"),
                text("testImage.png"), text("I am happy"), text("NCR Gurgaon"));
    }
}
