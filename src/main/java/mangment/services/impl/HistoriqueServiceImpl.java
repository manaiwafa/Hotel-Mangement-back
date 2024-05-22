package mangment.services.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mangment.entities.Chambre;
import mangment.entities.Employer;
import mangment.entities.Historique;
import mangment.repository.EmployerRepository;
import mangment.repository.HistoriqueRepository;
import mangment.services.HistoriqueServices;
@Service
public class HistoriqueServiceImpl  implements HistoriqueServices{
	 @Autowired
	    private HistoriqueRepository historiqueRepository;

	    @Autowired
	    private EmployerRepository employerRepository;

	    
	    @Override
	    public Employer affecterEmployerAChambre(Long idEmployer, List<Chambre> chambres, LocalDate date) {
	        Employer employer = employerRepository.findById(idEmployer)
	                .orElseThrow(() -> new RuntimeException("Employer not found with this id: " + idEmployer));

	        Historique historique = new Historique();
	        historique.setEmployer(employer);
	        historique.setChambres(chambres);
	        historique.setDate(date); 
	        historiqueRepository.save(historique);

	        employer.setChambres(chambres);
	        employerRepository.save(employer);

	        return employer;
	    }
	 @Override   
	    public List<Chambre> getChambresByEmployerAndDate(Long idEmployer, LocalDate date) {
	        Employer employer = employerRepository.findById(idEmployer)
	                .orElseThrow(() -> new RuntimeException("Employer not found with this id: " + idEmployer));
	        
	        List<Historique> historiques = historiqueRepository.findByEmployerAndDate(employer, date);
             List<Chambre> chambres = new ArrayList<>();
	        for (Historique historique : historiques) {
	            chambres.addAll(historique.getChambres());
	        }
	        
	        return chambres;
	    }


}
