package nl.novi.Eindopdracht.dto.output;

import lombok.Getter;
import lombok.Setter;
import nl.novi.Eindopdracht.Models.Security.Authority;

import java.util.Set;

@Getter
@Setter
public class UserOutputDto {

    public String username;
    public String password;
    public Boolean enabled;
    public String apikey;
    public String email;
    public Set<Authority> authorities;
}
