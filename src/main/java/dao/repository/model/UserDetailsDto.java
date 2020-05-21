package dao.repository.model;

import dao.entity.Gender;
import lombok.Data;

@Data
public class UserDetailsDto {
    private String firstName;
    private String secondName;
    private String dateOfBirth;
    private Gender gender;
    private Long phoneNumber;
    private String country;
    private String city;
    private String street;
    private String building;
    private String apartment;
    private String passportId;
    private String passportDateOfIssue;
    private String passportExpiryDate;
    private String placeOfBirthDay;
    private String countryOfResidence;
}
