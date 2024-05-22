package mangment.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.sql.Date;
import java.time.LocalDateTime;


@Entity
public class Reservation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Date dateArrivee;
  private Date dateDepart;
  private int nombreClients;
  private int nombreEnfant = 0;
  private String vue;
  private String type;
  private String repas;
  private String nom;
  private String prenom;
  private int cin;
  private int telephone;
  private String email;
  private String status = "en cours";
  private LocalDateTime createdDate = LocalDateTime.now();
  private int prix;
 
  public int getPrix() {
	return prix;
}

public void setPrix(int prix) {
	this.prix = prix;
}

@ManyToOne
  @JoinColumn(name = "chambre_id")
  private Chambre chambre;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
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

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public int getCin() {
    return cin;
  }

  public void setCin(int cin) {
    this.cin = cin;
  }

  public int getTelephone() {
    return telephone;
  }

  public void setTelephone(int telephone) {
    this.telephone = telephone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getDateArrivee() {
    return dateArrivee;
  }

  public void setDateArrivee(Date dateArrivee) {
    this.dateArrivee = dateArrivee;
  }

  public Date getDateDepart() {
    return dateDepart;
  }

  public void setDateDepart(Date dateDepart) {
    this.dateDepart = dateDepart;
  }

  public int getNombreClients() {
    return nombreClients;
  }

  public void setNombreClients(int nombreClients) {
    this.nombreClients = nombreClients;
  }

  public String getVue() {
    return vue;
  }

  public void setVue(String vue) {
    this.vue = vue;
  }

  public String getRepas() {
    return repas;
  }

  public void setRepas(String repas) {
    this.repas = repas;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Chambre getChambre() {
    return chambre;
  }

  public void setChambre(Chambre chambre) {
    this.chambre = chambre;
  }
  public LocalDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDateTime createdDate) {
    this.createdDate = createdDate;
  }

  public int getNombreEnfant() {
    return nombreEnfant;
  }

  public void setNombreEnfant(int nombreEnfant) {
    this.nombreEnfant = nombreEnfant;
  }
}