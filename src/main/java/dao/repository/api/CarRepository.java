package dao.repository.api;

import dao.entity.Car;
import dao.entity.CarClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {
}
