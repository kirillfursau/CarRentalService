package web.controller;

import dao.repository.model.CarDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.api.CarService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @PostMapping("/car_add")
    public String createCar(@ModelAttribute CarDto dto) {
        carService.add(dto.getRegisteredCarNumber(), dto.getEngineType(),
                dto.getYearOfIssue(), dto.getBrand(), dto.getModel(), dto.getRentalDayPrice(), dto.getCarClass());
        return "index";
    }
}
