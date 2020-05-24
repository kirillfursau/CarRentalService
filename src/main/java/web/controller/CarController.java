package web.controller;

import dao.repository.model.CarDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import service.api.CarService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping(path = "/car-info-{j}")
    public String getCarInfo(Model model, @PathVariable Long j) {
        model.addAttribute("car", carService.showCar(j));
        return "car-info";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("cars", carService.showAllCars());
        return "index";
    }

    @RequestMapping(value = "/admin-panel", method = RequestMethod.GET)
    public String adminPanel(Model model) {
        model.addAttribute("cars", carService.showAllCars());
        return "admin-panel";
    }

    @GetMapping(path = "/admin-car-info-{j}")
    public String getAdminCarInfo(Model model, @PathVariable Long j) {
        model.addAttribute("car", carService.showCar(j));
        return "admin-car-info";
    }

    @PostMapping("/create-car")
    public String createCar(@Valid @ModelAttribute CarDto carDto, BindingResult bindingResult, Model model) {
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        if (fieldErrors.isEmpty()) {
            carService.create(carDto);
            return "admin-panel";
        } else {
            model.addAttribute("binding", fieldErrors);
            return "car-add";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable Long id) {
        carService.deleteById(id);
        return "admin-panel";
    }
}
