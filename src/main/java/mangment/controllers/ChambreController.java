package mangment.controllers;
import jakarta.persistence.Tuple;
import java.time.LocalDate;
import java.util.List;
import mangment.entities.Chambre;
import mangment.model.RoomPriceDto;
import mangment.repository.ChambreRepository;
import mangment.services.ChambreService;
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
@RequestMapping("/chambres")

public class ChambreController {

  private final ChambreService chambreServiceImpl;
  private final ChambreRepository chambreRepository;

  public ChambreController(ChambreService chambreServiceImpl, ChambreRepository chambreRepository) {
    this.chambreServiceImpl = chambreServiceImpl;
    this.chambreRepository = chambreRepository;
  }

  @PostMapping
  public Chambre addChambre(@RequestBody Chambre chambre) {
	  chambre.setDate(LocalDate.now());

    return chambreRepository.save(chambre);
  }

  @GetMapping("/{id}")
  public Chambre findChambreById(@PathVariable Long id) {
    return chambreRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("chambre not found with this id:- " + id));
  }

  @GetMapping("/hotel/{id}")
  public List<Chambre> findCHambreByHotel(@PathVariable Long id) {
    return chambreServiceImpl.findByHotelId(id);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<String> deleteChambre(@PathVariable Long id) {
    chambreServiceImpl.deleteChambre(id);
    return ResponseEntity.ok("La chambre a été supprimée avec succès");
  }

  @GetMapping("/hotel/{hotelId}/forCleaning")
  public List<Chambre> findAllRoomForCleaning(@PathVariable Long hotelId) {
    return chambreServiceImpl.findRoomForCleaning(hotelId);
  }
  @GetMapping("/disponibles/{hotelId}/{dateArrivee}/{dateDepart}")
  public List<Chambre> getChambresDisponibles(@PathVariable Long hotelId, @PathVariable LocalDate dateArrivee, @PathVariable  LocalDate dateDepart) {
      return chambreServiceImpl.findAvailableChambres(hotelId, dateArrivee, dateDepart);
  } 
  @PutMapping("/verifier/{chambreId}")
  public Chambre verifierChambre(@PathVariable Long chambreId) {
    return chambreServiceImpl.verifierChambre(chambreId);
  }

  @PutMapping("/verification")
  public ResponseEntity<List<Chambre>> verifierChambres(
          @RequestBody List<Chambre> chambres) {
      List<Chambre> chambresVerifiees = chambreServiceImpl.verifierChambres(chambres);
      return ResponseEntity.ok().body(chambresVerifiees);
  }
 
  @GetMapping("/{idHotel}/quantites-produits")
  public List<Integer> getQuantitesProduitsToutesChambres(@PathVariable Long idHotel) {
	  LocalDate date = LocalDate.now();
	  return chambreServiceImpl.getQuantitesProduitsToutesChambres(idHotel,date);
  }

  @GetMapping("/{idHotel}/reservation/{type}")
  public List<RoomPriceDto> findRoomToReservation(@PathVariable Long idHotel, @PathVariable String type) {
    return chambreRepository.findRoomToReservation(idHotel,type);

  }
  
}
