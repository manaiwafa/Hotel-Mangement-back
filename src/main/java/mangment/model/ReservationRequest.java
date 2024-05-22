package mangment.model;

import java.util.List;

import mangment.entities.Client;
import mangment.entities.Reservation;

public class ReservationRequest {
private Reservation reservation;
private List<Client> clients;
;
public Reservation getReservation() {
	return reservation;
}
public void setReservation(Reservation reservation) {
	this.reservation = reservation;
}
public List<Client> getClients() {
	return clients;
}
public void setClients(List<Client> clients) {
	this.clients = clients;
}

}
