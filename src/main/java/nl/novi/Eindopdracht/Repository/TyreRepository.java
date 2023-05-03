package nl.novi.Eindopdracht.Repository;

import nl.novi.Eindopdracht.Models.Data.CarParts.Brakes;
import nl.novi.Eindopdracht.Models.Data.CarParts.Tyres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TyreRepository extends JpaRepository<Tyres, Long> {


}
