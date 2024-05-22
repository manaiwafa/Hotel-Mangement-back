package mangment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mangment.entities.Client;
import mangment.entities.Reservation;
import mangment.model.ReservationRequest;
import mangment.repository.ClientRepository;
import mangment.repository.ReservationRepository;


@RestController
@RequestMapping("/reser")
public class ReservationRequestController {

@Autowired 
private ClientRepository clientRepository ;
@Autowired
private ReservationRepository reservationRepository;

  @PostMapping("/")
  public ReservationRequest submitInscriptionForm(@RequestBody ReservationRequest reservationDTO) {
    Reservation reservation = reservationRepository.save(reservationDTO.getReservation());
        List<Client> clients = reservationDTO.getClients();
        for (Client client : clients) {
        client.setReservation(reservation);
    }
        clientRepository.saveAll(clients);
    return reservationDTO;
  }
} 