package mangment.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String image;
    @ElementCollection
    private List<Long> idImage = new ArrayList<>();
    public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	private int nombreChambres;
    private String emplacementVille;
    private int nombrePiscines;
    private int nombreTerrains;
    private String parking;
    private String  resto;
    private String coindecoffe ;
    private String activitéetanimation;
    private boolean active;
    private double prixAllInclusif;
    private double prixDemiPension;
    private double prixPensionComplete;
    private double prixPetitDej;
    private double typeDouble;
    private double typeSuite;
    private double typeTriple;
    private double typleSingle;
    private double prixPersonne;
    private double prixVueSurMer;
    private double prixVueNormal;
    private double prixVueMontagne;
    private double prixVuePiscine;
    private String description;
	@ManyToOne
	@JoinColumn
	private Region region;

    public double getPrixVueSurMer() {
		return prixVueSurMer;
	}
	public void setPrixVueSurMer(double prixVueSurMer) {
		this.prixVueSurMer = prixVueSurMer;
	}
	public double getPrixVueNormal() {
		return prixVueNormal;
	}
	public void setPrixVueNormal(double prixVueNormal) {
		this.prixVueNormal = prixVueNormal;
	}
	public double getPrixVueMontagne() {
		return prixVueMontagne;
	}
	public void setPrixVueMontagne(double prixVueMontagne) {
		this.prixVueMontagne = prixVueMontagne;
	}
	public double getPrixVuePiscine() {
		return prixVuePiscine;
	}
	public void setPrixVuePiscine(double prixVuePiscine) {
		this.prixVuePiscine = prixVuePiscine;
	}
	
  
public double getPrixPersonne() {
		return prixPersonne;
	}
	public void setPrixPersonne(double prixPersonne) {
		this.prixPersonne = prixPersonne;
	}
public double getTypeDouble() {
		return typeDouble;
	}
	public void setTypeDouble(double typeDouble) {
		this.typeDouble = typeDouble;
	}
	public double getTypeSuite() {
		return typeSuite;
	}
	public void setTypeSuite(double typeSuite) {
		this.typeSuite = typeSuite;
	}
	public double getTypeTriple() {
		return typeTriple;
	}
	public void setTypeTriple(double typeTriple) {
		this.typeTriple = typeTriple;
	}
	public double getTypleSingle() {
		return typleSingle;
	}
	public void setTypleSingle(double typleSingle) {
		this.typleSingle = typleSingle;
	}
public double getPrixAllInclusif() {
		return prixAllInclusif;
	}
	public void setPrixAllInclusif(double prixAllInclusif) {
		this.prixAllInclusif = prixAllInclusif;
	}
	public double getPrixDemiPension() {
		return prixDemiPension;
	}
	public void setPrixDemiPension(double prixDemiPension) {
		this.prixDemiPension = prixDemiPension;
	}
	public double getPrixPensionComplete() {
		return prixPensionComplete;
	}
	public void setPrixPensionComplete(double prixPensionComplete) {
		this.prixPensionComplete = prixPensionComplete;
	}
	public double getPrixPetitDej() {
		return prixPetitDej;
	}
	public void setPrixPetitDej(double prixPetitDej) {
		this.prixPetitDej = prixPetitDej;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getNombreChambres() {
		return nombreChambres;
	}
	public void setNombreChambres(int nombreChambres) {
		this.nombreChambres = nombreChambres;
	}
	public String getEmplacementVille() {
		return emplacementVille;
	}
	public void setEmplacementVille(String emplacementVille) {
		this.emplacementVille = emplacementVille;
	}
	public int getNombrePiscines() {
		return nombrePiscines;
	}
	public void setNombrePiscines(int nombrePiscines) {
		this.nombrePiscines = nombrePiscines;
	}
	public int getNombreTerrains() {
		return nombreTerrains;
	}
	public void setNombreTerrains(int nombreTerrains) {
		this.nombreTerrains = nombreTerrains;
	}
	
	public String getParking() {
		return parking;
	}
	public void setParking(String parking) {
		this.parking = parking;
	}
	public String getResto() {
		return resto;
	}
	public void setResto(String resto) {
		this.resto = resto;
	}
	public String getCoindecoffe() {
		return coindecoffe;
	}
	public void setCoindecoffe(String coindecoffe) {
		this.coindecoffe = coindecoffe;
	}
	public String getActivitéetanimation() {
		return activitéetanimation;
	}
	public void setActivitéetanimation(String activitéetanimation) {
		this.activitéetanimation = activitéetanimation;
	}
	public boolean isActive() {
		return active;
	}
	public void setIsActive(boolean active) {
		this.active = active;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}
}
	