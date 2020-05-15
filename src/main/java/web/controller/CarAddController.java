package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import service.api.CarAddService;

import java.time.LocalDate;

@Controller
public class CarAddController {
    private final CarAddService carAddService;

    @Autowired
    public CarAddController(CarAddService carAddService) {
        this.carAddService = carAddService;

    }

    @GetMapping(path = "/car_add/{registeredCarNumber}/{engineType}/{yearOfIssue}/{brand}/{carModel}/{rentalDayPrice}/{carClass}")
    public String getNextStep(Model model, @PathVariable String registeredCarNumber, @PathVariable String engineType,
                              @PathVariable int yearOfIssue, @PathVariable String brand,
                              @PathVariable String carModel, @PathVariable int rentalDayPrice,
                              @PathVariable Long carClass) {
        carAddService.add(registeredCarNumber, engineType, yearOfIssue,
                brand, carModel, rentalDayPrice, carClass);
        return "complate";
    }
}
