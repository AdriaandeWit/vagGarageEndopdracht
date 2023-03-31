package Repository;

import Models.CarParts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarPartsRepository extends JpaRepository<CarParts, Long> {


}
