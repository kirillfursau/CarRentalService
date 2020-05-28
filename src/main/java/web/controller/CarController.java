package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.api.CarService;

@Controller
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping(path = "/car-info/{j}")
    public String getCarInfo(Model model, @PathVariable Long j) {
        model.addAttribute("car", carService.showCar(j));
        return "forward:/car-info";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcomePage(Model model,
                              @RequestParam(value = "page", required = false, defaultValue = "0") int page,
                              @RequestParam(value = "size", required = false, defaultValue = "3") int size) {
        model.addAttribute("cars", carService.showAllCars(page, size).getContent());
        model.addAttribute("totalPages", carService.showAllCars(page, size).getTotalPages());
        return "index";
    }
}
