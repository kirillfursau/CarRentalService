package dao.repository.model;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CarDto {
    @NotEmpty(message = "Укажите номер автомобиля")
    private String registeredCarNumber;
    @NotEmpty(message = "Укажите тип двигателя")
    private String engineType;
    @Min(1980)
    @Max(2020)
    @NotNull(message = "Укажите год выпуска")
    private Integer yearOfIssue;
    @NotEmpty(message = "Укажите бренд")
    private String brand;
    @NotEmpty(message = "Укажите модель")
    private String model;
    @NotNull(message = "Укажите цену за день")
    private Integer rentalDayPrice;
    @NotNull(message = "Выберете класс автомобиля")
    private Long carClass;
}
