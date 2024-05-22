package mangment.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mangment.entities.Services;

@Repository
public interface ServiceRepository  extends  JpaRepository<Services, Long>{
	List<Services> findByHotelId(Long id);
}
