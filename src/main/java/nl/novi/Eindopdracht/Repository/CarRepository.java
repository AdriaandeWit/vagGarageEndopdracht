package nl.novi.Eindopdracht.Repository;

import nl.novi.Eindopdracht.Models.Data.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car,Long> {

    Optional<Car> findbyNameStarteingWith (String prefix );
}
