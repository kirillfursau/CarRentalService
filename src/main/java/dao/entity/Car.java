package dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "car")
public class Car extends BaseEntity {

    @Column(name = "registered_car_number")
    private String registeredCarNumber;

    @Column(name = "body_number")
    private String bodyNumber;

    @Column(name = "engine_type")
    private String engineType;

    @Column(name = "year_of_issue")
    private LocalDate yearOfIssue;

    @Column
    private String brand;

    @Column
    private String model;

    @Column
    private int mileage;

    @Column(name = "price_auto")
    private int priceAuto;

    @Column(name = "rental_day_price")
    private int rentalDayPrice;

    @ManyToOne
    @JoinColumn(name = "car_class_id")
    private CarClass carClass;

    @OneToMany(mappedBy = "car")
    private List<RentalInformation> rentalInformation;
}
