package mangment.services.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;


import mangment.entities.Magasin;
import mangment.entity.MagasinRequest;
import mangment.repository.MagasinRepository;
import mangment.services.MagasinService;
@Service
public class MagasinServiceImpl  implements MagasinService {
	
	@Autowired
    private MagasinRepository magasinRepository;
	@Autowired
    private ChambreServiceImpl chambreServiceImpl;
    @Override
    public Magasin findMagasinByHotelId(Long hotelId) {
        return magasinRepository.findByHotelId(hotelId);
    }	



@Override
public Magasin mettreAJourStockMagasin(Long idHotel, LocalDate date) {
    List<Integer> sommesQuantitesProduits = chambreServiceImpl.getQuantitesProduitsToutesChambres(idHotel, date);
    Magasin magasin = findMagasinByHotelId(idHotel);

    magasin.setNbrShampoing(magasin.getNbrShampoing() - sommesQuantitesProduits.get(0));
    magasin.setNbrGelDouche(magasin.getNbrGelDouche() - sommesQuantitesProduits.get(1));
    magasin.setNbrPapier(magasin.getNbrPapier() - sommesQuantitesProduits.get(2));
    magasin.setNbrProduitSol(magasin.getNbrProduitSol() - sommesQuantitesProduits.get(4));
    magasin.setNbrProduitMachine(magasin.getNbrProduitMachine() - sommesQuantitesProduits.get(5));

  return  magasinRepository.save(magasin);
}


@Override
public Magasin Ajouter(Long idHotel, MagasinRequest magasinRequest) {
    Magasin magasin = findMagasinByHotelId(idHotel);
   
    int nouvelleQuantiteGelDouche = magasinRequest.getNbrGelDouche();
    int nouvelleQuantiteShampoing = magasinRequest.getNbrShampoing();
    int nouvelleQuantitePapier = magasinRequest.getNbrPapier();
    int nouvelleQuantiteProduitMachine = magasinRequest.getNbrProduitMachine();
    int nouvelleQuantiteProduitSol = magasinRequest.getNbrProduitSol();

    magasin.setNbrGelDouche(magasin.getNbrGelDouche() + nouvelleQuantiteGelDouche);
    magasin.setNbrShampoing(magasin.getNbrShampoing() + nouvelleQuantiteShampoing);
    magasin.setNbrPapier(magasin.getNbrPapier() + nouvelleQuantitePapier);
    magasin.setNbrProduitMachine(magasin.getNbrProduitMachine() + nouvelleQuantiteProduitMachine);
    magasin.setNbrProduitSol(magasin.getNbrProduitSol() + nouvelleQuantiteProduitSol);

    return magasinRepository.save(magasin);
}

}