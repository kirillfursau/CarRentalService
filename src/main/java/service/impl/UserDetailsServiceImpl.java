package service.impl;

import dao.entity.Address;
import dao.entity.UserDetails;
import dao.repository.api.UserDetailsRepository;
import dao.repository.api.UserRepository;
import dao.repository.model.UserDetailsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.api.UserDetailsService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserDetailsRepository userDetailsRepository;
    private final UserRepository userRepository;

    @Override
    public UserDetails findUserDetailsByPhoneNumber(Long phoneNumber) {
        return userRepository.findUserByPhoneNumber(phoneNumber).get().getUserDetails();
    }

    @Override
    public UserDetails createUserDetails(UserDetailsDto userDetailsDto) {
        UserDetails userDetails = convertUserDetails(userDetailsDto);
        userDetailsRepository.save(userDetails);
        return null;
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
