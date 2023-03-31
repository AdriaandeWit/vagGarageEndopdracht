package Repository;

import Models.CarInspection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarInspectionRepository extends JpaRepository<CarInspection,Long> {


}
