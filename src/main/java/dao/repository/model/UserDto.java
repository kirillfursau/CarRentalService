package dao.repository.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserDto {
    @NotEmpty
    private String phoneNumber;
    @NotEmpty
    private String password;
}
