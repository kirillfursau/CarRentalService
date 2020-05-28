package service.api;

import dao.entity.UserDetails;
import dao.repository.model.UserDetailsDto;

public interface UserDetailsService {
    UserDetails createUserDetails(UserDetailsDto userDetailsDto);

    UserDetails findUserDetailsByPhoneNumber(String phoneNumber);
}
