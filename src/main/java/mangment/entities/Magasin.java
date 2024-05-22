package mangment.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Magasin {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private int nbrGelDouche;
  private int nbrShampoing;
  private int nbrPapier;
  private int nbrProduitMachine;
  private int nbrProduitSol;
  @OneToOne
  @JoinColumn(name = "hotel_id")
  private Hotel hotel;

  public int getNbrGelDouche() {
    return nbrGelDouche;
  }

  public void setNbrGelDouche(int nbrGelDouche) {
    this.nbrGelDouche = nbrGelDouche;
  }

  public int getNbrShampoing() {
    return nbrShampoing;
  }

  public void setNbrShampoing(int nbrShampoing) {
    this.nbrShampoing = nbrShampoing;
  }

  public int getNbrPapier() {
    return nbrPapier;
  }

  public void setNbrPapier(int nbrPapier) {
    this.nbrPapier = nbrPapier;
  }

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

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Hotel getHotel() {
    return hotel;
  }

  public void setHotel(Hotel hotel) {
    this.hotel = hotel;
  }
}
