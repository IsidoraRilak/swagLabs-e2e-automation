package dto;

import lombok.Data;

@Data
public class UserDTO {
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private int userStatus;
}
