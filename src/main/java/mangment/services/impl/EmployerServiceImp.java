package mangment.services.impl;

import java.util.List;
import mangment.repository.EmployerRepository;
import mangment.entities.Chambre;
import mangment.entities.Employer;

import mangment.services.EmployerService;
import org.springframework.stereotype.Service;

@Service
public class EmployerServiceImp implements EmployerService {


  private final EmployerRepository employerRepository;


  public EmployerServiceImp(EmployerRepository employerRepository ) {
    this.employerRepository = employerRepository;
  }

  @Override
  public List<Employer> findEmployersByHotelId(Long hotelId) {
    return employerRepository.findEmployersByHotelId(hotelId);
  }

  @Override
  public List<Employer> getEmployesByRoleFemmeDeMenageAndByHotelId(String role, Long idHotel) {
      return employerRepository.findEmployersByRoleAndHotelId("femme_menage", idHotel);
  }

@Override
public Employer affecterEmployerAChambre(Long idEmployer, List<Chambre> chambres) {
	Employer employer= employerRepository.findById(idEmployer)
			.orElseThrow(()-> new RuntimeException("employer not found with this id:- " + idEmployer));
	employer.setChambres(chambres);

    employerRepository.save(employer);
    
    return employer;

}}



   



