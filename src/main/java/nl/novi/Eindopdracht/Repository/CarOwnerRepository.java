package nl.novi.Eindopdracht.Repository;

import nl.novi.Eindopdracht.Models.Data.CarOwner;
import nl.novi.Eindopdracht.Models.Data.CarOwnerKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface CarOwnerRepository extends JpaRepository<CarOwner, CarOwnerKey> {

    List<CarOwner> findAllByCustomerAccount_Id(Long owner_Id);

    Collection<CarOwner> findAllByCar_Id(Long car_ID);


}
