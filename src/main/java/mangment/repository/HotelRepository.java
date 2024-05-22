package mangment.repository;

import java.time.LocalDate;
import java.util.List;

import mangment.entities.Chambre;
import mangment.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
  List<Hotel> findByActiveTrue();
  @Query(value = """
               select h from Hotel h where
               h.region.id = :regionId and
      (SELECT count(c) FROM Chambre c WHERE c.hotel.id = h.id
      AND c.id NOT IN (SELECT rc.chambre.id FROM Reservation rc
      WHERE rc.chambre is Not null
      And rc.hotel.id = h.id
      And (:dateArrivee BETWEEN rc.dateArrivee AND rc.dateDepart
      or :dateDepart BETWEEN rc.dateArrivee AND rc.dateDepart))) > 0
       """)
  List<Hotel> findAvailableHotel(Long regionId, LocalDate dateArrivee, LocalDate dateDepart);

  List<Hotel> findByActiveFalse();

  int countByActive(boolean isActive);

  @Query("SELECT DISTINCT h.emplacementVille FROM Hotel h")
  List<String> findAllVilles();

  List<Hotel> findHotelByEmplacementVilleAndActiveIsTrue(String emplacementVille);
  Hotel findHotelById(Long hotelId);




}
