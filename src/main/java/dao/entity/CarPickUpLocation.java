package dao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "car_pick-up_location")
public class CarPickUpLocation extends BaseEntity {

    @Column(name = "car_id")
    private Long carId;
    @Column(name = "pick-up_location_id")
    private Long pickUpLocationId;
}
