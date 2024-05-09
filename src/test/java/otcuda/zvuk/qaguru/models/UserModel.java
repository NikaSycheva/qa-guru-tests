package otcuda.zvuk.qaguru.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserModel {
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private String userGender;
    private String userPhone;
    private String userBirthDay;
    private String userBirthMouth;
    private String userBirthYear;
    private String userSubject;
    private String userHobby;
    private String picturePath;
    private String userCurrentAddress;
    private String state;
    private String city;
}