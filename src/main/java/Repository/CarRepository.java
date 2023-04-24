package Repository;

import Models.Data.Car;
import Models.Data.CustomerAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car,Long> {

    Optional<Car> findbyNameStarteingWith (String prefix );
}
