package dao.repository.model;

import dao.entity.Gender;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserDetailsDto {
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String secondName;
    @NotEmpty
    private String dateOfBirth;
    @NotNull
    private Gender gender;
    @NotNull
    private String phoneNumber;
    @NotEmpty
    private String country;
    @NotEmpty
    private String city;
    @NotEmpty
    private String street;
    @NotEmpty
    private String building;
    @NotEmpty
    private String apartment;
    @NotEmpty
    private String passportId;
    @NotEmpty
    private String passportDateOfIssue;
    @NotEmpty
    private String passportExpiryDate;
    @NotEmpty
    private String placeOfBirthDay;
    @NotEmpty
    private String countryOfResidence;
}
