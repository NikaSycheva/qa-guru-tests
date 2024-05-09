package otcuda.zvuk.qaguru;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import otcuda.zvuk.qaguru.models.UserModel;

import static otcuda.zvuk.qaguru.utils.TestData.getRandomUser;


public class RegistrationWithFakerTests extends BaseTest {
    private static UserModel user = null;
    private static String userFullBirthday, userFullName;

    @BeforeAll
    static void createTestUser() {
        user = getRandomUser();
        userFullName = user.getUserFirstName() + " " + user.getUserLastName();
        userFullBirthday = user.getUserBirthDay() + " " + user.getUserBirthMouth() + "," + user.getUserBirthYear();
    }

    @Test
    void practiceFormTest() {
        registrationPage.openPage()
                .setFirstName(user.getUserFirstName())
                .setLastName(user.getUserLastName())
                .setEmail(user.getUserEmail())
                .setGender(user.getUserGender())
                .setPhone(user.getUserPhone())
                .setBirthDate(user.getUserBirthMouth(), user.getUserBirthYear(), user.getUserBirthDay())
                .setSubject(user.getUserSubject())
                .setHobby(user.getUserHobby())
                .uploadPicture(user.getPicturePath())
                .setCurrentAddress(user.getUserCurrentAddress())
                .setState(user.getState())
                .setCity(user.getCity())
                .sendData()
                .verifyResultsModalAppears()
                .verifyResult("Student Name", userFullName)
                .verifyResult("Student Email", user.getUserEmail())
                .verifyResult("Gender", user.getUserGender())
                .verifyResult("Mobile", user.getUserPhone())
                .verifyResult("Date of Birth", userFullBirthday)
                .verifyResult("Subjects", user.getUserSubject())
                .verifyResult("Hobbies", user.getUserHobby())
                .verifyResult("Picture", user.getPicturePath().substring(4))
                .verifyResult("Address", user.getUserCurrentAddress())
                .verifyResult("State and City", user.getState() + " " + user.getCity());
    }
}