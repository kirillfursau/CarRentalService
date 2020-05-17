package web.controller;

import dao.repository.model.CarDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
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

//    @GetMapping(path = "/car_add/?registeredCarNumber={registeredCarNumber}&engineType={engineType}&yearOfIssue={yearOfIssue}&brand={brand}&carModel={carModel}&rentalDayPrice={rentalDayPrice}&carClass={carClass}")
//    public String getNextStep(Model model, @PathVariable String registeredCarNumber, @PathVariable String engineType,
//                              @PathVariable int yearOfIssue, @PathVariable String brand,
//                              @PathVariable String carModel, @PathVariable int rentalDayPrice,
//                              @PathVariable Long carClass) {
//        carAddService.add(registeredCarNumber, engineType, yearOfIssue,
//                brand, carModel, rentalDayPrice, carClass);
//        return "index";
//    }
}
