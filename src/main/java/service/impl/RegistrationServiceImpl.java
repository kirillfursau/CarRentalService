package service.impl;

import dao.entity.Address;
import dao.entity.User;
import dao.entity.UserDetails;
import dao.repository.api.RoleRepository;
import dao.repository.api.UserDetailsRepository;
import dao.repository.api.UserRepository;
import dao.repository.model.UserDetailsDto;
import dao.repository.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.api.RegistrationService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserDetailsRepository userDetailsRepository;

    @Override
    public User registration(UserDto userDto) {
        User user = convertUser(userDto);
        user.setRole(roleRepository.findById(2l).get());
        return userRepository.save(user);
    }

    @Override
    public UserDetails createUserDetails(UserDetailsDto userDetailsDto) {
        UserDetails userDetails = convertUserDetails(userDetailsDto);
        userDetailsRepository.save(userDetails);
        return null;
    }

    private User convertUser(UserDto userDto) {
        User user = new User();
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setPassword(userDto.getPassword());
        return user;
    }

    private UserDetails convertUserDetails(UserDetailsDto userDetailsDto) {
        UserDetails userDetails = new UserDetails();
        userDetails.setFirstName(userDetailsDto.getFirstName());
        userDetails.setSecondName(userDetailsDto.getSecondName());
        userDetails.setDateOfBirth(convertLocalDate(userDetailsDto.getDateOfBirth()));
        userDetails.setGender(userDetailsDto.getGender());
        userDetails.setUser(userRepository.findUserByPhoneNumber(userDetailsDto.getPhoneNumber()).get());
        Address address = new Address();
        address.setCountry(userDetailsDto.getCountry());
        address.setCity(userDetailsDto.getCity());
        address.setStreet(userDetailsDto.getStreet());
        address.setBuilding(userDetailsDto.getBuilding());
        userDetails.setAddress(address);
        userDetails.setApartment(userDetailsDto.getApartment());
        userDetails.setPassportId(userDetailsDto.getPassportId());
        userDetails.setPassportDateOfIssue(convertLocalDate(userDetailsDto.getPassportDateOfIssue()));
        userDetails.setPassportExpiryDate(convertLocalDate(userDetailsDto.getPassportExpiryDate()));
        userDetails.setPlaceOfBirthDay(userDetailsDto.getPlaceOfBirthDay());
        userDetails.setCountryOfResidence(userDetailsDto.getCountryOfResidence());
        return userDetails;
    }

    private LocalDate convertLocalDate(String localDate) {
        List<Integer> date = new ArrayList<>();
        for (String retval : localDate.split("-")) {
            date.add(Integer.parseInt(retval));
        }
        return LocalDate.of(date.get(0), date.get(1), date.get(2));
    }
}
