package otcuda.zvuk.qaguru.pages;

import com.codeborne.selenide.SelenideElement;
import otcuda.zvuk.qaguru.pages.components.CalendarComponent;
import otcuda.zvuk.qaguru.pages.components.RegistrationResultModal;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultModal registrationResultModal = new RegistrationResultModal();

    private SelenideElement
            firstNameField = $("#firstName"),
            lastNameField = $("#lastName"),
            emailField = $("#userEmail"),
            genderField = $("#genterWrapper"),
            phoneField = $("#userNumber"),
            dateBirthField = $("#dateOfBirthInput"),
            subjectField = $("#subjectsInput"),
            hobbyField = $("#hobbiesWrapper"),
            pictureUploadField = $("#uploadPicture"),
            currentAddressField = $("#currentAddress"),
            stateField = $("#state"),
            cityField = $("#city"),
            submitBtn = $("#submit");


    public RegistrationPage openPage() {
        open("http://85.192.34.140:8081");
        $x("//h5[text()='Forms']").click();
        $x("//span[text()='Practice Form']").click();
        return this;
    }

    public RegistrationPage setFirstName(String userFirstName) {
        firstNameField.setValue(userFirstName);
        return this;
    }

    public RegistrationPage setLastName(String userLastName) {
        lastNameField.setValue(userLastName);
        return this;
    }

    public RegistrationPage setEmail(String userEmail) {
        emailField.setValue(userEmail);
        return this;
    }

    public RegistrationPage setGender(String gender) {
        genderField.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage setPhone(String phone) {
        phoneField.setValue(phone);
        return this;
    }

    public RegistrationPage setBirthDate(String month, String year, String day) {
        dateBirthField.click();
        calendarComponent.setDate(month, year, day);
        return this;
    }

    public RegistrationPage setSubject(String subject) {
        subjectField.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage setHobby(String hobby) {
        hobbyField.$(byText(hobby)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String picturePath) {
        pictureUploadField.uploadFromClasspath(picturePath);
        return this;
    }

    public RegistrationPage setCurrentAddress(String currentAddress) {
        currentAddressField.setValue(currentAddress);
        return this;
    }

    public RegistrationPage setState(String state) {
        stateField.click();
        $("#stateCity-wrapper").$(byText(state)).click();
        return this;
    }

    public RegistrationPage setCity(String city) {
        cityField.click();
        $("#stateCity-wrapper").$(byText(city)).click();
        return this;
    }

    public RegistrationPage sendData() {
        submitBtn.click();
        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultModal.verifyModalAppears();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultModal.verifyResult(key, value);
        return this;
    }
}
