package mangment.services;

import java.time.LocalDate;
import java.util.List;
import mangment.entities.Reservation;


public interface ReservationService {
	Reservation addReservation(Reservation reservation) ;
	List<Reservation> findAllReservationsByHotelId(Long id);
	Reservation affecterReservationAChambre(Long idReservation, Long idChambre);
	List<Reservation> getAllAcceptedReservationsByHotelId(Long hotelId);
	List<Reservation> getAcceptedReservations(Long hotelId);
	Reservation cancelReservation(Long reservationId);
	Reservation acceptReservation(Long reservationId);
	 List<Reservation> findAllAcceptedReservationsForHotelAndDate(Long hotelId, String status, LocalDate dateArrivee);
	List<Reservation> getAllAcceptedReservationsByHotelIdAndIdChambre(Long hotelId, String status, Long idChambre);


	
}
