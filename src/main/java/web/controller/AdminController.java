package web.controller;

import dao.repository.model.CarDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import service.api.CarService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminController {
    private final CarService carService;

    @PostMapping("/create-car")
    public String createCar(@Valid @ModelAttribute CarDto carDto, BindingResult bindingResult, Model model) {
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        if (fieldErrors.isEmpty()) {
            carService.create(carDto);
            return "redirect:/admin-panel";
        } else {
            model.addAttribute("binding", fieldErrors);
            return "car-add";
        }
    }

    @GetMapping(value = "/admin-panel")
    public String adminPanel(Model model) {
        model.addAttribute("cars", carService.showAllCars());
        return "admin-panel";
    }

    @GetMapping(path = "/admin-car-info/{j}")
    public String getAdminCarInfo(Model model, @PathVariable Long j) {
        model.addAttribute("car", carService.showCar(j));
        return "forward:/admin-car-info";
    }

    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable Long id) {
        carService.deleteById(id);
        return "redirect:/admin-panel";
    }
}
