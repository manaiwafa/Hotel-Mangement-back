package mangment.services.impl;

import java.time.LocalDate;
import java.util.List;
import mangment.entities.Chambre;
import mangment.entities.Reservation;
import mangment.repository.ChambreRepository;
import mangment.repository.ReservationRepository;
import mangment.services.EmailService;
import mangment.services.ReservationService;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

  private ReservationRepository reservationRepository;
  private ChambreRepository chambreRepository;
  private static final String ACCEPTER = "accepter";
  private static final String ANNULER = "annuler";

  public ReservationServiceImpl(ReservationRepository reservationRepository,
                                ChambreRepository chambreRepository) {
    this.reservationRepository = reservationRepository;
    this.chambreRepository = chambreRepository;
  }


  @Override
  public Reservation addReservation(Reservation reservation) {
    Reservation newReservation= reservationRepository.save(reservation);
    return newReservation;
  }


  @Override
  public List<Reservation> findAllReservationsByHotelId(Long id) {
    return reservationRepository.findAllByHotelId(id);
  }


  @Override
  public Reservation affecterReservationAChambre(Long idReservation, Long idChambre) {
    Reservation reservation = findReservationById(idReservation);
    Chambre chambre = chambreRepository.findById(idChambre)
        .orElseThrow(() -> new RuntimeException("chambre not found with this id:- " + idChambre));
    reservation.setChambre(chambre);
    return reservationRepository.save(reservation);

  }

  private Reservation findReservationById(Long reservationId) {
    return reservationRepository.findById(reservationId)
        .orElseThrow(
            () -> new RuntimeException("reservation not found with this id:- " + reservationId));
  }


  @Override
  public List<Reservation> getAllAcceptedReservationsByHotelId(Long hotelId) {
    return reservationRepository.findAllByHotelIdAndStatus(hotelId, ACCEPTER);

  }
  @Override
  public List<Reservation> getAllAcceptedReservationsByHotelIdAndIdChambre(Long hotelId,String status,Long idChambre) {
    return reservationRepository.findAllByHotelIdAndStatusAndChambreId(hotelId, ACCEPTER,null);

  }

  @Override
  public List<Reservation> getAcceptedReservations(Long hotelId) {
    return reservationRepository.findAllByHotelIdAndStatusAndChambreIsNull(hotelId, ACCEPTER);
  }

  @Override
  public Reservation cancelReservation(Long reservationId) {
    Reservation reservation = findReservationById(reservationId);
    reservation.setStatus(ANNULER);
    return reservationRepository.save(reservation);
  }

  @Override
  public Reservation acceptReservation(Long reservationId) {
    Reservation reservation = findReservationById(reservationId);
    reservation.setStatus(ACCEPTER);
    return reservationRepository.save(reservation);
  }

@Override
  public List<Reservation> findAllAcceptedReservationsForHotelAndDate(Long hotelId, String status, LocalDate dateArrivee) {
      List<Reservation> reservations = reservationRepository.findAllByStatusAndHotelIdAndDateArrivee(status, hotelId, dateArrivee);
   return reservations;
  }






}



		
	


	


	

	


