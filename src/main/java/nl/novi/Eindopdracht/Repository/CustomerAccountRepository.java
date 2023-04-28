package nl.novi.Eindopdracht.Repository;

import nl.novi.Eindopdracht.Models.Data.CustomerAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerAccountRepository extends JpaRepository<CustomerAccount,Long> {

Optional<CustomerAccount> findbyNameStarteingWith (String prefix );

}
