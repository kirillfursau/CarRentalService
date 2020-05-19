package web.controller;

import dao.repository.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.api.RegistrationService;

@Controller
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/create-user")
    public String createCar(@ModelAttribute UserDto userDto) {
        registrationService.registration(userDto);
        return "redirect:http://localhost:8090/CarRentalService_war_exploded/";
    }
}
