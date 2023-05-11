package nl.novi.Eindopdracht.Repository;

import nl.novi.Eindopdracht.Models.Data.Car;
import nl.novi.Eindopdracht.Models.Data.CustomerAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerAccountRepository extends JpaRepository<CustomerAccount,String> {


     Optional<CustomerAccount> findAllByCustomerName(String customerName);

     Optional<CustomerAccount>findAccountByCustomerName(String customerName);
     Optional<List<CustomerAccount>> findByLastName(String lastName);

     Optional<CustomerAccount> findById(Long id);



}
