package mangment.entities;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Services {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String Service;
	    private List<String> noms;
	   		public List<String> getNoms() {
			return noms;
		}
		public void setNoms(List<String> noms) {
			this.noms = noms;
		}
		private String description;
	    private boolean gratuit;
	    @ManyToOne
	    @JoinColumn(name = "hotel_id")
	    private Hotel hotel;
		public Hotel getHotel() {
			return hotel;
		}
		public void setHotel(Hotel hotel) {
			this.hotel = hotel;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getService() {
			return Service;
		}
		public void setService(String service) {
			Service = service;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public boolean isGratuit() {
			return gratuit;
		}
		public void setGratuit(boolean gratuit) {
			this.gratuit = gratuit;
		}

}
