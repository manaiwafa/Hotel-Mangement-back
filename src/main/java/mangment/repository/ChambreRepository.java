package mangment.repository;


import jakarta.persistence.Tuple;
import java.time.LocalDate;
import java.util.List;

import mangment.model.RoomPriceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mangment.entities.Chambre;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {

  List<Chambre> findByHotelId(Long id);

  Chambre findByIdAndHotelId(Long id, Long idHotel);

  @Query(value = """
      SELECT c FROM Chambre c WHERE c.hotel.id = :hotelId
      AND c.id NOT IN (SELECT rc.chambre.id FROM Reservation rc
      WHERE rc.chambre is Not null
      And rc.hotel.id = :hotelId
      And (:dateArrivee BETWEEN rc.dateArrivee AND rc.dateDepart
      or :dateDepart BETWEEN rc.dateArrivee AND rc.dateDepart))
       """)
  List<Chambre> findAvailableChambres(Long hotelId, LocalDate dateArrivee, LocalDate dateDepart);

  List<Chambre> findByHotelIdAndDate(Long idHotel, LocalDate date);

  @Query(value = """
      select max(vue) as vue, max(`type`) as type, max(prix) as prix 
      from chambre c where c.hotel_id = :hotelId and type= :type
      group by `type`, vue
       """, nativeQuery = true)
  List<RoomPriceDto> findRoomToReservation(Long hotelId, String type);


}


