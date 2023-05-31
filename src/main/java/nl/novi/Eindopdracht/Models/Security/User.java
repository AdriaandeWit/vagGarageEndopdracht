
package nl.novi.Eindopdracht.Models.Security;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
public class User {
@Id
    private String userName;

    private String password;

    private boolean enabled = true;

    private String apiKey;

    private String email;

    @OneToMany(
            targetEntity = Authority.class,
            mappedBy = "username",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Set<Authority> authorities = new HashSet<>();


    public void addAuthority(Authority authority){
        this.authorities.add(authority);
    }

    public void removeAuthority(Authority authority){
        this.authorities.remove(authority);
    }


