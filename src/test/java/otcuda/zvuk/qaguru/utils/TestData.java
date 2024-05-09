package otcuda.zvuk.qaguru.utils;

import com.github.javafaker.Faker;
import otcuda.zvuk.qaguru.models.UserModel;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TestData {
    private static Faker faker = new Faker();
    private static Random random = new Random();

    private static List<String> genders = Arrays.asList("Male", "Female", "Other");
    private static List<String> subjects = Arrays.asList("Maths", "Chemistry", "Computer", "Physics");
    private static List<String> hobbies = Arrays.asList("Sports", "Reading", "Music");
    private static String picturePath = "img/testImage.png";
    ;
    private static String state = "NCR";
    private static String city = "Gurgaon";

    public static String getRandomFirstUserName() {
        return faker.name().firstName();
    }

    public static String getRandomLastUserName() {
        return faker.name().lastName();
    }

    public static String getRandomPhone() {
        return faker.business().creditCardNumber().replaceAll("-", "").substring(6);
    }

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomGender() {
        return genders.get(random.nextInt(genders.size()));
    }

    public static String getRandomHobby() {
        return hobbies.get(random.nextInt(hobbies.size()));
    }

    public static String getRandomSubject() {
        return subjects.get(random.nextInt(subjects.size()));
    }

    public static String getRandomAddress() {
        return faker.address().fullAddress();
    }

    public static String getRandomBirthDay() {
        return String.valueOf(random.nextInt(30));
    }

    public static String getRandomBirthMonth() {
        int pick = random.nextInt(Months.values().length);
        String month = Months.values()[pick].toString();
        return month.substring(0, 1).toUpperCase() + month.substring(1).toLowerCase();
    }

    public static String getRandomBirthYear() {
        int year = random.nextInt(1950, 2009);
        return String.valueOf(year);
    }

    public static UserModel getRandomUser() {
        return UserModel.builder()
                .userFirstName(getRandomFirstUserName())
                .userLastName(getRandomLastUserName())
                .userEmail(getRandomEmail())
                .userGender(getRandomGender())
                .userPhone(getRandomPhone())
                .userBirthDay(getRandomBirthDay())
                .userBirthMouth(getRandomBirthMonth())
                .userBirthYear(getRandomBirthYear())
                .userSubject(getRandomSubject())
                .picturePath(picturePath)
                .userHobby(getRandomHobby())
                .userCurrentAddress(getRandomAddress())
                .state(state)
                .city(city)
                .build();
    }
}
