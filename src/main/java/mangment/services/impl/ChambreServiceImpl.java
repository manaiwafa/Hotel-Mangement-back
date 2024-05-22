package mangment.services.impl;
import java.time.LocalDate;
import java.util.List;
import mangment.repository.ChambreRepository;
import mangment.entities.Chambre;
import mangment.repository.ReservationRepository;
import mangment.services.ChambreService;

import org.springframework.stereotype.Service;


@Service
public class ChambreServiceImpl implements ChambreService {
	 
  private final ChambreRepository chambreRepository;
  private final ReservationRepository reservationRepository;
  private static final String PROPRE = "Propre";
  private static final String NNNETTOYER = "nn nettoyer";


  public ChambreServiceImpl(ChambreRepository chambreRepository,
                            ReservationRepository reservationRepository) {
    this.chambreRepository = chambreRepository;
    this.reservationRepository = reservationRepository;
  }

  @Override
  public Chambre addChambre(Chambre chambre) {
	  chambre.setDate(LocalDate.now());
    return chambreRepository.save(chambre);
  }

  @Override
  public List<Chambre> findByHotelId(Long id) {
    return chambreRepository.findByHotelId(id);
  }


  @Override
  public Chambre findById(Long id) {
    return chambreRepository.findById(id).orElse(null);
  }

  @Override
  public void deleteChambre(Long id) {
    chambreRepository.deleteById(id);
  }

 

  @Override
  public List<Chambre> findRoomForCleaning(Long idHotel) {
    return reservationRepository.findAllByRoomForCleaning(idHotel, "accepter", LocalDate.now());
  }
 

@Override
public List<Chambre> findAvailableChambres(Long hotelId, LocalDate dateArrivee, LocalDate dateDepart) {
	// TODO Auto-generated method stub
   return chambreRepository.findAvailableChambres(hotelId, dateArrivee, dateDepart);
}


@Override
public Chambre verifierChambre(Long chambreId) {
  Chambre chambre = findById(chambreId);
  chambre.setNettoyerr(PROPRE);
  return chambreRepository.save(chambre);
}
@Override
public List<Chambre> verifierChambres(List<Chambre> chambres) {
    for (Chambre chambre : chambres) {
        chambre.setNettoyerr(NNNETTOYER);
    }
    return chambreRepository.saveAll(chambres);
}


@Override
public List<Integer> getQuantitesProduitsToutesChambres(Long idHotel,LocalDate date) {
    List<Chambre> chambres = chambreRepository.findByHotelIdAndDate(idHotel,  date);
    int totalShampoing = 0;
    int totalGelDouche = 0;
    int totalPapier = 0;
    int totalDesLinges = 0;
    int totalProduitSol=0;
    int totalProduitMachine = 0;
    
    for (Chambre chambre : chambres) {
        totalShampoing += chambre.getNbrShampoing();
        totalGelDouche += chambre.getNbrGelDouche();
        totalPapier += chambre.getNbrPapier();
        totalDesLinges += chambre.getNbrDesLinges();
        totalProduitSol += chambre.getNbrProduitSol();
        totalProduitMachine += totalDesLinges / 12; 
        if ( totalProduitMachine % 12 > 0) { 
            totalProduitMachine++; 
        }
    }

    List<Integer> sommesQuantitesProduits = List.of(totalShampoing, totalGelDouche, totalPapier, totalDesLinges, totalProduitSol, totalProduitMachine);
    return sommesQuantitesProduits;
}




}








