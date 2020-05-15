package service.impl;

import dao.entity.Car;
import dao.repository.CarRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import service.api.CarAddService;


@RequiredArgsConstructor
@Service
public class CarAddServiceImpl implements CarAddService {

    private CarRepository carRepository;

    public CarAddServiceImpl(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    @Override
    public void add(String registeredCarNumber, String engineType, int yearOfIssue,
                   String brand, String model, int rentalDayPrice, Long carClass) {
        carRepository.saveCar(registeredCarNumber, engineType, yearOfIssue,
                brand, model, rentalDayPrice, carClass);
    }
}
