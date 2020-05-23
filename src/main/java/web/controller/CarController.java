package web.controller;

import dao.repository.model.CarDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.api.CarService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/cars")
public class CarController {

    private final CarService carService;

    @PostMapping("/create-car")
    public String createCar(@ModelAttribute CarDto carDto) {
        carService.create(carDto);
        return "redirect:http://localhost:8090/CarRentalService_war_exploded/";
    }

    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable Long id) {
        carService.deleteById(id);
        return "index";
    }
}
