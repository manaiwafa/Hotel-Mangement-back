package mangment.repository;

import java.util.Optional;
import mangment.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

  Optional<Utilisateur> findUtilisateurByEmailAndMotDePasseAndHotelNom(String email,
                                                                       String motDePasse,
                                                                       String codeHotel);

  Optional<Utilisateur> findUtilisateurByEmailAndMotDePasseAndRoleIsNotNull(String email, String motDePasse
         ); 
}

