package mangment.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import mangment.entities.Chambre;
import mangment.entities.Employer;
@Service
public interface HistoriqueServices {
	 Employer affecterEmployerAChambre(Long idEmployer, List<Chambre> chambres, LocalDate Date );

	List<Chambre> getChambresByEmployerAndDate(Long idEmployer, LocalDate date);

	 

}
