package mangment.model;

import mangment.entities.Hotel;
import mangment.entities.Utilisateur;

public class InscriptionRequest {
	
	private Hotel hotel;
	private Utilisateur utilisateur;
	
	
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	

}
	

