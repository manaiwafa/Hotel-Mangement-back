package mangment.controllers;


import java.util.List;
import mangment.repository.EmployerRepository;
import mangment.entities.Chambre;
import mangment.entities.Employer;
import mangment.services.EmployerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employers")
public class EmployerController {

  private final EmployerService employerServiceImp;
  private final EmployerRepository employerRepository;
      

  public EmployerController(EmployerService employerServiceImp,
                            EmployerRepository employerRepository
                            ) {
    this.employerServiceImp = employerServiceImp;
    this.employerRepository = employerRepository;
  }

  @PostMapping("/")
  public Employer addEmployer(@RequestBody Employer employer) {
	  return employerRepository.save(employer);
  }

  @GetMapping("/{id}")
  public Employer findEmployerById(@PathVariable Long id) {
    return employerRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Employer not found with this id:- " + id));
  }

  @GetMapping("/hotel/{hotelId}")
  public List<Employer> findEmployersByHotelId(@PathVariable Long hotelId) {
    return employerServiceImp.findEmployersByHotelId(hotelId);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<String> deleteEmployer(@PathVariable Long id) {
    employerRepository.deleteById(id);
    return ResponseEntity.ok("L'Employer a été supprimée avec succès");
  }
  @GetMapping("/{role}/{hotelId}")
  public List<Employer> getEmployesByRoleAndHotelId(@PathVariable("role") String role, @PathVariable("hotelId") Long hotelId) {
      return employerServiceImp.getEmployesByRoleFemmeDeMenageAndByHotelId(role, hotelId);
  }
  
  @PostMapping("/{idEmployer}")
	public Employer AddEmployerAChambre(@PathVariable Long idEmployer, @RequestBody List<Chambre> chambres) {
		return employerServiceImp.affecterEmployerAChambre( idEmployer, chambres) ;
	} 

  
 
}
