package Repository;

import Models.Data.CarOwner;
import Models.Data.CarOwnerKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface CarOwnerRepository extends JpaRepository<CarOwner, CarOwnerKey> {

    List<CarOwner> findAllByCarsId(Long owner_Id);

    Collection<CarOwner>findOwnerByCar(Long car_ID);


}
