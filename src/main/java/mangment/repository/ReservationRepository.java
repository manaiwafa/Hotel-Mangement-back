package mangment.repository;

import mangment.entities.Chambre;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mangment.entities.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	List<Reservation> findAllByHotelId(Long id);

	List<Reservation> findAllByHotelIdAndStatus(Long id, String status);

	List<Reservation> findAllByHotelIdAndStatusAndChambreIsNull(Long hotelId, String status);

	@Query("""
			SELECT r.chambre FROM Reservation r where r.hotel.id = :hotelId
			and r.status= :status
			and r.dateArrivee <= :today
			and r.dateDepart >= :today
			and r.chambre is not null
			""")
	List<Chambre> findAllByRoomForCleaning(Long hotelId, String status, LocalDate today);
    List<Reservation> findAllByStatusAndHotelIdAndDateArrivee(String status, Long hotelId, LocalDate dateArrivee);

	List<Reservation> findAllByHotelIdAndStatusAndChambreId(Long hotelId, String accepter, Long chambreId);

}
