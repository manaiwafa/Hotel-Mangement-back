package mangment.repository;

import java.util.List;
import mangment.entities.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long> {
  List<Employer> findEmployersByHotelId(Long hotelId);
  List<Employer> findEmployersByRoleAndHotelId(String role, Long hotelId);

}


