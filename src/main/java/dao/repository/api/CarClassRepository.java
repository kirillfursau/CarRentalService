package dao.repository.api;

import dao.entity.CarClass;
import org.springframework.data.repository.CrudRepository;

public interface CarClassRepository extends CrudRepository<CarClass, Long> {
}
