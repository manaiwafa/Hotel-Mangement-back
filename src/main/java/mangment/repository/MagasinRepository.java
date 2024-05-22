package mangment.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mangment.entities.Magasin;


@Repository
public interface MagasinRepository extends JpaRepository<Magasin, Long> {
	Magasin findByHotelId(Long hotelId);
}
