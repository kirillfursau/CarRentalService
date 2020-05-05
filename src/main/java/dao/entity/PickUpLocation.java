package dao.entity;

import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "pick-up_location")
public class PickUpLocation extends BaseEntity {
    @Embedded
    private Address address;
}
