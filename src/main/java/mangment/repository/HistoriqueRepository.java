package mangment.repository;



import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mangment.entities.Employer;
import mangment.entities.Historique;

@Repository
public interface HistoriqueRepository extends JpaRepository<Historique, Long> {

	List<Historique> findByEmployerAndDate(Employer idEmployer, LocalDate date);
  
}
