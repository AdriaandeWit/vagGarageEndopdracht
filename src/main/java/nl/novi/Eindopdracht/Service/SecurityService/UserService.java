package nl.novi.Eindopdracht.Service.SecurityService;

import nl.novi.Eindopdracht.Exceptions.RecordNotFoundException;
import nl.novi.Eindopdracht.Models.Security.Authority;
import nl.novi.Eindopdracht.Models.Security.User;
import nl.novi.Eindopdracht.Repository.UserRepository;
import nl.novi.Eindopdracht.Utils.RandomStringGenerator;
import nl.novi.Eindopdracht.dto.input.UserDto;
import nl.novi.Eindopdracht.dto.output.UserOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepos;

    private final PasswordEncoder encoder;

    public UserService(UserRepository userRepos, PasswordEncoder encoder) {
        this.userRepos = userRepos;
        this.encoder = encoder;

    }


    public List<UserOutputDto> getUsers() {
        List<UserOutputDto> collection = new ArrayList<>();
        List<User> list = userRepos.findAll();
        for (User user : list) {
            collection.add(fromUser(user));
        }
        return collection;
    }
    public UserOutputDto getUser(String username) {
        UserOutputDto userOutputDto ;
        Optional<User> user = userRepos.findById(username);
        if (user.isEmpty()){
            throw new UsernameNotFoundException(username);

        }else {
            userOutputDto = fromUser(user.get());
        }
        return userOutputDto;
    }

    public boolean userExists(String username) {
        return userRepos.existsById(username);
    }




    public String createUser( UserDto userDto) {

        String randomString = RandomStringGenerator.generateAlphaNumeric(20);
        userDto.setApikey(randomString);
        userDto.setPassword(encoder.encode(userDto.password));
        User newUser = userRepos.save(toUser(userDto));

        return newUser.getUserName();

    }
    public void deleteUser(String username) {
        userRepos.deleteById(username);
    }

    public void updateUser(String username, UserDto newUser) {
        if (!userRepos.existsById(username)) throw new RecordNotFoundException();
        User user = userRepos.findById(username).get();
        user.setPassword(newUser.getPassword());
        userRepos.save(user);
    }

    public Set<Authority> getAuthorities(String username) {
        if (!userRepos.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepos.findById(username).get();
        UserOutputDto userOutputDTO = fromUser(user);
        return userOutputDTO.getAuthorities();
    }

    public void addAuthority(String username, String authority) {

        if (!userRepos.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepos.findById(username).get();
        user.addAuthority(new Authority(username, authority));
        userRepos.save(user);
    }

    public void removeAuthority(String username, String authority) {
        if (!userRepos.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepos.findById(username).get();
        Authority authorityToRemove = user.getAuthorities().stream().filter((a) -> a.getAuthority().equalsIgnoreCase(authority)).findAny().get();
        user.removeAuthority(authorityToRemove);
        userRepos.save(user);
    }



    public static  UserOutputDto fromUser(User user){
        var dto = new UserOutputDto();

        dto.username = user.getUserName();
        dto.password = user.getPassword();
        dto.enabled = user.isEnabled();
        dto.apikey = user.getApiKey();
        dto.email = user.getEmail();
        dto.authorities = user.getAuthorities();

        return dto;
    }

    public User toUser( UserDto userDto) {
        var user = new User();

        user.setUserName(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEnabled(userDto.getEnabled());
        user.setEmail(userDto.getApikey());
        user.setEmail(userDto.getEmail());
        return user;
    }



}
