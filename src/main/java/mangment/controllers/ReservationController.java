package mangment.controllers;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import mangment.entities.Reservation;
import mangment.repository.ReservationRepository;
import mangment.services.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

  private final ReservationService reservationService;
  private final ReservationRepository reservationRepository;
  

  public ReservationController(ReservationService reservationService,
                               ReservationRepository reservationRepository) {
    this.reservationService = reservationService;
    this.reservationRepository = reservationRepository;
  }

  @PostMapping
  public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation) {
    Reservation addedReservation = reservationService.addReservation(reservation);
    return new ResponseEntity<>(addedReservation, HttpStatus.CREATED);
  }

  @GetMapping("/hotel/{hotelId}")
  public List<Reservation> getAllReservationsByHotelId(@PathVariable Long hotelId) {
    return reservationService.findAllReservationsByHotelId(hotelId);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<String> deleteReservation(@PathVariable Long id) {
    reservationRepository.deleteById(id);
    return ResponseEntity.ok("reservation a été supprimée ");
  }

  @GetMapping("/{id}")
  public Reservation findReservationById(@PathVariable Long id) {
    return reservationRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("reservation not found with this id:- " + id));

  }

  @GetMapping("/reservation/{id}")
  public Optional<Reservation> findOptionalReservationById(@PathVariable Long id) {
    return reservationRepository.findById(id);
  }

  @PostMapping("/{idReservation}/{idChambre}")
  public Reservation addReservationChambre(@PathVariable Long idReservation,
                                           @PathVariable Long idChambre) {
    return reservationService.affecterReservationAChambre(idReservation, idChambre);
  }

  @GetMapping("/{hotelId}/reservations/accepted")
  public List<Reservation> getAllAcceptedReservationsByHotelId(@PathVariable Long hotelId) {
    return reservationService.getAllAcceptedReservationsByHotelId(hotelId);
  }

  @GetMapping("/hotel/{hotelId}/accepted/all")
  public List<Reservation> getAcceptedReservationsForToday(@PathVariable Long hotelId) {
    return reservationService.getAcceptedReservations(hotelId);
  }
  @GetMapping("/hotel/{hotelId}/allaccepted")
  public List<Reservation> getAcceptedReservations(@PathVariable Long hotelId) {
    return reservationService.getAcceptedReservations(hotelId);
  }


  @PutMapping("/accept/{reservationId}")
  public Reservation acceptReservation(@PathVariable Long reservationId) {
    return reservationService.acceptReservation(reservationId);
  }

  @PutMapping("/cancel/{reservationId}")
  public Reservation cancelReservation(@PathVariable Long reservationId) {
    return reservationService.cancelReservation(reservationId);
  }
  @GetMapping("/hotels/{hotelId}/reservations")
  public List<Reservation> getAcceptedReservationsForHotelAndDate(@PathVariable Long hotelId) {
      String status = "accepter";
      LocalDate dateArrivee = LocalDate.now();
      return reservationService.findAllAcceptedReservationsForHotelAndDate(hotelId, status, dateArrivee );
  }

  @GetMapping("/mail")
  public void mail() {
   // emailService.sendReservationMail(findReservationById());
  }

}
