package nl.novi.Eindopdracht.dto.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    public String username;
    public String password;
    public Boolean enabled;
    public String apikey;
    public String email;
}
