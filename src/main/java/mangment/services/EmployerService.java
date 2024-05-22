package mangment.services;

import java.util.List;

import org.springframework.stereotype.Service;

import mangment.entities.Chambre;
import mangment.entities.Employer;

@Service
public interface EmployerService {
	 List<Employer> findEmployersByHotelId(Long hotelId);
	 List<Employer>getEmployesByRoleFemmeDeMenageAndByHotelId(String role,Long idHotel);
	 Employer affecterEmployerAChambre(Long idEmployer, List<Chambre> chambres);
}
