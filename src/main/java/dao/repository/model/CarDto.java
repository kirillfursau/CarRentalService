package dao.repository.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CarDto {
    @NotEmpty
    private String registeredCarNumber;
    @NotEmpty
    private String engineType;
    private int yearOfIssue;
    @NotEmpty
    private String brand;
    @NotEmpty
    private String model;
    private int rentalDayPrice;
    private Long carClass;
}
