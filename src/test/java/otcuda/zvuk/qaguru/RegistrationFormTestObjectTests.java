package otcuda.zvuk.qaguru;

import org.junit.jupiter.api.Test;

public class RegistrationFormTestObjectTests extends BaseTest {
    @Test
    void practiceFormTest() {
        String userFirstName = "Alex";
        String userLastName = "Egorov";
        String userEmail = "Egorov@mail.com";
        String gender = "Female";
        String phone = "7563241789";
        String birthDay = "30";
        String birthMouth = "September";
        String birthYear = "2009";
        String userFullBirthday = birthDay + " " + birthMouth + "," + birthYear;
        String subject = "Math";
        String hobby = "Sports";
        String picturePath = "img/testImage.png";
        String currentAddress = "I am happy";
        String state = "NCR";
        String city = "Gurgaon";

        registrationPage.openPage()
                .setFirstName(userFirstName)
                .setLastName(userLastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setPhone(phone)
                .setBirthDate(birthMouth, birthYear, birthDay)
                .setSubject(subject)
                .setHobby(hobby)
                .uploadPicture(picturePath)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .sendData()
                .verifyResultsModalAppears()
                .verifyResult("Student Name", userFirstName + " " + userLastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", phone)
                .verifyResult("Date of Birth", userFullBirthday)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobby)
                .verifyResult("Picture", picturePath.substring(4))
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", state + " " + city);
    }
}
