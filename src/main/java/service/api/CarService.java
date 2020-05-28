package service.api;

import dao.entity.Car;
import dao.repository.model.CarDto;
import org.springframework.data.domain.Page;

public interface CarService {
    Car create(CarDto carDto);

    void deleteById(Long id);

    Car showCar(Long id);

    Page<Car> showAllCars(int page, int size);
}
