package otcuda.zvuk.qaguru;

import org.junit.jupiter.api.BeforeAll;
import otcuda.zvuk.qaguru.pages.RegistrationPage;

public class BaseTest {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll(){
        //Configuration.baseUrl = "";//на примере сайта Олега не работает
        //Configuration.browserSize = "1920x1080";
    }

}
