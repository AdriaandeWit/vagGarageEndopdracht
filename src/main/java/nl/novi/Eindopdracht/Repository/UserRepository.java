
package nl.novi.Eindopdracht.Repository;

import nl.novi.Eindopdracht.Models.Security.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {


}

