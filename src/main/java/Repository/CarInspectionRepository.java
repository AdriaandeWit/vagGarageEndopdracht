package Repository;

import Models.Data.CarInspection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarInspectionRepository extends JpaRepository<CarInspection,Long> {


}
