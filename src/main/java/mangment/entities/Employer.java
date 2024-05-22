package mangment.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Employer extends Utilisateur{
	  
		private float salaire;
	    private String type;
	    @ManyToMany
	    @JoinTable(
	    		  name = "employer_chambre", 
	    		  joinColumns = @JoinColumn(name = "employer_id"), 
	    		  inverseJoinColumns = @JoinColumn(name = "chambre_id"))
	    private List<Chambre> chambres;
	    
		public float getSalaire() {
			return salaire;
		}
		public void setSalaire(float salaire) {
			this.salaire = salaire;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public List<Chambre> getChambres() {
			return chambres;
		}
		public void setChambres(List<Chambre> chambres) {
			this.chambres = chambres;
		}
	   }

