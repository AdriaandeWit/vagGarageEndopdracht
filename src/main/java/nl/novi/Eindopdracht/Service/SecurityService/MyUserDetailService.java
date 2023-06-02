package nl.novi.Eindopdracht.Service.SecurityService;

import nl.novi.Eindopdracht.Models.Security.User;
import nl.novi.Eindopdracht.Repository.UserRepository;
import nl.novi.Eindopdracht.Security.MyUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service

public class MyUserDetailService implements UserDetailsService {

    private final UserRepository userRepos;

    public MyUserDetailService(UserRepository userRepos) {
        this.userRepos = userRepos;
    }

    @Override
    public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {
        Optional<User> ou = userRepos.findById(username);
        if(ou.isPresent()){
            User user = ou.get();
            return new MyUserDetails(user);
        }
        else {
            throw new UsernameNotFoundException(username);
        }
    }

}
