package service.api;

import dao.entity.Car;

import java.time.LocalDate;

public interface CarAddService {
    void add(String registeredCarNumber, String engineType, int yearOfIssue, String brand,
            String model, int rentalDayPrice, Long carClass);
}
