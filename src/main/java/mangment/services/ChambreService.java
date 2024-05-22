package mangment.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import mangment.entities.Chambre;

@Service
public interface ChambreService {
	 Chambre addChambre(Chambre chambre);
	 List<Chambre> findByHotelId(Long id);
	 Chambre findById(Long id);
	 void deleteChambre(Long id);
	 List<Chambre> findRoomForCleaning(Long idHotel);
	 List<Chambre> findAvailableChambres(Long hotelId, LocalDate dateArrivee, LocalDate dateDepart);
		Chambre verifierChambre(Long chambreId);
	List<Chambre> verifierChambres(List<Chambre> chambres);
	List<Integer> getQuantitesProduitsToutesChambres(Long idHotel,LocalDate date);
}