package mangment.entities;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Chambre {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private Integer numero;
 private int etage;
 private String type;
 private String vue;
 private boolean reserver;
 private boolean nettoyer;

 private int  nbrGelDouche;
 private int nbrShampoing;
 private int nbrPapier ;
 private int nbrDesLinges;
 private String nettoyerr ;
 private int nbrProduitSol ;
 private int nbrProduitMachine;

 public int getNbrProduitMachine() {
	return nbrProduitMachine;
}
public void setNbrProduitMachine(int nbrProduitMachine) {
	this.nbrProduitMachine = nbrProduitMachine;
}
public int getNbrProduitSol() {
	return nbrProduitSol;
}
public void setNbrProduitSol(int nbrProduitSol) {
	this.nbrProduitSol = nbrProduitSol;
}
private LocalDate date ;


 
 
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
public String getNettoyerr() {
	return nettoyerr;
}
public void setNettoyerr(String nettoyerr) {
	this.nettoyerr = nettoyerr;
}
public int getNbrGelDouche() {
	return nbrGelDouche;
}
public void setNbrGelDouche(int nbrGelDouche) {
	this.nbrGelDouche = nbrGelDouche;
}
public int getNbrShampoing() {
	return nbrShampoing;
}
public void setNbrShampoing(int nbrshampoing) {
	this.nbrShampoing = nbrshampoing;
}
public int getNbrPapier() {
	return nbrPapier;
}
public void setNbrPapier(int nbrPapier) {
	this.nbrPapier = nbrPapier;
}
public int getNbrDesLinges() {
	return nbrDesLinges;
}
public void setNbrDesLinges(int nbrDesLinges) {
	this.nbrDesLinges = nbrDesLinges;
}

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

public Integer getNumero() {
	return numero;
}
public void setNumero(Integer numero) {
	this.numero = numero;
}
public int getEtage() {
	return etage;
}
public void setEtage(int etage) {
	this.etage = etage;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getVue() {
	return vue;
}
public void setVue(String vue) {
	this.vue = vue;
}
public boolean isReserver() {
	return reserver;
}
public void setReserver(boolean reservee) {
	this.reserver = reservee;
}

public boolean isNettoyer() {
	return nettoyer;
}
public void setNettoyer(boolean nettoyer) {
	this.nettoyer = nettoyer;
}


}

